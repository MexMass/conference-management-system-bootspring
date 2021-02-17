package com.lukas.ramonas.cms.DAO;

import com.lukas.ramonas.cms.Validators.PasswordMatches;
import com.lukas.ramonas.cms.Validators.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Data Transfer Object to send all of the registration information to backend.

@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String roles;

    @NotNull
    @NotEmpty
    private Boolean confirmed;

    // Standard getters and setters

    /*
    * Set and get Name
    */
    public void setName(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /*
     * Set and get Username
     */
    public void setUsername(@NotNull @NotEmpty String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    /*
     * Set and get Password
     */
    public void setPassword(@NotNull @NotEmpty String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    /*
     * Set and get Matching Password
     */
    public void setMatchingPassword(@NotNull @NotEmpty String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getMatchingPassword() {
        return this.matchingPassword;
    }

    /*
     * Set and get Email
     */
    public void setEmail(@NotNull @NotEmpty String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    /*
     * Set and get Roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRoles() { return this.roles;
    }

}

