package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.podlaski.api.DAO.Entity.SamochodEntity;

public interface SamochodyRepo extends CrudRepository<SamochodEntity,Long> {
}
