package com.lukas.ramonas.cms.DAO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Data Transfer Object to send all of the registration information to backend.

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

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private Boolean confirmed;

    // Standard getters and setters

    // Set and get Name

    public void setName(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Set and get Username

    public void setUsername(@NotNull @NotEmpty String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    // Set and get Password

    public void setPassword(@NotNull @NotEmpty String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    // Set and get matchingPassword

    public void setMatchingPassword(@NotNull @NotEmpty String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getMatchingPassword() {
        return this.matchingPassword;
    }

    // Set and get Email

    public void setEmail(@NotNull @NotEmpty String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    // Set and get Confirmed

    public void setConfirmed(@NotNull @NotEmpty Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }
}