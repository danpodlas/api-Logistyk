package pl.podlaski.api.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.FirmyEntity;
import pl.podlaski.api.Service.FirmyManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/firmy")
public class FirmyApi {

    private FirmyManager firmyManager;

    @Autowired
    public FirmyApi(FirmyManager firmyManager) {
        this.firmyManager = firmyManager;
    }

    @GetMapping("/all")
    public Iterable<FirmyEntity> getAll(){
        return  firmyManager.findAll();
    }

    @GetMapping
    public Optional<FirmyEntity> getById(@RequestParam Long index){
        return firmyManager.findById(index);
    }

    @PostMapping
    public FirmyEntity addVideo(@RequestBody FirmyEntity firmyEntity){
        return  firmyManager.save(firmyEntity);
    }

    @PutMapping
    public FirmyEntity updateVideo(@RequestBody FirmyEntity firmyEntity){
        return  firmyManager.save(firmyEntity);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        firmyManager.delete(index);
    }

}
