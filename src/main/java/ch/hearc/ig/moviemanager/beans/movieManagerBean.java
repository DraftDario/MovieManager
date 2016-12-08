package ch.hearc.ig.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * This bean is for index.xhtml
 *
 * @author dario.mosca
 */
@Named(value = "movieManager")
@ViewScoped
public class movieManagerBean implements Serializable{

    @Inject
    Services services;

    private List<Person> peopleList;
    private List<Movie> moviesList;

    /**
     * Creates a new instance of movieManagerBean
     */
    public movieManagerBean() {
    }

    /**
     * Getter for peopleList
     *
     * @return List of people
     */
    public List<Person> getPeopleList() {
        return peopleList;
    }

    /**
     * Setter for peopleList
     *
     * @param peopleList parameter to set
     */
    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    /**
     * Getter for moviesList
     *
     * @return List of movies
     */
    public List<Movie> getMoviesList() {
        return moviesList;
    }

    /**
     * Setter for moviesList
     *
     * @param moviesList parameter to set
     */
    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    /**
     * Init the 2 lists whit values to use them in the index.xhtml
     */
    public void init() {
        this.peopleList = services.getPeopleList();
        this.moviesList = services.getMoviesList();
    }

}
