package ch.hearc.ig.odi.moviemanager.business;

/**
 *
 * @author dario.mosca
 */
public class Movie {

    private Long id;
    private String name;
    private String producer;

    public Movie() {
    }

    public Movie(Long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
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

}
