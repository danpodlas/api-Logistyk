package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Samochod;
@Repository
public interface SamochodyRepo extends CrudRepository<Samochod,Long> {
}
