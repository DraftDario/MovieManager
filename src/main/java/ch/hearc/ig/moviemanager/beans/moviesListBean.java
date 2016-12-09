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
 * This bean is for moviesList.xhtml
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

    /**
     * Getter for movie
     *
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Setter for movie
     *
     * @param movie parameter to set
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Getter for personID
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
     * Retrieves the person object corresponding to the request's parameter id
     *
     */
    public void init() {
        person = services.getPersonWithId(personID);
    }

    /**
     * Delete a movie from the movieList for the current person
     *
     * @param movie the movie to delete
     * @throws NullParameterException exception if null parameter
     * @throws InvalidParameterException exception if parameter not valid
     */
    public void deleteMovie(Movie movie) throws NullParameterException, InvalidParameterException {
        services.removeMovieFromPerson(person, movie);
    }

    /**
     * Method to get all the movies that are not in the current person movies'
     * list
     *
     * @return the list of other movies
     */
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

    /**
     * Method to add a movie in the current person movies' list
     *
     * @throws NullParameterException if parameter null
     * @throws UniqueException if not unique
     */
    public void addMovie() throws NullParameterException, UniqueException {
        if (movie != null) {
            services.addMovieToPerson(person, movie);
        }
    }
}
