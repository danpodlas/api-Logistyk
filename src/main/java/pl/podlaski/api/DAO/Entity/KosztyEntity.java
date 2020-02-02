package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.RodzajeKosztow;

import javax.persistence.*;

@Entity
public class KosztyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
    private SamochodEntity samochodEntity;

    private RodzajeKosztow rodzajeKosztow;
    private Double kwota;
    private String data;
    private String notka;

    @OneToOne
    @JoinColumn(name = "firmyEntity_id", referencedColumnName = "id")
    private FirmyEntity przyjmfirmyEntity;

    @OneToOne
    @JoinColumn(name = "klientEntity_id", referencedColumnName = "id")
    private KierowcaEntity kierowcaEntity;

    public KosztyEntity() {
    }

    public KosztyEntity(Long id, SamochodEntity samochodEntity, RodzajeKosztow rodzajeKosztow, Double kwota, String data, String notka, FirmyEntity przyjmfirmyEntity, KierowcaEntity kierowcaEntity) {
        this.id = id;
        this.samochodEntity = samochodEntity;
        this.rodzajeKosztow = rodzajeKosztow;
        this.kwota = kwota;
        this.data = data;
        this.notka = notka;
        this.przyjmfirmyEntity = przyjmfirmyEntity;
        this.kierowcaEntity = kierowcaEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SamochodEntity getSamochodEntity() {
        return samochodEntity;
    }

    public void setSamochodEntity(SamochodEntity samochodEntity) {
        this.samochodEntity = samochodEntity;
    }

    public RodzajeKosztow getRodzajeKosztow() {
        return rodzajeKosztow;
    }

    public void setRodzajeKosztow(RodzajeKosztow rodzajeKosztow) {
        this.rodzajeKosztow = rodzajeKosztow;
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

    public FirmyEntity getPrzyjmfirmyEntity() {
        return przyjmfirmyEntity;
    }

    public void setPrzyjmfirmyEntity(FirmyEntity przyjmfirmyEntity) {
        this.przyjmfirmyEntity = przyjmfirmyEntity;
    }

    public KierowcaEntity getKierowcaEntity() {
        return kierowcaEntity;
    }

    public void setKierowcaEntity(KierowcaEntity kierowcaEntity) {
        this.kierowcaEntity = kierowcaEntity;
    }
}
