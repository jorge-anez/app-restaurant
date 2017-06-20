package com.project.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQuery;

/**
 * Created by JORGE-HP on 31/1/2017.
 */

@Entity
@Table(name="t_person")
@NamedQuery(name = "getUserByUsername", query = "from Person p where p.firstName = :username")
public class Person {
    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int personId;

    private String firstName;
    private String lastName;
    private String email;
    private String address;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
