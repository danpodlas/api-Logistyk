package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.Repo.FirmyRepo;
import java.util.Optional;

@Service
public class FirmyService {

    private FirmyRepo firmyRepo;
    @Autowired
    public FirmyService(FirmyRepo firmyRepo) {
        this.firmyRepo = firmyRepo;
    }

    public Optional<Firma> findById(Long id){
        return firmyRepo.findById(id);
    }

    public Iterable<Firma> findAll(){
        return firmyRepo.findAll();
    }

    public Firma save(Firma firma){
        return firmyRepo.save(firma);
    }

    public void delete(long id){
        firmyRepo.deleteById(id);
    }

    //Ta metoda jest wywoływana w momencie startu aplikacji i wrzuca elementy do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    }
}
