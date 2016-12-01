package ch.hearc.ig.odi.moviemanager.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dario.mosca
 */
public class Movie {

    private Long id;
    private String name;
    private String producer;
    private List persons;

    public Movie() {
        this.persons = new ArrayList();
    }

    public Movie(Long id, String name, String producer) {
        this.persons = new ArrayList();
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

    public Movie(Long id, String name, String producer, List persons) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.persons = persons;
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

    public List getPersons() {
        return persons;
    }

    public void setPersons(List persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public void removePerson(Person person) {
        this.persons.remove(person);
    }
}
