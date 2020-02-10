package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Zlecenie;
import pl.podlaski.api.Service.ZlecenieService;

import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/zlecenie")
public class ZlecenieController {

    private ZlecenieService zlecenieService;

    @Autowired
    public ZlecenieController(ZlecenieService zlecenieService) {
        this.zlecenieService = zlecenieService;
    }

    @GetMapping("/all")
    public Iterable<Zlecenie> getAll(){
        return  zlecenieService.findAll();
    }

    @GetMapping
    public Optional<Zlecenie> getById(@RequestParam Long index){
        return zlecenieService.findById(index);
    }

    @PostMapping
    public Zlecenie addVideo(@RequestBody Zlecenie zlecenie){
        return  zlecenieService.save(zlecenie);
    }

    @PutMapping
    public Zlecenie updateVideo(@RequestBody Zlecenie zlecenie){
        return  zlecenieService.save(zlecenie);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        zlecenieService.delete(index);
    }
}
