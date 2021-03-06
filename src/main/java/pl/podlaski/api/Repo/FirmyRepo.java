package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Firma;

@CrossOrigin("http://localhost:4200")
@Repository
public interface FirmyRepo extends JpaRepository<Firma,Long> {

    Firma findByEmailAndHaslo(String email, String haslo);

    Firma findById(long id);
}
