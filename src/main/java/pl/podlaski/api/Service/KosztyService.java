package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Koszty;
import pl.podlaski.api.Repo.KosztyRepo;
import java.util.Optional;

@Service
public class KosztyService {
    private KosztyRepo kosztyRepo;

    @Autowired
    public KosztyService(KosztyRepo kosztyRepo) {
        this.kosztyRepo = kosztyRepo;
    }

    public Optional<Koszty> findById(Long id){
        return kosztyRepo.findById(id);
    }

    public Iterable<Koszty> findAll(){
        return kosztyRepo.findAll();
    }

    public Koszty save(Koszty koszty){
        return kosztyRepo.save(koszty);
    }

    public void delete(long id){
        kosztyRepo.deleteById(id);
    }

}
