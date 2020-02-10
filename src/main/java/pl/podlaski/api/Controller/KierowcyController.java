package pl.podlaski.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.Service.KierowcyService;
import java.util.Optional;

@RestController
@RequestMapping("/api/kierowca")
public class KierowcyController {

    private KierowcyService kierowcyService;

    @Autowired
    public KierowcyController(KierowcyService kierowcyService) {
        this.kierowcyService = kierowcyService;
    }

    @GetMapping("/all")
    public Iterable<Kierowca> getAll(){
        return  kierowcyService.findAll();
    }

    @GetMapping
    public Optional<Kierowca> getById(@RequestParam Long index){
        return kierowcyService.findById(index);
    }

    @PostMapping
    public Kierowca addVideo(@RequestBody Kierowca kierowca){
        return  kierowcyService.save(kierowca);
    }

    @PutMapping
    public Kierowca updateVideo(@RequestBody Kierowca kierowca){
        return  kierowcyService.save(kierowca);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        kierowcyService.delete(index);
    }
}
