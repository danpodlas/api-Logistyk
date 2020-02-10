package pl.podlaski.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.Service.SamochodyService;

import java.util.Optional;

@RestController
@RequestMapping("/api/samochody")
public class SamochodyController {
    private SamochodyService samochodyService;

    @Autowired
    public SamochodyController(SamochodyService samochodyService) {
        this.samochodyService = samochodyService;
    }

    @GetMapping("/all")
    public Iterable<Samochod> getAll(){
        return  samochodyService.findAll();
    }

    @GetMapping
    public Optional<Samochod> getById(@RequestParam Long index){
        return samochodyService.findById(index);
    }

    @PostMapping
    public Samochod addVideo(@RequestBody Samochod samochod){
        return  samochodyService.save(samochod);
    }

    @PutMapping
    public Samochod updateVideo(@RequestBody Samochod samochod){
        return  samochodyService.save(samochod);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        samochodyService.delete(index);
    }
}
