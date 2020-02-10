package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Koszty;
@Repository
public interface KosztyRepo extends CrudRepository<Koszty,Long> {
}
