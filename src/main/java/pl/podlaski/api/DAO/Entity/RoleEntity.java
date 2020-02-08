package pl.podlaski.api.DAO.Entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToOne(mappedBy="roleKlient",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private KlientEntity klientEntity;

    @OneToOne(mappedBy="roleKierowca",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private KierowcaEntity kierowcaEntity;

    @OneToOne(mappedBy="roleFirmy",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private FirmyEntity firmyEntity;
}
