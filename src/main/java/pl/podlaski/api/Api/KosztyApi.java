package pl.podlaski.api.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.KosztyEntity;
import pl.podlaski.api.Service.KosztyManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/koszty")
public class KosztyApi {

    private KosztyManager kosztyManager;

    @Autowired
    public KosztyApi(KosztyManager kosztyManager) {
        this.kosztyManager = kosztyManager;
    }

    @GetMapping("/all")
    public Iterable<KosztyEntity> getAll(){
        return  kosztyManager.findAll();
    }

    @GetMapping
    public Optional<KosztyEntity> getById(@RequestParam Long index){
        return kosztyManager.findById(index);
    }

    @PostMapping
    public KosztyEntity addVideo(@RequestBody KosztyEntity kosztyEntity){
        return  kosztyManager.save(kosztyEntity);
    }

    @PutMapping
    public KosztyEntity updateVideo(@RequestBody KosztyEntity kosztyEntity){
        return  kosztyManager.save(kosztyEntity);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        kosztyManager.delete(index);
    }
}
