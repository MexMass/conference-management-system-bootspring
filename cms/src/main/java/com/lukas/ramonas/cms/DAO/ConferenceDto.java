package com.lukas.ramonas.cms.DAO;

import com.lukas.ramonas.cms.Model.User;
import com.lukas.ramonas.cms.Validators.PasswordMatches;
import com.lukas.ramonas.cms.Validators.ValidEmail;

import javax.validation.constraints.*;
import java.sql.Date;

public class ConferenceDto {

//    @NotNull
//    @NotEmpty
//    private String user ;
    private User creator ;
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 32,message = "Name size must be between 6 and 32 characters")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 255,message = "Name size must be between 6 and 255 characters")
    private String description;


    private Date startConference;

    private Date endConference;


    // Standard getters and setters


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartConference() {
        return startConference;
    }

    public void setStartConference(Date startConference) {
        this.startConference = startConference;
    }

    public Date getEndConference() {
        return endConference;
    }

    public void setEndConference(Date endConference) {
        this.endConference = endConference;
    }
}
