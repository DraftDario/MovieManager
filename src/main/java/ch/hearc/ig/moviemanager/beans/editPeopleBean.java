/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author dario.mosca
 */
@Named(value = "editPeople")
@ViewScoped
public class editPeopleBean implements Serializable {

    @Inject
    Services services;

    private Person person;
    private Long personID;

    /**
     * Creates a new instance of editPeopleBean
     */
    public editPeopleBean() {
        this.person = new Person();
    }

    /**
     * Getter for person
     *
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Setter for person
     *
     * @param person the parameter to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Getter ofr personID
     *
     * @return the person's ID
     */
    public Long getPersonID() {
        return personID;
    }

    /**
     * Setter for personID
     *
     * @param personID the parameter to set
     */
    public void setPersonID(Long personID) {
        this.personID = personID;
        this.person = services.getPersonWithId(personID);
    }

    /**
     * Init the person with the parameter
     */
    public void init() {
        String idParam = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");
        if (!(idParam == null || idParam.isEmpty())) {
            personID = new Long(idParam);
            person = services.getPersonWithId(personID);
        }
    }

    /**
     * update the person with new values and return to index.xhtml
     *
     * @return the xhtml page
     */
    public String updatePerson() {
        services.getPersonWithId(personID).setFirstName(person.getFirstName());
        services.getPersonWithId(personID).setLastName(person.getLastName());
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * add a person in the list
     *
     * @return the xhtml page index
     * @throws NullParameterException if null
     */
    public String addPerson() throws NullParameterException {
        person.setMovies(new ArrayList<Movie>());
        services.savePerson(person);
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * Reset the current person's firstname and lastname
     *
     * @return the xhtml page edit
     */
    public String resetPerson() {
        this.person.setFirstName("");
        this.person.setLastName("");
        if (personID != null) {
            return "editPeople.xhtml?faces-redirect=true&id=" + personID;
        } else {
            return "resetForm";
        }
    }

    /**
     * return in the homepage
     *
     * @return the index.xhtml page
     */
    public String returnHome() {
        return "index.xhtml?faces-redirect=true";
    }
}
