package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.podlaski.api.DAO.Entity.KlientEntity;

public interface KlientRepo extends CrudRepository<KlientEntity,Long> {
}
