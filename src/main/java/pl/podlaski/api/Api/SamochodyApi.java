package pl.podlaski.api.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podlaski.api.DAO.Entity.SamochodEntity;
import pl.podlaski.api.Service.SamochodyManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/samochody")
public class SamochodyApi {
    private SamochodyManager samochodyManager;

    @Autowired
    public SamochodyApi(SamochodyManager samochodyManager) {
        this.samochodyManager = samochodyManager;
    }

    @GetMapping("/all")
    public Iterable<SamochodEntity> getAll(){
        return  samochodyManager.findAll();
    }

    @GetMapping
    public Optional<SamochodEntity> getById(@RequestParam Long index){
        return samochodyManager.findById(index);
    }

    @PostMapping
    public SamochodEntity addVideo(@RequestBody SamochodEntity samochodEntity){
        return  samochodyManager.save(samochodEntity);
    }

    @PutMapping
    public SamochodEntity updateVideo(@RequestBody SamochodEntity samochodEntity){
        return  samochodyManager.save(samochodEntity);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        samochodyManager.delete(index);
    }
}
