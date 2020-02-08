package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.SamochodEntity;
import pl.podlaski.api.Repo.SamochodyRepo;
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
//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB(){
//        save(new SamochodEntity( "Daf","XF", "1995-01-01",165999, "WCI 121", "TIR", Przyczepy.CHŁODNIA));
//        save(new SamochodEntity( "Scania","340","1995-02-02",115999, "WCI 122", "TIR", Przyczepy.CYSTERNA));
//        save(new SamochodEntity( "Daf","115", "1999-01-03",235999, "WCI 123", "TIR", Przyczepy.FIRANKA));
//        save(new SamochodEntity( "Volvo","X", "2001-05-06",155000, "WCI 124", "TIR", Przyczepy.WYWROTKA));
//    }
}

