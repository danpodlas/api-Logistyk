package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.Repo.FirmyRepo;
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

    public List<Klient> findAll() {
        return klientRepo.findAll();
    }

    public Klient findOne(long id) {
        return klientRepo.getOne(id);
    }

    public Klient save(Klient klient) {
        return klientRepo.save(klient);
    }

    public Klient update(Klient klient) {
        return klientRepo.saveAndFlush(klient);
    }

    public void delete(long id) {
        klientRepo.deleteById(id);
    }

}
