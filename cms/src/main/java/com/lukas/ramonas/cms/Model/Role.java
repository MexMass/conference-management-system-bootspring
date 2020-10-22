package com.lukas.ramonas.cms.Model;

import javax.persistence.*;
import java.util.Collection;

/*******************************************
 * Defined role model
 *******************************************/
@Entity(name = "Role")
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer role_id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;
}