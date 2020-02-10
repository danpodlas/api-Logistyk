package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Zlecenie;
import pl.podlaski.api.Repo.ZleceniaRepo;

import java.util.Optional;

@Service
public class ZlecenieService {
    private ZleceniaRepo zleceniaRepo;

    @Autowired
    public ZlecenieService(ZleceniaRepo zleceniaRepo) {
        this.zleceniaRepo = zleceniaRepo;
    }

    public Optional<Zlecenie> findById(Long id){
        return zleceniaRepo.findById(id);
    }

    public Iterable<Zlecenie> findAll(){
        return zleceniaRepo.findAll();
    }

    public Zlecenie save(Zlecenie zlecenie){
        return zleceniaRepo.save(zlecenie);
    }

    public void delete(long id){
        zleceniaRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }
}
