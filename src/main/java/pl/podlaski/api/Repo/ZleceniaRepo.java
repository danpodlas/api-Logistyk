package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import pl.podlaski.api.DAO.Entity.ZlecenieEntity;

public interface ZleceniaRepo extends CrudRepository<ZlecenieEntity,Long> {
}
