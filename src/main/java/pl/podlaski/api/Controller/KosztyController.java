package pl.podlaski.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Koszty;
import pl.podlaski.api.Service.KosztyService;
import java.util.Optional;

@RestController
@RequestMapping("/api/koszty")
public class KosztyController {

    private KosztyService kosztyService;

    @Autowired
    public KosztyController(KosztyService kosztyService) {
        this.kosztyService = kosztyService;
    }

    @GetMapping("/all")
    public Iterable<Koszty> getAll(){
        return  kosztyService.findAll();
    }

    @GetMapping
    public Optional<Koszty> getById(@RequestParam Long index){
        return kosztyService.findById(index);
    }

    @PostMapping
    public Koszty addVideo(@RequestBody Koszty koszty){
        return  kosztyService.save(koszty);
    }

    @PutMapping
    public Koszty updateVideo(@RequestBody Koszty koszty){
        return  kosztyService.save(koszty);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        kosztyService.delete(index);
    }
}
