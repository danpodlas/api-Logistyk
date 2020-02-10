package pl.podlaski.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Zlecenie;
import pl.podlaski.api.Service.ZlecenieService;

@Slf4j
@RestController
@RequestMapping("/api/zlecenie")
public class ZlecenieController {
    //TODO update
    private ZlecenieService zlecenieService;

    @Autowired
    public ZlecenieController(ZlecenieService zlecenieService) {
        this.zlecenieService = zlecenieService;
    }

    @GetMapping("/")
    public Iterable<Zlecenie> getAll(){
        return  zlecenieService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Zlecenie> get(@PathVariable Long id) {
        return new ResponseEntity(this.zlecenieService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public Zlecenie addZlecenie (@RequestBody Zlecenie zlecenie){
        return  zlecenieService.save(zlecenie);
    }

    @PutMapping
    public Zlecenie updateZlecenie(@RequestBody Zlecenie zlecenie){
        return  zlecenieService.save(zlecenie);
    }

    @DeleteMapping
    public void deleteZlecenie(@RequestParam Long index){
        zlecenieService.delete(index);
    }
}
