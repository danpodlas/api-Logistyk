package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Constans.Role;
import pl.podlaski.api.DAO.Entity.KierowcaEntity;
import pl.podlaski.api.DAO.Entity.SamochodEntity;
import pl.podlaski.api.Repo.KierowcaRepo;
import java.util.Optional;

@Service
public class KierowcyManager {

    private KierowcaRepo kierowcaRepo;

    @Autowired
    public KierowcyManager(KierowcaRepo kierowcaRepo) {
        this.kierowcaRepo = kierowcaRepo;
    }

    public Optional<KierowcaEntity> findById(Long id){
        return kierowcaRepo.findById(id);
    }

    public Iterable<KierowcaEntity> findAll(){
        return kierowcaRepo.findAll();
    }

    public KierowcaEntity save(KierowcaEntity kierowcaEntity){
        return kierowcaRepo.save(kierowcaEntity);
    }

    public void delete(long id){
        kierowcaRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
//        save(new KierowcaEntity((long) 1, "Stefan", "Pierwszy", "88121467678","500600100","Warszawa","Kiermaszowa", "89/2","2011-01-02","spierwszy@praca.pl","kierowca","94922700046623930487800469", Role.KIEROWCA, )));
    }
}
