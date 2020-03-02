package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Klient;
import pl.podlaski.api.DAO.Entity.Samochod;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface KierowcaRepo extends JpaRepository<Kierowca,Long> {
    Kierowca findByEmailAndHaslo(String email, String haslo);
    Optional<Kierowca> findById(Long id);

    Optional<Kierowca> findSamochodById(Long id);

    Kierowca findById(long id);

    List<Kierowca> findKierowcaBySamochodId(long id);
}
