package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.*;
import pl.podlaski.api.Service.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/koszty")
public class KosztyController {

    private KosztyService kosztyService;
    private FirmyService firmyService;
    private KierowcyService kierowcyService;

    @Autowired
    public KosztyController(KosztyService kosztyService, FirmyService firmyService, KierowcyService kierowcyService) {
        this.kosztyService = kosztyService;
        this.firmyService=firmyService;
        this.kierowcyService=kierowcyService;
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

    @GetMapping(value = "/graph/id={id}")
    public ResponseEntity<?> valueGraph(@PathVariable(value = "id") Long id) throws ParseException {
        List<Koszty> kosztyList = null;

        String patter = "dd.MM.yyyy";

        //zakres dat od pierwszy dzien miesiaca rok temu do ostatni dzien poprzedniego miesiaca
        Calendar calD = Calendar.getInstance();
        calD.add(Calendar.MONTH,-1);
        calD.set(Calendar.DATE, calD.getActualMaximum(Calendar.DATE));
        Date lastDayOfMonth = calD.getTime();
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat(patter);
        String dataDo = simpleDateFormate.format(lastDayOfMonth);
        System.out.println(dataDo);
        Date date2=new SimpleDateFormat("dd.MM.yyyy").parse(dataDo);

        Calendar calB = Calendar.getInstance();
        calB.add(Calendar.MONTH,-12);
        calB.set(Calendar.DATE, calB.getActualMinimum(Calendar.DATE));
        Date firstDayOfMonth = calB.getTime();
        SimpleDateFormat simple = new SimpleDateFormat(patter);
        String dataOd = simple.format(firstDayOfMonth);

        Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(dataOd);
        System.out.println(dataOd);

        try {
            kosztyList = kosztyService.findKosztyFirmy(id, date1, date2);
            log.info("Koszty sprzed roku znaleziono");
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(kosztyList);
    }


//    @GetMapping(value = "/samochod/{id}")
//    public ResponseEntity findAutoKoszty(@PathVariable("id") Long id) {
//        Optional<Koszty> koszty = null;
//        try {
//            koszty = kosztyService.findSamochod(id);
//            log.info("Samochód,koszty with id '{}' found", id);
//        } catch (EntityNotFoundException e) {
//            log.error(e.getMessage());
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(koszty);
//    }

//    @GetMapping(value = "/firma/id={id}")
//    public ResponseEntity findFrimaKoszty(@PathVariable("id") Long id) {
//        Optional<Koszty> koszty = null;
//        try {
//            koszty = kosztyService.findFirma(id);
//            log.info("Firma, koszty with id '{}' found", id);
//        } catch (EntityNotFoundException e) {
//            log.error(e.getMessage());
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(koszty);
//    }
//
//    @GetMapping(value = "/kierowca/id={id}")
//    public ResponseEntity findKierowcaKoszty(@PathVariable("id") Long id) {
//        Optional<Koszty> koszty = null;
//        try {
//            koszty = kosztyService.findKierowca(id);
//            log.info("Kierowca, koszty with id '{}' found", id);
//        } catch (EntityNotFoundException e) {
//            log.error(e.getMessage());
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(koszty);
//    }

    @PostMapping(value = "/kierowca/id={id}")
    public ResponseEntity<?> addKierowcaKoszty(@PathVariable(value = "id") Long id, @RequestBody Koszty koszty) {
        Koszty koszty1;
        log.info("id " + id);
        log.info("koszty " + koszty);

        Kierowca kierowca = null;
        kierowca = kierowcyService.findId(id);
        log.info("koszty " + kierowca);
        if (kierowca == null) {
            System.out.println("kierowca");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("kierowca is null");
        } else {
            koszty.setKosztyKierowca(kierowca);
            System.out.println("kierowca: " + kierowca);
        }
        koszty1 = kosztyService.save(koszty);

        log.info("Koszty {} dodane", koszty1.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(koszty1);
    }

    @PostMapping(value = "/firmy/id={id}")
    public ResponseEntity<?> addFirmyKoszty(@PathVariable(value = "id") Long id, @RequestBody Koszty koszty) {
        Koszty koszty1;
        log.info("id " + id);
        log.info("koszty " + koszty);

        Firma firmy = null;
        firmy = firmyService.findId(id);
        log.info("koszty " + firmy);
        if (firmy == null) {
            System.out.println("kierowca");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("kierowca is null");
        } else {
            koszty.setKosztyFirmy(firmy);
            System.out.println("kierowca: " + firmy);
        }
        koszty1 = kosztyService.save(koszty);

        log.info("Koszty {} dodane", koszty1.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(koszty1);
    }

    @PostMapping
    public ResponseEntity<Koszty> addKoszty(@RequestBody Koszty koszty) {
        kosztyService.save(koszty);
        log.info("Koszty {} dodane", koszty.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(koszty);
    }

    @PutMapping(value = "/{id}")
    public Koszty updateKoszty(@PathVariable(value = "id") Long id, @RequestBody Koszty koszty) {

        Koszty kosztyToUptade = null;
        try {
            kosztyToUptade = kosztyService.findOne(id);
            kosztyToUptade.setRadzajekosztow(koszty.getRadzajekosztow());
            kosztyToUptade.setKwota(koszty.getKwota());
            kosztyToUptade.setData(koszty.getData());
            kosztyToUptade.setNotka(koszty.getNotka());
            kosztyToUptade.setKosztyFirmy(koszty.getKosztyFirmy());
            kosztyToUptade.setKosztyKierowca(koszty.getKosztyKierowca());

        } catch (EntityNotFoundException e) {
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
