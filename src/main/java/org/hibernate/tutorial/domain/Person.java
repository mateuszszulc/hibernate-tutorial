package org.hibernate.tutorial.domain;

import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 16.04.12
 * Time: 19:19
 */

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int age;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @ElementCollection
    private Set<String> emailAddresses = new HashSet<String>();

    public Set<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set getEvents() {
        return events;
    }

    public void setEvents(Set events) {
        this.events = events;
    }

    @ManyToMany(targetEntity = org.hibernate.tutorial.domain.Event.class,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="PERSON_EVENT",
    joinColumns =@JoinColumn(name="PERS_ID"),
    inverseJoinColumns = @JoinColumn(name="EV_ID"))
    private Set events = new HashSet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Person() { }
}
