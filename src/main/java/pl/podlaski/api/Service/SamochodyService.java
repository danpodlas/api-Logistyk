package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.Repo.SamochodyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SamochodyService {
    private SamochodyRepo samochodyRepo;

    @Autowired
    public SamochodyService(SamochodyRepo samochodyRepo) {
        this.samochodyRepo = samochodyRepo;
    }

    public List<Samochod> findAll(){
        return samochodyRepo.findAll();
    }

    public Samochod findOne(long id) {
        return samochodyRepo.getOne(id);
    }

    public Samochod save(Samochod samochod){
        return samochodyRepo.save(samochod);
    }

    public Samochod update(Samochod samochod){
        return samochodyRepo.saveAndFlush(samochod);
    }

    public void delete(long id){
        samochodyRepo.deleteById(id);
    }

}

