package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Klient;
@Repository
public interface KlientRepo extends CrudRepository<Klient, Long> {
}
