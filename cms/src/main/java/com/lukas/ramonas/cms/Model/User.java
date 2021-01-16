package com.lukas.ramonas.cms.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


/*******************************************
 * Defined user model
 *******************************************/
@Entity(name = "User")
@Table(name = "user_table", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int user_id;

    private String name;

//    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String email;

    private boolean confirmed;

    @ManyToMany
    @JoinTable(
            name = "role_table",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;



/*******************************************
* Setters and getters
*******************************************/

    public Integer getId() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setRole(Collection roles) {
        this.roles = roles;
    }
}