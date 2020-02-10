package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.Repo.KlientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class KlientService {

    private KlientRepo klientRepo;

    @Autowired
    public KlientService(KlientRepo klientRepo) {
        this.klientRepo = klientRepo;
    }

    public Optional<Klient> findById(Long id){
        return klientRepo.findById(id);
    }

    public Iterable<Klient> findAll(){
        return klientRepo.findAll();
    }

    public Klient save(Klient klient){
        return klientRepo.save(klient);
    }

    public void delete(Long id){
        klientRepo.deleteById(id);
    }

}
