package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Koszty;
import pl.podlaski.api.DAO.Entity.Role;
import pl.podlaski.api.Service.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/koszty")
public class KosztyController {

    private KosztyService kosztyService;
    private SamochodyService samochodyService;
    private FirmyService firmyService;
    private KierowcyService kierowcyService;

    @Autowired
    public KosztyController(KosztyService kosztyService) {
        this.kosztyService = kosztyService;
    }

    @GetMapping("/")
    ResponseEntity<List<Koszty>> getAll() {
        List<Koszty> bookingList = kosztyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookingList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findKoszty(@PathVariable("id") Long id) {
        Koszty koszty = null;
        try {
            koszty = kosztyService.findOne(id);
            log.info("Koszty o id '{}' znaleziony", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(koszty);
    }

    @GetMapping(value = "/samochod/{id}")
    public ResponseEntity findAutoKoszty(@PathVariable("id") Long id) {
        Optional<Koszty> koszty = null;
        try {
            koszty = kosztyService.findSamochod(id);
            log.info("Samochód,koszty with id '{}' found", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(koszty);
    }

    @GetMapping(value = "/firma/{id}")
    public ResponseEntity findFrimaKoszty(@PathVariable("id") Long id) {
        Optional<Koszty> koszty = null;
        try {
            koszty = kosztyService.findFirma(id);
            log.info("Firma, koszty with id '{}' found", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(koszty);
    }

    @GetMapping(value = "/kierowca/{id}")
    public ResponseEntity findKierowcaKoszty(@PathVariable("id") Long id) {
        Optional<Koszty> koszty = null;
        try {
            koszty = kosztyService.findKierowca(id);
            log.info("Kierowca, koszty with id '{}' found", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(koszty);
    }

    @PostMapping
    public ResponseEntity<Koszty> addKoszty(@RequestBody Koszty koszty) {
        kosztyService.save(koszty);
        log.info("Koszty {} dodane", koszty.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(koszty);
    }


    @PutMapping(value = "/{id}")
    public Koszty updateKoszty(@PathVariable(value = "id") Long id,@RequestBody Koszty koszty) {

        Koszty kosztyToUptade = null;
        try{
            kosztyToUptade = kosztyService.findOne(id);
            kosztyToUptade.setSamochodKoszty(koszty.getSamochodKoszty());
            kosztyToUptade.setRadzajekosztow(koszty.getRadzajekosztow());
            kosztyToUptade.setKwota(koszty.getKwota());
            kosztyToUptade.setData(koszty.getData());
            kosztyToUptade.setNotka(koszty.getNotka());
            kosztyToUptade.setKosztyFirmy(koszty.getKosztyFirmy());
            kosztyToUptade.setKosztyKierowca(koszty.getKosztyKierowca());

        }catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        kosztyService.update(kosztyToUptade);
        log.info("Zaktualizowano dane kosztów :'{}'", kosztyToUptade.toString());
        ResponseEntity.status(HttpStatus.OK).body(kosztyToUptade);
        return kosztyService.update(kosztyToUptade);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteKoszty(@PathVariable(value = "id") @NotBlank Long id) {
        try {
            kosztyService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Koszty o id '{}' został usunięty", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
