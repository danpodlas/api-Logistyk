package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "firma")
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nip;
    private String telefonkontaktowy;
    private String miasto;
    private String ulica;
    private String nrdomu;
    private String email;
    private String haslo;
    private String numerkonta;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "role_id")
    private Role roleFirmy;

    public Firma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Role getRoleFirmy() {
        return roleFirmy;
    }

    public void setRoleFirmy(Role roleFirmy) {
        this.roleFirmy = roleFirmy;
    }
}
