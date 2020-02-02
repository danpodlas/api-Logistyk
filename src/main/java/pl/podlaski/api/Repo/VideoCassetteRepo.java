package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.VideoCassette;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette,Long> {
}