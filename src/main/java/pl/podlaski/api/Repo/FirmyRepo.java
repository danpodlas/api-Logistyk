package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Firma;

@Repository
public interface FirmyRepo extends CrudRepository<Firma,Long> {
}
