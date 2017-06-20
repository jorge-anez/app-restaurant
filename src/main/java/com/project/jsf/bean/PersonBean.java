package com.project.jsf.bean;

import com.project.model.transer.PersonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@SessionScoped
@Component  // cuando se usa servicios y spring
public class PersonBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private PersonTransfer personTransfer;
    private List<PersonTransfer> personTransfers;


    @PostConstruct
    public void init(){
        personTransfer = new PersonTransfer();
    }

    public void addPerson(){
        //System.out.print("Name:" + firstName);
        //System.out.print("Last name:" + lastName);
        //personService.addPerson(personTransfer);

    }

    public List<PersonTransfer> getPersonTransfers() {
        //if(personTransfers == null || personTransfers.isEmpty())
            //personTransfers = personService.listPersonsTransfer();
        return personTransfers;
    }

    public void setPersonTransfers(List<PersonTransfer> personTransfers) {
        this.personTransfers = personTransfers;
    }

    public PersonTransfer getPersonTransfer() {
        return personTransfer;
    }

    public void setPersonTransfer(PersonTransfer personTransfer) {
        this.personTransfer = personTransfer;
    }
}
