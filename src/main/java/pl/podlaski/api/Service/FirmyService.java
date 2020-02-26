package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.Repo.FirmyRepo;

import java.util.List;

@Service
public class FirmyService {

    private FirmyRepo firmyRepo;
    @Autowired
    public FirmyService(FirmyRepo firmyRepo) {
        this.firmyRepo = firmyRepo;
    }

    public List<Firma> findAll(){
        return firmyRepo.findAll();
    }

    public Firma logIn(String email, String haslo) {
        return firmyRepo.findByEmailAndHaslo(email, haslo);
    }

    public Firma findOne(long id) {
        return firmyRepo.getOne(id);
    }

    public Firma findId(long id) {
        return firmyRepo.findById(id);
    }

    public Firma save(Firma firma){
        return firmyRepo.save(firma);
    }

    public Firma update(Firma firma){
        return firmyRepo.saveAndFlush(firma);
    }

    public void delete(long id){
        firmyRepo.deleteById(id);
    }
}
