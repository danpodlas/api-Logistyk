package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Koszty;

import java.util.List;
import java.util.Optional;


@CrossOrigin("http://localhost:4200")
@Repository
public interface KosztyRepo extends JpaRepository<Koszty,Long> {

    Optional<Koszty> findSamochodById(Long id);

    Optional<Koszty> findFirmyById(Long id);
    Optional<Koszty> findKierowcaById(Long id);

}
