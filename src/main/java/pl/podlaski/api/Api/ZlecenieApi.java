package pl.podlaski.api.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.ZlecenieEntity;
import pl.podlaski.api.Service.ZlecenieManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/zlecenie")
public class ZlecenieApi {

    private ZlecenieManager zlecenieManager;

    @Autowired
    public ZlecenieApi(ZlecenieManager zlecenieManager) {
        this.zlecenieManager = zlecenieManager;
    }

    @GetMapping("/all")
    public Iterable<ZlecenieEntity> getAll(){
        return  zlecenieManager.findAll();
    }

    @GetMapping
    public Optional<ZlecenieEntity> getById(@RequestParam Long index){
        return zlecenieManager.findById(index);
    }

    @PostMapping
    public ZlecenieEntity addVideo(@RequestBody ZlecenieEntity zlecenieEntity){
        return  zlecenieManager.save(zlecenieEntity);
    }

    @PutMapping
    public ZlecenieEntity updateVideo(@RequestBody ZlecenieEntity zlecenieEntity){
        return  zlecenieManager.save(zlecenieEntity);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        zlecenieManager.delete(index);
    }
}
