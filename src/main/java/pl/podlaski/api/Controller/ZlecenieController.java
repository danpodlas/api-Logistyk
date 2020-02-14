package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Zlecenie;
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

    @Autowired
    public ZlecenieController(ZlecenieService zlecenieService) {
        this.zlecenieService = zlecenieService;
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

    @PostMapping
    public ResponseEntity<Zlecenie> addZlecenie(@RequestBody Zlecenie zlecenie) {
        zlecenieService.save(zlecenie);
        log.info("Zlecenie {} dodane", zlecenie.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(zlecenie);
    }

    @PutMapping(value = "/{id}")
    public Zlecenie updateZlecenie(@PathVariable(value = "id") Long id, @RequestBody Zlecenie zlecenie) throws ParseException {

        Zlecenie zlecenieToUpdate = null;
        try {
            zlecenieToUpdate = zlecenieService.findOne(id);

            zlecenieToUpdate.setZlecFirma(zlecenie.getZlecFirma());
            zlecenieToUpdate.setZlecenieKlient(zlecenie.getZlecenieKlient());
            zlecenieToUpdate.setAdreszal(zlecenie.getAdreszal());
            zlecenieToUpdate.setAdresroz(zlecenie.getAdresroz());
            zlecenieToUpdate.setPrzyjmFirma(zlecenie.getPrzyjmFirma());
            zlecenieToUpdate.setPrzyjmKierowca(zlecenie.getPrzyjmKierowca());
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
