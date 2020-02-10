package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.DAO.Entity.Zlecenie;
import pl.podlaski.api.Repo.ZleceniaRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ZlecenieService {
    private ZleceniaRepo zleceniaRepo;

    @Autowired
    public ZlecenieService(ZleceniaRepo zleceniaRepo) {
        this.zleceniaRepo = zleceniaRepo;
    }

    public List<Zlecenie> findAll(){
        return zleceniaRepo.findAll();
    }

    public Zlecenie findOne(long id) {
        return zleceniaRepo.getOne(id);
    }

    public Zlecenie save(Zlecenie zlecenie){
        return zleceniaRepo.save(zlecenie);
    }

    public Zlecenie update(Zlecenie zlecenie){
        return zleceniaRepo.saveAndFlush(zlecenie);
    }

    public void delete(long id){
        zleceniaRepo.deleteById(id);
    }

}
