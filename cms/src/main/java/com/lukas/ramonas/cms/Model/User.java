package com.lukas.ramonas.cms.Model;

import com.lukas.ramonas.cms.Validators.ValidEmail;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*******************************************
 * Defined user model
 *******************************************/
@Entity
@Table(name = "user_table", schema = "public")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "confirmed")
    private boolean confirmed;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_table",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles = new HashSet<>();

/*******************************************
 * Setters and getters
 *******************************************/

    public Long getId() {
        return user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setRoles(Collection roles) {
        this.roles = roles;
    }

    public Collection<Role> getRoles() { return this.roles;
    }

    @Override
    public String toString() {
        return this.name;
    }
}