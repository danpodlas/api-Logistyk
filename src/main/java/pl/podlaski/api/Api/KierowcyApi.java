package pl.podlaski.api.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.KierowcaEntity;
import pl.podlaski.api.Service.KierowcyManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/kierowca")
public class KierowcyApi {

    private KierowcyManager kierowcyManager;

    @Autowired
    public KierowcyApi(KierowcyManager kierowcyManager) {
        this.kierowcyManager = kierowcyManager;
    }

    @GetMapping("/all")
    public Iterable<KierowcaEntity> getAll(){
        return  kierowcyManager.findAll();
    }

    @GetMapping
    public Optional<KierowcaEntity> getById(@RequestParam Long index){
        return kierowcyManager.findById(index);
    }

    @PostMapping
    public KierowcaEntity addVideo(@RequestBody KierowcaEntity kierowcaEntity){
        return  kierowcyManager.save(kierowcaEntity);
    }

    @PutMapping
    public KierowcaEntity updateVideo(@RequestBody KierowcaEntity kierowcaEntity){
        return  kierowcyManager.save(kierowcaEntity);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        kierowcyManager.delete(index);
    }
}
