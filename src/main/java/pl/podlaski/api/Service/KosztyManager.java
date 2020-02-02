package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.KosztyEntity;
import pl.podlaski.api.Repo.KosztyRepo;
import java.util.Optional;

@Service
public class KosztyManager {
    private KosztyRepo kosztyRepo;

    @Autowired
    public KosztyManager(KosztyRepo kosztyRepo) {
        this.kosztyRepo = kosztyRepo;
    }

    public Optional<KosztyEntity> findById(Long id){
        return kosztyRepo.findById(id);
    }

    public Iterable<KosztyEntity> findAll(){
        return kosztyRepo.findAll();
    }

    public KosztyEntity save(KosztyEntity kosztyEntity){
        return kosztyRepo.save(kosztyEntity);
    }

    public void delete(long id){
        kosztyRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }
}
