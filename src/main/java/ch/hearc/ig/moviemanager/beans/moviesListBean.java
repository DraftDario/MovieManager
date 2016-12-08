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
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.List;
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
    private Movie movie;

    /**
     * Creates a new instance of moviesListBean
     */
    public moviesListBean() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public List getOtherMovies() {
        List<Movie> movies = services.getMoviesList();
        List<Movie> personMovies = person.getMovies();

        for (int i = 0; i < personMovies.size(); i++) {
            for (int j = 0; j < movies.size(); j++) {
                if (movies.get(j).getName().equals(personMovies.get(i).getName())) {
                    movies.remove(movies.get(j));
                    break;
                }
            }
        }

        return movies;
    }

    public void addMovie() throws NullParameterException, UniqueException {
        if (movie != null) {
            person.addMovie(movie);
        }
    }
}
