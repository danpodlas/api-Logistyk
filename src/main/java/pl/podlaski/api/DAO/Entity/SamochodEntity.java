package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.Przyczepy;
import javax.persistence.*;

@Entity
@Table(name = "Samochod")
public class SamochodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marka;
    private String model;
    private String rokprodukcji;
    private int przebieg;
    private String numerrejestracyjny;
    private String typpojazdu;
    private Przyczepy przyczepy;

    @OneToOne(mappedBy="samochodKoszty",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private KosztyEntity kosztyEntity;

    public SamochodEntity() {
    }

    public SamochodEntity(String marka, String model, String rokprodukcji, int przebieg, String numerrejestracyjny, String typpojazdu, Przyczepy przyczepy) {
        this.marka = marka;
        this.model = model;
        this.rokprodukcji = rokprodukcji;
        this.przebieg = przebieg;
        this.numerrejestracyjny = numerrejestracyjny;
        this.typpojazdu = typpojazdu;
        this.przyczepy = przyczepy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRokprodukcji() {
        return rokprodukcji;
    }

    public void setRokprodukcji(String rokprodukcji) {
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
}
