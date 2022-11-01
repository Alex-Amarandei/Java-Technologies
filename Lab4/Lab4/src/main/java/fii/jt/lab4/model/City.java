package fii.jt.lab4.model;

/**
 * The City Model
 */
public class City {
    private final Long id;
    private String name;

    /**
     * Constructor for the City class.
     * @param id The unique id
     * @param name The city's name
     */
    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * The only relevant information about the city, when converting to string, is its name.
     * @return the city's name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Getter for the city's id.
     * @return the city's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter for the city's name.
     * @return the city's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the city's name.
     * @param name the city's desired name
     */
    public void setName(String name) {
        this.name = name;
    }
}

