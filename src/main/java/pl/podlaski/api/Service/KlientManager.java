package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.KlientEntity;
import pl.podlaski.api.Repo.KlientRepo;
import java.util.Optional;

@Service
public class KlientManager {
    private KlientRepo klientRepo;

    @Autowired
    public KlientManager(KlientRepo klientRepo) {
        this.klientRepo = klientRepo;
    }

    public Optional<KlientEntity> findById(Long id){
        return klientRepo.findById(id);
    }

    public Iterable<KlientEntity> findAll(){
        return klientRepo.findAll();
    }

    public KlientEntity save(KlientEntity klientEntity){
        return klientRepo.save(klientEntity);
    }

    public void delete(long id){
        klientRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }
}
