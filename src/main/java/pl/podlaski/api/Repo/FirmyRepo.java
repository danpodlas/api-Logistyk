package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.podlaski.api.DAO.Entity.FirmyEntity;

public interface FirmyRepo extends CrudRepository<FirmyEntity,Long> {
}
