package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Zlecenie")
public class ZlecenieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "zlec_firmyEntity_id", referencedColumnName = "id")
    private FirmyEntity zleceniFirmy;

    @OneToOne
    @JoinColumn(name = "zlec_klientEntity_id", referencedColumnName = "id")
    private KlientEntity zlecenieKlient;

    private String adreszal;
    private String adresroz;
    @OneToOne
    @JoinColumn(name = "przyjm_firmyEntity_id", referencedColumnName = "id")
    private FirmyEntity przyjmFirmy;

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

}
