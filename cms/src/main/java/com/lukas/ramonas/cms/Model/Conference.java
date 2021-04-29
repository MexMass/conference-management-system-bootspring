package com.lukas.ramonas.cms.Model;

import javax.persistence.*;
import java.sql.Date;


/*******************************************
 * Defined conference model
 *******************************************/
@Entity
@Table(name = "conference_table", schema = "public")
public class Conference {

    @Id
    @Column(name = "conference_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conference_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User creator ;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "startConference")
    private Date startConference;

    @Column(name = "endConference")
    private Date endConference;

/*******************************************
 * Setters and getters
 *******************************************/


    public Long getConference_id() {
        return conference_id;
    }

    public void setConference_id(Long conference_id) {
        this.conference_id = conference_id;
    }

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