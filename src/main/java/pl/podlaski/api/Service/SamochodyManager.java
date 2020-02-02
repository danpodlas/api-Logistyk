package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Constans.Przyczepy;
import pl.podlaski.api.DAO.Entity.SamochodEntity;
import pl.podlaski.api.Repo.SamochodyRepo;

import java.util.Date;
import java.util.Optional;

@Service
public class SamochodyManager {
    private SamochodyRepo samochodyRepo;

    @Autowired
    public SamochodyManager(SamochodyRepo samochodyRepo) {
        this.samochodyRepo = samochodyRepo;
    }

    public Optional<SamochodEntity> findById(Long id){
        return samochodyRepo.findById(id);
    }

    public Iterable<SamochodEntity> findAll(){
        return samochodyRepo.findAll();
    }

    public SamochodEntity save(SamochodEntity samochodEntity){
        return samochodyRepo.save(samochodEntity);
    }

    public void delete(long id){
        samochodyRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new SamochodEntity((long) 1, "Daf","XF", new Date(1995,1,1),165999, "WCI 121", "TIR", Przyczepy.CHŁODNIA));
        save(new SamochodEntity((long)2, "Scania","340", new Date(1995,2,1),115999, "WCI 122", "TIR", Przyczepy.CYSTERNA));
        save(new SamochodEntity((long)3, "Daf","115", new Date(1995,3,1),235999, "WCI 123", "TIR", Przyczepy.FIRANKA));
        save(new SamochodEntity((long)4, "Volvo","X", new Date(1999,3,1),155000, "WCI 124", "TIR", Przyczepy.WYWROTKA));
    }
}

