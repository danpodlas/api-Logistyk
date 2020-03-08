package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Koszty;
import pl.podlaski.api.DAO.Entity.Zlecenie;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@CrossOrigin("http://localhost:4200")
@Repository
public interface KosztyRepo extends JpaRepository<Koszty,Long> {

    Optional<Koszty> findSamochodById(Long id);

    Optional<Koszty> findFirmyById(Long id);
    Optional<Koszty> findKierowcaById(Long id);

    @Query(value = "from Koszty k where k.kosztyFirmy.id=:id AND k.data BETWEEN :startDate AND :endDate ORDER BY k.data")
    List<Koszty> getAllBetweenDates(@Param("id")long id, @Param("startDate") Date startDate, @Param("endDate")Date endDate);

}
