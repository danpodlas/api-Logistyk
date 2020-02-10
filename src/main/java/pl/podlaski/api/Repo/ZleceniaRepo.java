package pl.podlaski.api.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.podlaski.api.DAO.Entity.Zlecenie;

@Repository
public interface ZleceniaRepo extends CrudRepository<Zlecenie,Long> {
}
