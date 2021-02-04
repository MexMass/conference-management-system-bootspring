package com.lukas.ramonas.cms.Model;

import javax.persistence.*;
import java.util.Collection;

/*******************************************
 * Defined role model
 *******************************************/
@Entity
@Table(name = "role_table", schema = "public")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "role_privilege_table",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id"))
    private Collection<Privilege> privileges;

    public String getName() {
        return this.name;
    }

    public Collection<Privilege> getPrivileges() {
        return this.privileges;
    }
}