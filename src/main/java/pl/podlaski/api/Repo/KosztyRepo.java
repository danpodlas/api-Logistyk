package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.podlaski.api.DAO.Entity.KosztyEntity;

public interface KosztyRepo extends CrudRepository<KosztyEntity,Long> {
}
