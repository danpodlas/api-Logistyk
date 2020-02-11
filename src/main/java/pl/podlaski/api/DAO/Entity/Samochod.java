package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Samochod")
public class Samochod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marka;
    private String model;
    private String rokprodukcji;
    private int przebieg;
    private String numerrejestracyjny;
    private String typpojazdu;
    private String przyczepy;

    public Samochod() {
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

    public String getPrzyczepy() {
        return przyczepy;
    }

    public void setPrzyczepy(String przyczepy) {
        this.przyczepy = przyczepy;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rokprodukcji='" + rokprodukcji + '\'' +
                ", przebieg=" + przebieg +
                ", numerrejestracyjny='" + numerrejestracyjny + '\'' +
                ", typpojazdu='" + typpojazdu + '\'' +
                ", przyczepy='" + przyczepy + '\'' +
                '}';
    }
}
