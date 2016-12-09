/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author dario.mosca
 */
@Named(value = "movieDetails")
@ViewScoped
public class movieDetailsBean implements Serializable {

    @Inject
    Services services;

    private Person person;
    private Long movieID;
    private Movie movie;

    /**
     * Creates a new instance of movieDetails
     */
    public movieDetailsBean() {
    }

    /**
     * Getter for person
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Setter for person
     * @param person the parameter to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Getter for the movie ID
     * @return the movie ID
     */
    public Long getMovieID() {
        return movieID;
    }

    /**
     * Setter for movieID
     * @param movieID the parameter to set
     */
    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    /**
     * Getter for movie
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Setter for movie
     * @param movie the parameter to set
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * A method to init the xhtml page.
     * It initialize the movie whit the parameter in the other page
     */
    public void init() {
        movie = services.getMovieWithId(movieID);
    }
}
