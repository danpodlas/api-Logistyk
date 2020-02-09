package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Zlecenie")
public class ZlecenieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "zlecZlec")
    private Set<FirmyEntity> zleceniFirmyList = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "zlec_klientEntity_id", referencedColumnName = "id")
    private KlientEntity zlecenieKlient;

    private String adreszal;
    private String adresroz;

    @OneToMany(mappedBy = "przyjmZlec")
    private Set<FirmyEntity> przyjmFirmyList = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "przyjm_kierowcaEntity_id", referencedColumnName = "id")
    private KierowcaEntity przyjmKierowca;

    private String oskontakt;
    private int ilosckm;
    private double stawka;
    private double wartzlec;
    private String typladunku;
    private String specjalny;
    private int waga;

    public ZlecenieEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<FirmyEntity> getZleceniFirmyList() {
        return zleceniFirmyList;
    }

    public void setZleceniFirmyList(Set<FirmyEntity> zleceniFirmyList) {
        this.zleceniFirmyList = zleceniFirmyList;
    }

    public KlientEntity getZlecenieKlient() {
        return zlecenieKlient;
    }

    public void setZlecenieKlient(KlientEntity zlecenieKlient) {
        this.zlecenieKlient = zlecenieKlient;
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

    public Set<FirmyEntity> getPrzyjmFirmyList() {
        return przyjmFirmyList;
    }

    public void setPrzyjmFirmyList(Set<FirmyEntity> przyjmFirmyList) {
        this.przyjmFirmyList = przyjmFirmyList;
    }

    public KierowcaEntity getPrzyjmKierowca() {
        return przyjmKierowca;
    }

    public void setPrzyjmKierowca(KierowcaEntity przyjmKierowca) {
        this.przyjmKierowca = przyjmKierowca;
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

    public double getWartzlec() {
        return wartzlec;
    }

    public void setWartzlec(double wartzlec) {
        this.wartzlec = wartzlec;
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
