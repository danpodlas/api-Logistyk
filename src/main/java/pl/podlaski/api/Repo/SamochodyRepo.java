package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Samochod;

import java.util.Optional;


@CrossOrigin("http://localhost:4200")
@Repository
public interface SamochodyRepo extends JpaRepository<Samochod,Long> {

    Optional<Samochod> findById(Long id);
}
