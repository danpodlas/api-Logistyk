package pl.podlaski.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.Service.KlientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/klient")
public class KlientController {

    private KlientService klientService;

    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping("/all")
    public Iterable<Klient> getAll(){
        return  klientService.findAll();
    }

    @GetMapping
    public Optional<Klient> getById(@RequestParam Long index){
        return klientService.findById(index);
    }

    @PostMapping
    public Klient addVideo(@RequestBody Klient klient){
        return  klientService.save(klient);
    }

    @PutMapping
    public Klient updateVideo(@RequestBody Klient klient){
        return  klientService.save(klient);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        klientService.delete(index);
    }
}
