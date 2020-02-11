package pl.podlaski.api.DAO.Entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "Zlecenie")
public class Zlecenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zlec_firmyEntity_id", referencedColumnName = "id")
    private Firma zlecFirma;

    @OneToOne
    @JoinColumn(name = "zlec_klientEntity_id", referencedColumnName = "id")
    private Klient zlecenieKlient;

    private String adreszal;
    private String adresroz;

    @ManyToOne
    @JoinColumn(name = "przyjm_firmyEntity_id", referencedColumnName = "id")
    private Firma przyjmFirma;

    @OneToOne
    @JoinColumn(name = "przyjm_kierowcaEntity_id", referencedColumnName = "id")
    private Kierowca przyjmKierowca;

    private String oskontakt;
    private int ilosckm;
    private double stawka;
    private double wartzlec;
    private String typladunku;
    private String specjalny;
    private int waga;

    @Temporal(TemporalType.DATE)
    private Date datautworzenia;

    @Temporal(TemporalType.DATE)
    private Date dataprzyjecia;

    @Temporal(TemporalType.DATE)
    private Date datazakonczenia;

    public Zlecenie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Firma getZlecFirma() {
        return zlecFirma;
    }

    public void setZlecFirma(Firma zlecFirma) {
        this.zlecFirma = zlecFirma;
    }

    public Klient getZlecenieKlient() {
        return zlecenieKlient;
    }

    public void setZlecenieKlient(Klient zlecenieKlient) {
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

    public Firma getPrzyjmFirma() {
        return przyjmFirma;
    }

    public void setPrzyjmFirma(Firma przyjmFirma) {
        this.przyjmFirma = przyjmFirma;
    }

    public Kierowca getPrzyjmKierowca() {
        return przyjmKierowca;
    }

    public void setPrzyjmKierowca(Kierowca przyjmKierowca) {
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

    public Date getDatautworzenia() {
        return datautworzenia;
    }

    public void setDatautworzenia(Date datautworzenia) throws ParseException {
        this.datautworzenia = datautworzenia;
    }

    public Date getDataprzyjecia() {
        return dataprzyjecia;
    }

    public void setDataprzyjecia(Date dataprzyjecia) {
        this.dataprzyjecia = dataprzyjecia;
    }

    public Date getDatazakonczenia() {
        return datazakonczenia;
    }

    public void setDatazakonczenia(Date datazakonczenia) {
        this.datazakonczenia = datazakonczenia;
    }


    @Override
    public String toString() {
        return "Zlecenie{" +
                "id=" + id +
                ", zlecFirma=" + zlecFirma +
                ", zlecenieKlient=" + zlecenieKlient +
                ", adreszal='" + adreszal + '\'' +
                ", adresroz='" + adresroz + '\'' +
                ", przyjmFirma=" + przyjmFirma +
                ", przyjmKierowca=" + przyjmKierowca +
                ", oskontakt='" + oskontakt + '\'' +
                ", ilosckm=" + ilosckm +
                ", stawka=" + stawka +
                ", wartzlec=" + wartzlec +
                ", typladunku='" + typladunku + '\'' +
                ", specjalny='" + specjalny + '\'' +
                ", waga=" + waga +
                ", datautworzenia=" + datautworzenia +
                ", dataprzyjecia=" + dataprzyjecia +
                ", datazakonczenia=" + datazakonczenia +
                '}';
    }
}
