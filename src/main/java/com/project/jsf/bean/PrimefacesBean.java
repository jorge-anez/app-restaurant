package com.project.jsf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;


@ManagedBean
@RequestScoped
@Component
public class PrimefacesBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //@Autowired
    //private PersonService personService;

    private String firstName;
    private String lastName;
    public void save(){
        //System.out.println("save example" + personService);
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
}