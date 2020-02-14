package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Koszty;


@CrossOrigin("http://localhost:4200")
@Repository
public interface KosztyRepo extends JpaRepository<Koszty,Long> {
}
