package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.DAO.Entity.Role;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.LogowanieForma;
import pl.podlaski.api.Service.KierowcyService;
import pl.podlaski.api.Service.RoleService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/kierowca")
public class KierowcyController {

    private final RoleService roleService;
    private final KierowcyService kierowcyService;

    @Autowired
    public KierowcyController(RoleService roleService, KierowcyService kierowcyService) {
        this.roleService = roleService;
        this.kierowcyService = kierowcyService;
    }

    @GetMapping("/")
    ResponseEntity<List<Kierowca>> getAll() {
        List<Kierowca> bookingList = kierowcyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookingList);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findkierowca(@PathVariable("id") Long id) {
        Optional<Kierowca> kierowca = null;
        try {
            kierowca = kierowcyService.findId(id);
            log.info("Kierowca with id '{}' found", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(kierowca);
    }

    @GetMapping(value = "/samochod/{id}")
    public ResponseEntity findAutoKierowcy(@PathVariable("id") Long id) {
        Optional<Kierowca> kierowca = null;
        try {
            kierowca = kierowcyService.findAutoId(id);
            log.info("Kierowca with id '{}' found", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(kierowca);
    }


    @GetMapping("/logowanie")
    public ResponseEntity<Kierowca> logowanieKierowca(@RequestBody LogowanieForma logowanieForma) {
        Kierowca kierowca = null;
        try {
            kierowca = kierowcyService.logIn(logowanieForma.getEmail(), logowanieForma.getHaslo());
            return ResponseEntity.status(HttpStatus.OK).body(kierowca);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            log.info("Brak użytkownika o mailu " + logowanieForma.getEmail() + "Lub hasło nieprawidłowe");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(value = "/Register")
    public ResponseEntity<Kierowca> addKierowca(@RequestBody Kierowca kierowca) {
        Role role = roleService.findByName("KIEROWCA");
        kierowca.setRoleKierowca(role);
        kierowcyService.save(kierowca);
        log.info("Kierowca {} dodany", kierowca.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(kierowca);
    }

    @PutMapping(value = "/{id}")
    public Kierowca updateKierowca(@PathVariable(value = "id") Long id, @RequestBody Kierowca kierowca) {

        Kierowca kierowcaToUptade = null;
        try {
            kierowcaToUptade = kierowcyService.findOne(id);
            kierowcaToUptade.setImie(kierowca.getImie());
            kierowcaToUptade.setNazwisko(kierowca.getNazwisko());
            kierowcaToUptade.setPeselnip(kierowca.getPeselnip());
            kierowcaToUptade.setTelefon(kierowca.getTelefon());
            kierowcaToUptade.setMiasto(kierowca.getMiasto());
            kierowcaToUptade.setUlica(kierowca.getUlica());
            kierowcaToUptade.setNrdomu(kierowca.getNrdomu());
            kierowcaToUptade.setDatazatrudnienia(kierowca.getDatazatrudnienia());
            kierowcaToUptade.setEmail(kierowca.getEmail());
            kierowcaToUptade.setHaslo(kierowca.getHaslo());
            kierowcaToUptade.setNumerkonta(kierowca.getNumerkonta());
            kierowcaToUptade.setRoleKierowca(kierowca.getRoleKierowca());

        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        kierowcyService.update(kierowcaToUptade);
        log.info("Zaktualizowano dane kierowcy :'{}'", kierowcaToUptade.toString());
        ResponseEntity.status(HttpStatus.OK).body(kierowcaToUptade);
        return kierowcyService.update(kierowcaToUptade);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteKierowca(@PathVariable(value = "id") @NotBlank Long id) {
        try {
            kierowcyService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Kierowca o id '{}' został usunięty", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
