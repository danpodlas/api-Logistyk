package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.podlaski.api.DAO.Entity.KierowcaEntity;

public interface KierowcaRepo extends CrudRepository<KierowcaEntity,Long> {
}
