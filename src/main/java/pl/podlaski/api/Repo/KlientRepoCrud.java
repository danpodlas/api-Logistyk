package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Klient;

@CrossOrigin("http://localhost:4200")
@Repository
public interface KlientRepoCrud extends CrudRepository<Klient, Long> {
    Klient findByEmailAndHaslo(String email, String haslo);
}
