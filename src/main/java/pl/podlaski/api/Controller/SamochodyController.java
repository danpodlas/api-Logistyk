package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.Service.SamochodyService;

import javax.validation.constraints.NotBlank;

@Slf4j
@RestController
@RequestMapping("/api/samochody")
public class SamochodyController {
    //TODO update
    private SamochodyService samochodyService;

    @Autowired
    public SamochodyController(SamochodyService samochodyService) {
        this.samochodyService = samochodyService;
    }

    @GetMapping("/")
    public Iterable<Samochod> getAll(){
        return  samochodyService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Samochod> get(@PathVariable Long id) {
        return new ResponseEntity(this.samochodyService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public Samochod addSamochod(@RequestBody Samochod samochod){
        log.info("Dodano samochód: Marka:'{}', Model:'{}', Rejestracja'{}'", samochod.getMarka(), samochod.getModel(), samochod.getNumerrejestracyjny());
        return  samochodyService.save(samochod);
    }

    @PutMapping(value = "/{id}")
    public Samochod updateSamochod(@RequestBody Samochod samochod){
        log.info("Zaktualizowano samochód: id:'{}', Marka:'{}', Model:'{}', Rejestracja'{}'",samochod.getId(), samochod.getMarka(), samochod.getModel(), samochod.getNumerrejestracyjny());
        return  samochodyService.save(samochod);
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
