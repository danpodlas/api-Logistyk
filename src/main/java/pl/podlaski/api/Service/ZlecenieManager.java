package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.KosztyEntity;
import pl.podlaski.api.DAO.Entity.ZlecenieEntity;
import pl.podlaski.api.Repo.KosztyRepo;
import pl.podlaski.api.Repo.ZleceniaRepo;

import java.util.Optional;

@Service
public class ZlecenieManager {
    private ZleceniaRepo zleceniaRepo;

    @Autowired
    public ZlecenieManager(ZleceniaRepo zleceniaRepo) {
        this.zleceniaRepo = zleceniaRepo;
    }

    public Optional<ZlecenieEntity> findById(Long id){
        return zleceniaRepo.findById(id);
    }

    public Iterable<ZlecenieEntity> findAll(){
        return zleceniaRepo.findAll();
    }

    public ZlecenieEntity save(ZlecenieEntity zlecenieEntity){
        return zleceniaRepo.save(zlecenieEntity);
    }

    public void delete(long id){
        zleceniaRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }
}
