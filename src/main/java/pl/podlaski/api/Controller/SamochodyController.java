package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.Service.SamochodyService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/samochody")
public class SamochodyController {

    private SamochodyService samochodyService;

    @Autowired
    public SamochodyController(SamochodyService samochodyService) {
        this.samochodyService = samochodyService;
    }

    @GetMapping("/")
    ResponseEntity<List<Samochod>> getAll() {
        List<Samochod> samochodList = samochodyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(samochodList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findSamochod(@PathVariable("id") Long id) {
        Samochod samochod = null;
        try {
            samochod = samochodyService.findOne(id);
            log.info("Samochod o id '{}' znaleziony", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(samochod);
    }

    @PostMapping
    public ResponseEntity<Samochod> addSamochod(@RequestBody Samochod samochod) {
              samochodyService.save(samochod);
        log.info("Samochod {} dodany", samochod.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(samochod);
    }

    @PutMapping(value = "/{id}")
    public Samochod updateSamochod(@RequestBody Samochod samochod){
        log.info("Zaktualizowano samochód: id:'{}', Marka:'{}', Model:'{}', Rejestracja'{}'",samochod.getId(), samochod.getMarka(), samochod.getModel(), samochod.getNumerrejestracyjny());
        return  samochodyService.save(samochod);
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
