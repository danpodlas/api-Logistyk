package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.Repo.KlientRepo;

import java.util.List;

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

    public Klient logIn(String email, String haslo) {
        return klientRepo.findByEmailAndHaslo(email, haslo);
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
