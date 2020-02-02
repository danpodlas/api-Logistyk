package pl.podlaski.api.DAO.Entity;

import pl.podlaski.api.DAO.Constans.Role;

import javax.persistence.*;

@Entity
public class FirmyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regon;
    private String nip;
    private String telefonkontaktowy;
    private String miasto;
    private String ulica;
    private String nrdomu;
    private String email;
    private String haslo;
    private String numerkonta;
    private Role role;

    public FirmyEntity() {
    }

    public FirmyEntity(Long id, String regon, String nip, String telefonkontaktowy, String miasto, String ulica, String nrdomu, String email, String haslo, String numerkonta, Role role, ZlecenieEntity zlecenieEntity) {
        this.id = id;
        this.regon = regon;
        this.nip = nip;
        this.telefonkontaktowy = telefonkontaktowy;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrdomu = nrdomu;
        this.email = email;
        this.haslo = haslo;
        this.numerkonta = numerkonta;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
