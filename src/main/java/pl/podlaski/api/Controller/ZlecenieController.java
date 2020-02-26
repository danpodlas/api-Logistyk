package pl.podlaski.api.Controller;

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
            zlecenie = zlecenieService.findOne(id);
            log.info("Zlecenie o id '{}' znaleziono", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie);
    }

    @PostMapping(value = "/{id}/{rola}")
    public ResponseEntity<?> addZlecenie(@PathVariable(value = "id") Long id, @PathVariable(value = "rola") String rola, @RequestBody Zlecenie zlecenie) {
        Zlecenie zlecenie1 = null;
        System.out.println("id: "+id+" rola: "+rola);

        if (rola.equals("Indywidualny")) {
            Klient klient = klientService.findId(id);
            if (klient == null) {
                System.out.println("Klient");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("klient is null");
            } else {
                zlecenie.setKlient(klient);
                System.out.println("Klient: " + klient);
            }
        }

        else if (rola.equals("Firmy")){
            Firma firma = firmyService.findId(id);
            if (firma == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("firma is null");
            } else {
                zlecenie.setZlecFirma(firma);
                System.out.println("firma: " + firma);
            }
        }
        zlecenie.setStatus("NOWE");
        zlecenie1 = zlecenieService.save(zlecenie);
        log.info("Zlecenie {} dodane", zlecenie1.toString());
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie1);
    }

    //todo
    @PostMapping(value = "/przyjmij/{id}/{rola}")
    public ResponseEntity<?> przyjmijZlecenie(@PathVariable(value = "id") Long id, @PathVariable(value = "rola") String rola, @RequestBody Zlecenie zlecenie) {
        Zlecenie zlecenie1 = null;
        System.out.println("id: "+id+" rola: "+rola);

        if (rola.equals("Kierowca")) {
            Kierowca kierowca = kierowcyService.findId(id);
            if (kierowca == null) {
                System.out.println("Klient");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("klient is null");
            } else {
                zlecenie.setKierowca(kierowca);
                System.out.println("kierowca: " + kierowca);
            }
        }

        else if (rola.equals("Firmy")){
            Firma firma = firmyService.findId(id);
            if (firma == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("firma is null");
            } else {
                zlecenie.setPrzyjmFirma(firma);
                System.out.println("firma: " + firma);
            }
        }
        zlecenie1 = zlecenieService.save(zlecenie);
        log.info("Zlecenie {} dodane", zlecenie1.toString());
        return ResponseEntity.status(HttpStatus.OK).body(zlecenie1);
    }

    @PutMapping(value = "/{id}")
    public Zlecenie updateZlecenie(@PathVariable(value = "id") Long id, @RequestBody Zlecenie zlecenie) throws ParseException {

        Zlecenie zlecenieToUpdate = null;
        try {
            zlecenieToUpdate = zlecenieService.findOne(id);

            zlecenieToUpdate.setZlecFirma(zlecenie.getZlecFirma());
            zlecenieToUpdate.setKlient(zlecenie.getKlient());
            zlecenieToUpdate.setAdreszal(zlecenie.getAdreszal());
            zlecenieToUpdate.setAdresroz(zlecenie.getAdresroz());
            zlecenieToUpdate.setPrzyjmFirma(zlecenie.getPrzyjmFirma());
            zlecenieToUpdate.setKierowca(zlecenie.getKierowca());
            zlecenieToUpdate.setOskontakt(zlecenie.getOskontakt());
            zlecenieToUpdate.setIlosckm(zlecenie.getIlosckm());
            zlecenieToUpdate.setStawka(zlecenie.getStawka());
            zlecenieToUpdate.setWartzlec(zlecenie.getWartzlec());
            zlecenieToUpdate.setTypladunku(zlecenie.getTypladunku());
            zlecenieToUpdate.setSpecjalny(zlecenie.getSpecjalny());
            zlecenieToUpdate.setWaga(zlecenie.getWaga());
            zlecenieToUpdate.setDatautworzenia(zlecenie.getDatautworzenia());
            zlecenieToUpdate.setDataprzyjecia(zlecenie.getDataprzyjecia());
            zlecenieToUpdate.setDatazakonczenia(zlecenie.getDatazakonczenia());
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        zlecenieService.update(zlecenieToUpdate);
        log.info("Zaktualizowano dane zlecenia :'{}'", zlecenieToUpdate.toString());
        ResponseEntity.status(HttpStatus.OK).body(zlecenieToUpdate);
        return zlecenieService.update(zlecenieToUpdate);
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
