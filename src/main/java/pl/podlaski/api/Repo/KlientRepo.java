package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.KlientEntity;
@Repository
public interface KlientRepo extends CrudRepository<KlientEntity,Long> {
}
