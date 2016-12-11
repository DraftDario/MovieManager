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
 * The bean for the editMovies.xhtml page
 * @author dario.mosca
 */
@Named(value = "editMovies")
@ViewScoped
public class editMoviesBean implements Serializable {

    @Inject
    Services services;

    private Movie movie;
    private Long movieID;

    /**
     * Creates a new instance of editMoviesBean
     */
    public editMoviesBean() {
        this.movie = new Movie();
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
     * Getter for movieID
     * @return the movie's ID
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
        this.movie = services.getMovieWithId(movieID);
    }

    /**
     * Initialize the movie with the ID in parameter
     */
    public void init() {
        String idParam = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");
        if (!(idParam == null || idParam.isEmpty())) {
            movieID = new Long(idParam);
            movie = services.getMovieWithId(movieID);
        }
    }

    /**
     * Update the movie
     * @return the home page
     */
    public String updateMovie() {
        services.getMovieWithId(movieID).setName(movie.getName());
        services.getMovieWithId(movieID).setProducer(movie.getProducer());
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * Add a movie
     * @return the home page
     * @throws NullParameterException if the value in NULL
     */
    public String addMovie() throws NullParameterException {
        movie.setPeople(new ArrayList<Person>());
        services.saveMovie(movie);
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * reset the text imputs
     * @return the page for editing
     */
    public String resetMovie() {
        this.movie.setName("");
        this.movie.setProducer("");
        if (movieID != null) {
            return "editMovies.xhtml?faces-redirect=true&id=" + movieID;
        } else {
            return "resetForm";
        }
    }

    /**
     * Fo to home page
     * @return the home page
     */
    public String returnHome() {
        return "index.xhtml?faces-redirect=true";
    }
}
