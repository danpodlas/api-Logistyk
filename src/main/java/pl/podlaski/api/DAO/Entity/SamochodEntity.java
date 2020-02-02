package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.Przyczepy;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SamochodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marka;
    private String model;
    private Date rokprodukcji;
    private int przebieg;
    private String numerrejestracyjny;
    private String typpojazdu;
    private Przyczepy przyczepy;

    public SamochodEntity() {
    }
//    @OneToOne
//    @JoinColumn(name = "kierowcaEntity_id", referencedColumnName = "id")
//    private KierowcaEntity kierowcaEntity;
//
//    @OneToOne
//    @JoinColumn(name = "firmyEntity_id", referencedColumnName = "id")
//    private FirmyEntity firmyEntity;


    public SamochodEntity(Long id, String marka, String model, Date rokprodukcji, int przebieg, String numerrejestracyjny, String typpojazdu, Przyczepy przyczepy) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.rokprodukcji = rokprodukcji;
        this.przebieg = przebieg;
        this.numerrejestracyjny = numerrejestracyjny;
        this.typpojazdu = typpojazdu;
        this.przyczepy = przyczepy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getRokprodukcji() {
        return rokprodukcji;
    }

    public void setRokprodukcji(Date rokprodukcji) {
        this.rokprodukcji = rokprodukcji;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public String getNumerrejestracyjny() {
        return numerrejestracyjny;
    }

    public void setNumerrejestracyjny(String numerrejestracyjny) {
        this.numerrejestracyjny = numerrejestracyjny;
    }

    public String getTyppojazdu() {
        return typpojazdu;
    }

    public void setTyppojazdu(String typpojazdu) {
        this.typpojazdu = typpojazdu;
    }

    public Przyczepy getPrzyczepy() {
        return przyczepy;
    }

    public void setPrzyczepy(Przyczepy przyczepy) {
        this.przyczepy = przyczepy;
    }

//    public KierowcaEntity getKierowcaEntity() {
//        return kierowcaEntity;
//    }
//
//    public void setKierowcaEntity(KierowcaEntity kierowcaEntity) {
//        this.kierowcaEntity = kierowcaEntity;
//    }
}
