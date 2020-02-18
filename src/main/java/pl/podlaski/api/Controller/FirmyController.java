package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Role;
import pl.podlaski.api.LogowanieForma;
import pl.podlaski.api.Service.FirmyService;
import pl.podlaski.api.Service.RoleService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.util.List;



@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/firmy")
public class FirmyController {

    private FirmyService firmyService;
    private RoleService roleService;

    @Autowired
    public FirmyController(FirmyService firmyService) {
        this.firmyService = firmyService;
    }

    @GetMapping("/")
    ResponseEntity<List<Firma>> getAll() {
        List<Firma> bookingList = firmyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookingList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findFirma(@PathVariable("id") Long id) {
        Firma firma = null;
        try {
            firma = firmyService.findOne(id);
            log.info("Firma o id '{}' znaleziony", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(firma);
    }

    @GetMapping("/logowanie")
    public ResponseEntity<Firma> logowanieFirma(@RequestBody LogowanieForma logowanieForma) {
        Firma firma = null;
        try {
            firma = firmyService.logIn(logowanieForma.getEmail(), logowanieForma.getHaslo());
            if(firma==null){return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            log.info("Brak użytkownika o mailu " + logowanieForma.getEmail() + "Lub hasło nieprawidłowe");
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(firma);
    }

    @PostMapping(value = "/Register")
    public ResponseEntity<Firma> addFirma(@RequestBody Firma firma) {
        Role role = roleService.findByName("FIRMA");
        firma.setRoleFirmy(role);
        firmyService.save(firma);
        log.info("Firma {} dodana", firma.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(firma);
    }

    @PutMapping(value = "/{id}")
    public Firma updateFirma(@PathVariable(value = "id") Long id,@RequestBody Firma firma) {

        Firma firmaToUptade = null;
        try{
            firmaToUptade = firmyService.findOne(id);
            firmaToUptade.setNazwafirmy(firma.getNazwafirmy());
            firmaToUptade.setNip(firma.getNip());
            firmaToUptade.setTelefonkontaktowy(firma.getTelefonkontaktowy());
            firmaToUptade.setMiasto(firma.getMiasto());
            firmaToUptade.setUlica(firma.getUlica());
            firmaToUptade.setNrdomu(firma.getNrdomu());
            firmaToUptade.setEmail(firma.getEmail());
            firmaToUptade.setHaslo(firma.getHaslo());
            firmaToUptade.setNumerkonta(firma.getNumerkonta());
            firmaToUptade.setRoleFirmy(firma.getRoleFirmy());

        }catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        firmyService.update(firmaToUptade);
        log.info("Zaktualizowano dane firmy :'{}'", firmaToUptade.toString());
        ResponseEntity.status(HttpStatus.OK).body(firmaToUptade);
        return firmyService.update(firmaToUptade);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFirma(@PathVariable(value = "id") @NotBlank Long id) {
        try {
            firmyService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Firma o id '{}' został usunięty", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
