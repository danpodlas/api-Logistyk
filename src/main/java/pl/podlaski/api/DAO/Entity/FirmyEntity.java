package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Firma")
public class FirmyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nip;
    private String telefonkontaktowy;
    private String miasto;
    private String ulica;
    private String nrdomu;
    private String email;
    private String haslo;
    private String numerkonta;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="role_id")
    private RoleEntity roleFirmy;

    @OneToOne(mappedBy="kosztyFirmy",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private KosztyEntity kosztyEntity;

    @OneToOne(mappedBy="zleceniFirmy",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private ZlecenieEntity zlecZlec;

    @OneToOne(mappedBy="przyjmFirmy",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private ZlecenieEntity przyjmZlec;

    public FirmyEntity() {
    }

//    public FirmyEntity(String nip, String telefonkontaktowy, String miasto, String ulica, String nrdomu, String email, String haslo, String numerkonta, RoleName role, ZlecenieEntity zlecenieEntity) {
//        this.nip = nip;
//        this.telefonkontaktowy = telefonkontaktowy;
//        this.miasto = miasto;
//        this.ulica = ulica;
//        this.nrdomu = nrdomu;
//        this.email = email;
//        this.haslo = haslo;
//        this.numerkonta = numerkonta;
//        this.role = role;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTelefonkontaktowy() {
        return telefonkontaktowy;
    }

    public void setTelefonkontaktowy(String telefonkontaktowy) {
        this.telefonkontaktowy = telefonkontaktowy;
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
}
