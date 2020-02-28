package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Zlecenie;
import java.util.List;;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ZleceniaRepo extends JpaRepository<Zlecenie,Long> {

    Zlecenie findById(long id);

    List<Zlecenie> findZlecenieByStatus(String status);

    List<Zlecenie> findZlecenieByKlient_id(long id );

}
