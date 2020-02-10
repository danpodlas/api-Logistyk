package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.DAO.Entity.Role;
import pl.podlaski.api.Service.KlientService;
import pl.podlaski.api.Service.RoleService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/klient")
public class KlientController {

    private KlientService klientService;
    private RoleService roleService;

    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping("/")
    ResponseEntity<List<Klient>> getAll() {
        List<Klient> bookingList = klientService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookingList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findKlient(@PathVariable("id") Long id) {
        Klient klient = null;
        try {
            klient = klientService.findOne(id);
            log.info("Klient o id '{}' znaleziony", id);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(klient);
    }

    @PostMapping
    public ResponseEntity<Klient> addKlient(@RequestBody Klient klient) {
        Role role = roleService.findByName("KLIENT");
        klient.setRole(role);
        klientService.save(klient);
        log.info("Klient {} dodany", klient.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(klient);
    }

    @PutMapping(value = "/{id}")
    public Klient updateKlient(@PathVariable(value = "id") Long id, @RequestBody Klient klient) {

        Klient klientToUptade = null;
        try {
            klientToUptade = klientService.findOne(id);
            klientToUptade.setImie(klient.getImie());
            klientToUptade.setNazwisko(klient.getNazwisko());
            klientToUptade.setPesel(klient.getPesel());
            klientToUptade.setTelefon(klient.getTelefon());
            klientToUptade.setMiasto(klient.getMiasto());
            klientToUptade.setUlica(klient.getUlica());
            klientToUptade.setNrdomu(klient.getNrdomu());
            klientToUptade.setEmail(klient.getEmail());
            klientToUptade.setHaslo(klient.getHaslo());
            klientToUptade.setRole(klient.getRole());

        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        klientService.update(klientToUptade);
        log.info("Zaktualizowano dane klienta :'{}'", klientToUptade.toString());
        ResponseEntity.status(HttpStatus.OK).body(klientToUptade);
        return klientService.update(klientToUptade);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteKlient(@PathVariable(value = "id") @NotBlank Long id) {
        try {
            klientService.delete(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Klient o id '{}' został usunięty", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
