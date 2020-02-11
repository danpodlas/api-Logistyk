package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Firma;
import pl.podlaski.api.DAO.Entity.Klient;

@Repository
public interface FirmyRepo extends JpaRepository<Firma,Long> {
    Firma findByEmailAndHaslo(String email, String haslo);
}
