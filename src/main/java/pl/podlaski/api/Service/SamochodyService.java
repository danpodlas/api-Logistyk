package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Samochod;
import pl.podlaski.api.Repo.SamochodyRepo;
import java.util.Optional;

@Service
public class SamochodyService {
    private SamochodyRepo samochodyRepo;

    @Autowired
    public SamochodyService(SamochodyRepo samochodyRepo) {
        this.samochodyRepo = samochodyRepo;
    }

    public Optional<Samochod> findById(Long id){
        return samochodyRepo.findById(id);
    }

    public Iterable<Samochod> findAll(){
        return samochodyRepo.findAll();
    }

    public Samochod save(Samochod samochod){
        return samochodyRepo.save(samochod);
    }

    public void delete(long id){
        samochodyRepo.deleteById(id);
    }

}

