package org.hibernate.tutorial.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "EVENTS")
public class Event {
    private Long id;

    private String title;
    private Date date;

    public Event() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "EVENT_TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}