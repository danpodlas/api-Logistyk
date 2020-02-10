package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.Repo.KierowcaRepo;

import java.util.List;
import java.util.Optional;

@Service
public class KierowcyService {

    private KierowcaRepo kierowcaRepo;

    @Autowired
    public KierowcyService(KierowcaRepo kierowcaRepo) {
        this.kierowcaRepo = kierowcaRepo;
    }

    public Kierowca findOne(long id) {
        return kierowcaRepo.getOne(id);
    }

    public List<Kierowca> findAll(){
        return kierowcaRepo.findAll();
    }

    public Kierowca save(Kierowca kierowca){
        return kierowcaRepo.save(kierowca);
    }

    public Kierowca update(Kierowca kierowca){
        return kierowcaRepo.saveAndFlush(kierowca);
    }

    public void delete(long id){
        kierowcaRepo.deleteById(id);
    }

}
