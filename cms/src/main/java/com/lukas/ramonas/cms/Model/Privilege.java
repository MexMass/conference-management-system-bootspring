package com.lukas.ramonas.cms.Model;

import javax.persistence.*;
import java.util.Collection;

/*******************************************
 * Defined privilege model
 *******************************************/
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int privilege_id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public String getName() {
        return this.name;
    }
}