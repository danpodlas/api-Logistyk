package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;

@Entity
public class ZlecenieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "zlec_firmyEntity_id", referencedColumnName = "id")
    private FirmyEntity firmyEntity;

    @OneToOne
    @JoinColumn(name = "zlec_klientEntity_id", referencedColumnName = "id")
    private KlientEntity klientEntity;

    private String adreszal;
    private String adresroz;
    @OneToOne
    @JoinColumn(name = "przyjm_firmyEntity_id", referencedColumnName = "id")
    private FirmyEntity przyjmfirmyEntity;

    @OneToOne
    @JoinColumn(name = "przyjm_klientEntity_id", referencedColumnName = "id")
    private KierowcaEntity kierowcaEntity;

    private String oskontakt;
    private int ilosckm;
    private double stawka;
    private double wartZlec;
    private String typladunku;
    private String specjalny;
    private int waga;


    public ZlecenieEntity() {
    }

    public ZlecenieEntity(Long id, FirmyEntity firmyEntity, KlientEntity klientEntity, String adreszal, String adresroz, FirmyEntity przyjmfirmyEntity, KierowcaEntity kierowcaEntity, String oskontakt, int ilosckm, double stawka, double wartZlec, String typladunku, String specjalny, int waga) {
        this.id=id;
        this.firmyEntity = firmyEntity;
        this.klientEntity = klientEntity;
        this.adreszal = adreszal;
        this.adresroz = adresroz;
        this.przyjmfirmyEntity = przyjmfirmyEntity;
        this.kierowcaEntity = kierowcaEntity;
        this.oskontakt = oskontakt;
        this.ilosckm = ilosckm;
        this.stawka = stawka;
        this.wartZlec = wartZlec;
        this.typladunku = typladunku;
        this.specjalny = specjalny;
        this.waga = waga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FirmyEntity getFirmyEntity() {
        return firmyEntity;
    }

    public void setFirmyEntity(FirmyEntity firmyEntity) {
        this.firmyEntity = firmyEntity;
    }

    public KlientEntity getKlientEntity() {
        return klientEntity;
    }

    public void setKlientEntity(KlientEntity klientEntity) {
        this.klientEntity = klientEntity;
    }

    public String getAdreszal() {
        return adreszal;
    }

    public void setAdreszal(String adreszal) {
        this.adreszal = adreszal;
    }

    public String getAdresroz() {
        return adresroz;
    }

    public void setAdresroz(String adresroz) {
        this.adresroz = adresroz;
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

    public String getOskontakt() {
        return oskontakt;
    }

    public void setOskontakt(String oskontakt) {
        this.oskontakt = oskontakt;
    }

    public int getIlosckm() {
        return ilosckm;
    }

    public void setIlosckm(int ilosckm) {
        this.ilosckm = ilosckm;
    }

    public double getStawka() {
        return stawka;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }

    public double getWartZlec() {
        return wartZlec;
    }

    public void setWartZlec(double wartZlec) {
        this.wartZlec = wartZlec;
    }

    public String getTypladunku() {
        return typladunku;
    }

    public void setTypladunku(String typladunku) {
        this.typladunku = typladunku;
    }

    public String getSpecjalny() {
        return specjalny;
    }

    public void setSpecjalny(String specjalny) {
        this.specjalny = specjalny;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }
}
