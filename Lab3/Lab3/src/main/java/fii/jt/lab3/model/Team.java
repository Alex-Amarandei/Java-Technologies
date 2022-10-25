package fii.jt.lab3.model;

/**
 * The Team Model
 */
public class Team {
    private final Long id;
    private String name;
    private String foundingDate;
    private final Long cityId;

    /**
     * Constructor for the Team class.
     * @param id The unique id of the team
     * @param name The name of the team
     * @param foundingDate The date the team was founded on
     * @param cityId The id of the city the team belongs to
     */
    public Team(Long id, String name, String foundingDate, Long cityId) {
        this.id = id;
        this.name = name;
        this.foundingDate = foundingDate;
        this.cityId = cityId;
    }

    /**
     * Getter for the team's id.
     * @return the team's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter for the team's name.
     * @return the team's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the team's name.
     * @param name the team's desired name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the team's founding date.
     * @return the team's founding date
     */
    public String getFoundingDate() {
        return foundingDate;
    }

    /**
     * Setter for the team's founding date.
     * @param foundingDate the team's founding date
     */
    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    /**
     * Getter for the city id foreign key.
     * @return the id of the city the team belongs to
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Creates a nice way of visualising info about the team
     * @return a string containing all the information available about the team
     */
    @Override
    public String toString() {
        return "Team Info: " + "\n    name: " + name + "\n    founding date: " + foundingDate + "\n    city: " + cityId + '\n';
    }
}