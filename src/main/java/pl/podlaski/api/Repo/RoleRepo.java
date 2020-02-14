package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Role;

@CrossOrigin("http://localhost:4200")
@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
