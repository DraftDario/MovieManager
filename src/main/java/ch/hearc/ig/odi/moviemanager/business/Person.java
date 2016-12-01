package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario.mosca
 */
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private List movies;

    public Person() {
        this.movies = new ArrayList();
    }

    public Person(Long id, String firstName, String lastName) {
        this.movies = new ArrayList();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Long id, String firstName, String lastName, List movies) {
        this.movies = new ArrayList();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List getMovies() {
        return movies;
    }

    public void setMovies(List movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) throws NullParameterException, UniqueException{
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
    }
}
