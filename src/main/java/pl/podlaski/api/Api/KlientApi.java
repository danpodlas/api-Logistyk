package pl.podlaski.api.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.KlientEntity;
import pl.podlaski.api.Service.KlientManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/klient")
public class KlientApi {

    private KlientManager klientManager;

    @Autowired
    public KlientApi(KlientManager klientManager) {
        this.klientManager = klientManager;
    }

    @GetMapping("/all")
    public Iterable<KlientEntity> getAll(){
        return  klientManager.findAll();
    }

    @GetMapping
    public Optional<KlientEntity> getById(@RequestParam Long index){
        return klientManager.findById(index);
    }

    @PostMapping
    public KlientEntity addVideo(@RequestBody KlientEntity klientEntity){
        return  klientManager.save(klientEntity);
    }

    @PutMapping
    public KlientEntity updateVideo(@RequestBody KlientEntity klientEntity){
        return  klientManager.save(klientEntity);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        klientManager.delete(index);
    }
}
