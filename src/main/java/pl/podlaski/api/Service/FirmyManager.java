package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.FirmyEntity;
import pl.podlaski.api.Repo.FirmyRepo;
import java.util.Optional;

@Service
public class FirmyManager {

    private FirmyRepo firmyRepo;
    @Autowired
    public FirmyManager(FirmyRepo firmyRepo) {
        this.firmyRepo = firmyRepo;
    }

    public Optional<FirmyEntity> findById(Long id){
        return firmyRepo.findById(id);
    }

    public Iterable<FirmyEntity> findAll(){
        return firmyRepo.findAll();
    }

    public FirmyEntity save(FirmyEntity firmyEntity){
        return firmyRepo.save(firmyEntity);
    }

    public void delete(long id){
        firmyRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }
}
