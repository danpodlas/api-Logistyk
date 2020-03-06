package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.RodzajeKosztow;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Koszty")
public class Koszty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
//    private Samochod samochodKoszty;

    private String radzajekosztow;
    private Double kwota;

    @Temporal(TemporalType.DATE)
    private Date data;

    private String notka;

    @OneToOne
    @JoinColumn(name = "firmy_id", referencedColumnName = "id")
    private Firma kosztyFirmy;

    @OneToOne
    @JoinColumn(name = "kierowca_id", referencedColumnName = "id")
    private Kierowca kosztyKierowca;

    public Koszty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Samochod getSamochodKoszty() {
//        return samochodKoszty;
//    }
//
//    public void setSamochodKoszty(Samochod samochodKoszty) {
//        this.samochodKoszty = samochodKoszty;
//    }


    public String getRadzajekosztow() {
        return radzajekosztow;
    }

    public void setRadzajekosztow(String radzajekosztow) {
        this.radzajekosztow = radzajekosztow;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNotka() {
        return notka;
    }

    public void setNotka(String notka) {
        this.notka = notka;
    }

    public Firma getKosztyFirmy() {
        return kosztyFirmy;
    }

    public void setKosztyFirmy(Firma kosztyFirmy) {
        this.kosztyFirmy = kosztyFirmy;
    }

    public Kierowca getKosztyKierowca() {
        return kosztyKierowca;
    }

    public void setKosztyKierowca(Kierowca kosztyKierowca) {
        this.kosztyKierowca = kosztyKierowca;
    }

    @Override
    public String toString() {
        return "Koszty{" +
                "id=" + id +
                ", radzajekosztow=" + radzajekosztow +
                ", kwota=" + kwota +
                ", data='" + data + '\'' +
                ", notka='" + notka + '\'' +
                ", kosztyFirmy=" + kosztyFirmy +
                ", kosztyKierowca=" + kosztyKierowca +
                '}';
    }
}
