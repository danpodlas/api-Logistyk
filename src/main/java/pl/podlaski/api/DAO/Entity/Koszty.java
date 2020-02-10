package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.RodzajeKosztow;

import javax.persistence.*;

@Entity
@Table(name = "Koszty")
public class Koszty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
    private Samochod samochodKoszty;

    private RodzajeKosztow radzajekosztow;
    private Double kwota;
    private String data;
    private String notka;

    @OneToOne
    @JoinColumn(name = "firma_id", referencedColumnName = "id")
    private Firma kosztyFirmy;

    @OneToOne
    @JoinColumn(name = "kierowca_id", referencedColumnName = "id")
    private Kierowca kosztyKierowca;

    public Koszty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Samochod getSamochodKoszty() {
        return samochodKoszty;
    }

    public void setSamochodKoszty(Samochod samochodKoszty) {
        this.samochodKoszty = samochodKoszty;
    }

    public RodzajeKosztow getRadzajekosztow() {
        return radzajekosztow;
    }

    public void setRadzajekosztow(RodzajeKosztow radzajekosztow) {
        this.radzajekosztow = radzajekosztow;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}
