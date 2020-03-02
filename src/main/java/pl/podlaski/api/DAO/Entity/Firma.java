package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "firma")
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwafirmy;
    private String nip;
    private String telefonkontaktowy;
    private String miasto;
    private String ulica;
    private String nrdomu;
    private String email;
    private String haslo;
    private String numerkonta;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "roleid")
    private Role roleFirmy;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="samochodid")
    private Samochod samochod;

    public Firma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwafirmy() {
        return nazwafirmy;
    }

    public void setNazwafirmy(String nazwafirmy) {
        this.nazwafirmy = nazwafirmy;
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

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    @Override
    public String
    toString() {
        return "Firma{" +
                "id=" + id +
                ", nazwafirmy='" + nazwafirmy + '\'' +
                ", nip='" + nip + '\'' +
                ", telefonkontaktowy='" + telefonkontaktowy + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrdomu='" + nrdomu + '\'' +
                ", email='" + email + '\'' +
                ", haslo='" + haslo + '\'' +
                ", numerkonta='" + numerkonta + '\'' +
                ", roleFirmy=" + roleFirmy +
                ", samochod=" + samochod +
                '}';
    }
}
