package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.KosztyEntity;
@Repository
public interface KosztyRepo extends CrudRepository<KosztyEntity,Long> {
}
