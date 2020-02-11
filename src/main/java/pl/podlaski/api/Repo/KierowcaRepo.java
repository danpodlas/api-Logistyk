package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Kierowca;
import pl.podlaski.api.DAO.Entity.Klient;

@Repository
public interface KierowcaRepo extends JpaRepository<Kierowca,Long> {
    Kierowca findByEmailAndHaslo(String email, String haslo);
}
