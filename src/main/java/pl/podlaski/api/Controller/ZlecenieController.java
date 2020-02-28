package pl.podlaski.api.Controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Constans.RoleName;
import pl.podlaski.api.DAO.Entity.*;
import pl.podlaski.api.Service.FirmyService;
import pl.podlaski.api.Service.KierowcyService;
import pl.podlaski.api.Service.KlientService;
import pl.podlaski.api.Service.ZlecenieService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/zlecenie")
public class ZlecenieController {

    private ZlecenieService zlecenieService;
    private KlientService klientService;
    private FirmyService firmyService;
    private KierowcyService kierowcyService;

    @Autowired
    public ZlecenieController(ZlecenieService zlecenieService, KlientService klientService, FirmyService firmyService, KierowcyService kierowcyService) {
        this.zlecenieService = zlecenieService;
        this.klientService = klientService;
        this.firmyService = firmyService;
        this.kierowcyService = kierowcyService;
    }

    @GetMapping("/")
    ResponseEntity<List<Zlecenie>> getAll() {
        List<Zlecenie> bookingList = zlecenieService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookingList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findZlecenie(@PathVariable("id") Long id) {
        Zlecenie zlecenie = null;
        try {
            zlecenie = zlecenieService.findId(id);
            log.info("Zlecenie o id '{}' znaleziono", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie);
    }


    //////////////////////////////////////////////////////////////////////////
    @GetMapping(value = "/moje/id={id}")
    public ResponseEntity<List> findZlecenia(@PathVariable("id") Long id) {
        List<Zlecenie> zlecenie = null;
        try {
            zlecenie = zlecenieService.findKlientById(id);
            log.info("Zlecenia o id '{}' znaleziono", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie);
    }



    @GetMapping(value = "/new")
    public ResponseEntity<List> findNew() {
        List<Zlecenie> zlecenie = null;
        try {
            zlecenie = zlecenieService.findByStatus("FINISH");
            log.info("Zlecenia o id '{}' znaleziono");
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie);
    }

    @PostMapping(value = "/id={id}&rola={rola}")
    public ResponseEntity<?> addZlecenie(@PathVariable(value = "id") Long id, @PathVariable(value = "rola") String rola, @RequestBody Zlecenie zlecenie) {
        Zlecenie zlecenie1 = null;
        System.out.println("id: " + id + " rola: " + rola);

        if (rola.equals("Indywidualny")) {
            Klient klient = klientService.findId(id);
            if (klient == null) {
                System.out.println("Klient");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("klient is null");
            } else {
                zlecenie.setKlient(klient);
                System.out.println("Klient: " + klient);
            }
        } else if (rola.equals("Firmy")) {
            Firma firma = firmyService.findId(id);
            if (firma == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("firma is null");
            } else {
                zlecenie.setZlecFirma(firma);
                System.out.println("firma: " + firma);
            }
        }
        Date date = new Date();
        zlecenie.setDatautworzenia(date);
        zlecenie.setStatus("NOWE");
        zlecenie1 = zlecenieService.save(zlecenie);
        log.info("Zlecenie {} dodane", zlecenie1.toString());
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie1);
    }

    @PutMapping(value = "/przyjmij/idzlec={idzlec}&rola={rola}&id={id}")
    public ResponseEntity<?> przyjmijZlecenie(@PathVariable(value = "idzlec") Long idzlec, @PathVariable(value = "rola") String rola, @PathVariable(value = "id") Long id) {
        System.out.println("idzlec "+idzlec+ " id: " + id + " rola: " + rola);
        Zlecenie zlecenieToUpdate = null;
        Zlecenie zlecenie1 = null;
        zlecenieToUpdate = zlecenieService.findId(idzlec);

        Date date = new Date();
        System.out.println("Zlecenie: " + zlecenieToUpdate);
        try {
            if (rola.equals("Kierowca")) {
                Kierowca kierowca = kierowcyService.findId(id);
                if (kierowca == null) {
                    System.out.println("Kierowca");
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Kierowca is null");
                } else {
                    zlecenieToUpdate.setKierowca(kierowca);
                    System.out.println("kierowca: " + kierowca);
                }
            } else if (rola.equals("Firmy")) {
                Firma firma = firmyService.findId(id);
                if (firma == null) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("firma is null");
                } else {
                    zlecenieToUpdate.setPrzyjmFirma(firma);
                    System.out.println("firma: " + firma);
                }
            }
            zlecenieToUpdate.setStatus("W realizacji");
            zlecenieToUpdate.setDataprzyjecia(date);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        zlecenie1 = zlecenieService.update(zlecenieToUpdate);
        log.info("Zlecenie {} przyjęte", zlecenie1.toString());
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie1);
    }

    @PutMapping(value = "/zakoncz/idzlec={idzlec}")
    public ResponseEntity<?> zakonczZlecenie(@PathVariable(value = "idzlec") Long idzlec) {
        Zlecenie zlecenieToUpdate = null;
        Zlecenie zlecenie1 = null;
        zlecenieToUpdate = zlecenieService.findId(idzlec);

        Date date = new Date();
        System.out.println("Zlecenie: " + zlecenieToUpdate);
        try {
            zlecenieToUpdate.setStatus("Zakończone");
            zlecenieToUpdate.setDatazakonczenia(date);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        zlecenie1 = zlecenieService.update(zlecenieToUpdate);
        log.info("Zlecenie {} zakonczone", zlecenie1.toString());
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie1);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteZlecenie(@PathVariable(value = "id") @NotBlank Long id) {
        try {
            zlecenieService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Zlecenie o id '{}' zostało usunięte", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
