package pl.podlaski.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.Service.FirmyService;
import java.util.Optional;

@RestController
@RequestMapping("/api/firmy")
public class FirmyController {

    private FirmyService firmyService;

    @Autowired
    public FirmyController(FirmyService firmyService) {
        this.firmyService = firmyService;
    }

    @GetMapping("/all")
    public Iterable<Firma> getAll(){
        return  firmyService.findAll();
    }

    @GetMapping
    public Optional<Firma> getById(@RequestParam Long index){
        return firmyService.findById(index);
    }

    @PostMapping
    public Firma addVideo(@RequestBody Firma firma){
        return  firmyService.save(firma);
    }

    @PutMapping
    public Firma updateVideo(@RequestBody Firma firma){
        return  firmyService.save(firma);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        firmyService.delete(index);
    }

}
