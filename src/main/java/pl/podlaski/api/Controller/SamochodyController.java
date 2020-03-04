package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Role;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.Service.FirmyService;
import pl.podlaski.api.Service.KierowcyService;
import pl.podlaski.api.Service.SamochodyService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/samochody")
public class SamochodyController {

    private SamochodyService samochodyService;
    private FirmyService firmyService;
    private KierowcyService kierowcyService;

    @Autowired
    public SamochodyController(SamochodyService samochodyService, FirmyService firmyService, KierowcyService kierowcyService) {
        this.samochodyService = samochodyService;
        this.firmyService = firmyService;
        this.kierowcyService = kierowcyService;
    }

    @GetMapping("/")
    ResponseEntity<List<Samochod>> getAll() {
        List<Samochod> samochodList = samochodyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(samochodList);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findCar(@PathVariable("id") Long id) {
        Optional<Samochod> samochod = null;
        try {
            samochod = samochodyService.findId(id);
            log.info("Car with id '{}' found", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(samochod);
    }

    @PostMapping(path = "/add/id={id}&rola={rola}")
    public ResponseEntity<?> addSamochod(@PathVariable("id") Long id, @PathVariable("rola") String rola, @RequestBody Samochod samochod) {
        log.info("---------------------------------------------------");
        samochodyService.save(samochod);

        if (rola.equals("Firmy")) {
            Firma firmaToUptade = null;
            try {
                firmaToUptade = firmyService.findOne(id);

                firmaToUptade.setSamochod(samochodyService.findOne(samochod.getId()));

            } catch (EntityNotFoundException e) {
                log.error(e.getMessage());
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            firmyService.update(firmaToUptade);
            log.info("Firma o id "+id+" dodał samochód {}", samochod.toString());

        } else if (rola.equals("Kierowca")) {
            Kierowca kierowcaToUptade = null;
            try {
                kierowcaToUptade = kierowcyService.findOne(id);

                kierowcaToUptade.setSamochod(samochodyService.findOne(samochod.getId()));

            } catch (EntityNotFoundException e) {
                log.error(e.getMessage());
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            kierowcyService.update(kierowcaToUptade);
            log.info("Kierowca o id "+id+" dodał samochód {}", samochod.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(samochod);
    }

    @PutMapping(value = "/{id}")
    public Samochod updateSamochod(@RequestBody Samochod samochod) {
        log.info("Zaktualizowano samochód: id:'{}', Marka:'{}', Model:'{}', Rejestracja'{}'", samochod.getId(), samochod.getMarka(), samochod.getModel(), samochod.getNumerrejestracyjny());
        return samochodyService.save(samochod);
    }

    public Samochod updateSamochod(@PathVariable(value = "id") Long id, @RequestBody Samochod samochod) {

        Samochod samochodtoUpdate = null;
        try {
            samochodtoUpdate = samochodyService.findOne(id);
            samochodtoUpdate.setMarka(samochod.getMarka());
            samochodtoUpdate.setModel(samochod.getModel());
            samochodtoUpdate.setRokprodukcji(samochod.getRokprodukcji());
            samochodtoUpdate.setPrzebieg(samochod.getPrzebieg());
            samochodtoUpdate.setRokprodukcji(samochod.getRokprodukcji());
            samochodtoUpdate.setTyppojazdu(samochod.getTyppojazdu());
            samochodtoUpdate.setPrzyczepy(samochod.getPrzyczepy());

        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        samochodyService.update(samochodtoUpdate);
        log.info("Zaktualizowano dane samochodu :'{}'", samochodtoUpdate.toString());
        ResponseEntity.status(HttpStatus.OK).body(samochodtoUpdate);
        return samochodyService.update(samochodtoUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSamochod(@PathVariable(value = "id") @NotBlank Long id) {
        try {
            samochodyService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Samochód o id '{}' został usunięty", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
