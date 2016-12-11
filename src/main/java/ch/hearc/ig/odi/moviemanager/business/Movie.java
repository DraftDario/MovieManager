package ch.hearc.ig.odi.moviemanager.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Business class for Movie
 * @author dario.mosca
 */
public class Movie {

    private Long id;
    private String name;
    private String producer;
    private List people;

    public Movie() {
        this.people = new ArrayList();
    }

    public Movie(Long id, String name, String producer) {
        this.people = new ArrayList();
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

    public Movie(Long id, String name, String producer, List persons) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.people = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List getPeople() {
        return people;
    }

    public void setPeople(List people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void removePerson(Person person) {
        this.people.remove(person);
    }
}
