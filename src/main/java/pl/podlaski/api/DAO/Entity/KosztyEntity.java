package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.RodzajeKosztow;

import javax.persistence.*;

@Entity
@Table(name = "Koszty")
public class KosztyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
    private SamochodEntity samochodKoszty;

    private RodzajeKosztow radzajekosztow;
    private Double kwota;
    private String data;
    private String notka;

    @OneToOne
    @JoinColumn(name = "firmy_id", referencedColumnName = "id")
    private FirmyEntity kosztyFirmy;

    @OneToOne
    @JoinColumn(name = "kierowca_id", referencedColumnName = "id")
    private KierowcaEntity kosztyKierowca;

    public KosztyEntity() {
    }

//    public KosztyEntity(Long id, SamochodEntity samochodEntity, RodzajeKosztow rodzajeKosztow, Double kwota, String data, String notka, FirmyEntity przyjmfirmyEntity, KierowcaEntity kierowcaEntity) {
//        this.id = id;
//        this.samochodEntity = samochodEntity;
//        this.rodzajeKosztow = rodzajeKosztow;
//        this.kwota = kwota;
//        this.data = data;
//        this.notka = notka;
//        this.przyjmfirmyEntity = przyjmfirmyEntity;
//        this.kierowcaEntity = kierowcaEntity;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SamochodEntity getSamochodKoszty() {
        return samochodKoszty;
    }

    public void setSamochodKoszty(SamochodEntity samochodKoszty) {
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

    public FirmyEntity getKosztyFirmy() {
        return kosztyFirmy;
    }

    public void setKosztyFirmy(FirmyEntity kosztyFirmy) {
        this.kosztyFirmy = kosztyFirmy;
    }

    public KierowcaEntity getKosztyKierowca() {
        return kosztyKierowca;
    }

    public void setKosztyKierowca(KierowcaEntity kosztyKierowca) {
        this.kosztyKierowca = kosztyKierowca;
    }
}
