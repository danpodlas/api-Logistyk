package pl.podlaski.api.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.podlaski.api.DAO.Entity.Zlecenie;

import java.util.Date;
import java.util.List;;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ZleceniaRepo extends JpaRepository<Zlecenie, Long> {

    Zlecenie findById(long id);

    List<Zlecenie> findZlecenieByStatus(String status);

    List<Zlecenie> findZlecenieByKlient_Id(long id);

    List<Zlecenie> findZlecenieByKierowca_id(long id);

    List<Zlecenie> findZlecenieByPrzyjmFirmaId(long id);

    List<Zlecenie> findZlecenieByZlecFirmaId(long id);

    List<Zlecenie> findAllByPrzyjmFirmaIdOrZlecFirmaId(long id, long a);

//    List<Zlecenie> findKosztyFirmy(long a, String dateOne, String dateTwo);

    @Query(value = "from Zlecenie z where z.przyjmFirma.id=:id AND z.datazakonczenia BETWEEN :startDate AND :endDate ORDER BY z.datazakonczenia")
    List<Zlecenie> getAllBetweenDates(@Param("id")long id, @Param("startDate")Date startDate,@Param("endDate")Date endDate);

}
