/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.InvalidParameterException;
import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.IOException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author dario.mosca
 */
@Named(value = "moviesList")
@RequestScoped
public class moviesListBean {

    @Inject
    Services services;

    private List<Movie> moviesList;
    private Person person;
    private Long personID;

    /**
     * Creates a new instance of moviesListBean
     */
    public moviesListBean() {
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    /**
     * Retrieves the person object corresponding to the request's parameter id
     *
     */
    public void init() {
        person = services.getPersonWithId(personID);
    }

    public String deleteMovie() throws NullParameterException, InvalidParameterException {
        String idParam = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("deleteId");
        Movie movDel = services.getMovieWithId(Long.parseLong(idParam));
        services.removeMovieFromPerson(person, movDel);
        return "moviesList.xhtml?faces-redirect=true";
    }

}
