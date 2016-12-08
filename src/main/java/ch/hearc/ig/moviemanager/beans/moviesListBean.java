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
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author dario.mosca
 */
@Named(value = "moviesList")
@ViewScoped
public class moviesListBean implements Serializable {

    @Inject
    Services services;

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

    /**
     * Retrieves the person object corresponding to the request's parameter id
     *
     */
    public void init() {
        person = services.getPersonWithId(personID);
    }

    public void deleteMovie(Movie movie) throws NullParameterException, InvalidParameterException {
        services.removeMovieFromPerson(person, movie);
    }
}
