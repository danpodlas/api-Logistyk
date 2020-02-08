package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Kierowca")
public class KierowcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String nazwisko;
    private String peselnip;
    private String telefon;
    private String miasto;
    private String ulica;
    private String nrdomu;
    private String datazatrudnienia;
    private String email;
    private String haslo;
    private String numerkonta;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="role_id")
    private RoleEntity roleKierowca;

    @OneToOne(mappedBy="kosztyKierowca",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private KosztyEntity kosztyEntity;

    @OneToOne(mappedBy="przyjmKierowca",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private ZlecenieEntity zlecenieEntity;

    public KierowcaEntity() {
    }

//    public KierowcaEntity(Long id, String imie, String nazwisko, String peselnip, String telefon, String miasto, String ulica, String nrdomu, String datazatrudnienia, String email, String haslo, String numerkonta, RoleName role, SamochodEntity samochodEntity) {
//        this.id = id;
//        this.imie = imie;
//        this.nazwisko = nazwisko;
//        this.peselnip = peselnip;
//        this.telefon = telefon;
//        this.miasto = miasto;
//        this.ulica = ulica;
//        this.nrdomu = nrdomu;
//        this.datazatrudnienia = datazatrudnienia;
//        this.email = email;
//        this.haslo = haslo;
//        this.numerkonta = numerkonta;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPeselnip() {
        return peselnip;
    }

    public void setPeselnip(String peselnip) {
        this.peselnip = peselnip;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrdomu() {
        return nrdomu;
    }

    public void setNrdomu(String nrdomu) {
        this.nrdomu = nrdomu;
    }

    public String getDatazatrudnienia() {
        return datazatrudnienia;
    }

    public void setDatazatrudnienia(String datazatrudnienia) {
        this.datazatrudnienia = datazatrudnienia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getNumerkonta() {
        return numerkonta;
    }

    public void setNumerkonta(String numerkonta) {
        this.numerkonta = numerkonta;
    }

    public RoleEntity getRoleKierowca() {
        return roleKierowca;
    }

    public void setRoleKierowca(RoleEntity roleKierowca) {
        this.roleKierowca = roleKierowca;
    }
}
