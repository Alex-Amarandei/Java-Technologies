package fii.jt.lab4.model;

/**
 * Class modelling the Tournament object
 */
public class Tournament {
    private int day;
    private String home;
    private String away;

    /**
     * Constructor
     *
     * @param day  the day in which it takes place
     * @param home home team's name
     * @param away away team's name
     */
    public Tournament(int day, String home, String away) {
        this.day = day;
        this.home = home;
        this.away = away;
    }

    /**
     * Getter for the day
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Setter for the day
     *
     * @param day the day it takes place
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Getter for the home team's name
     *
     * @return the home team's name
     */
    public String getHome() {
        return home;
    }

    /**
     * Setter for the home team's name
     *
     * @param home the home team's name
     */
    public void setHome(String home) {
        this.home = home;
    }

    /**
     * Getter for the away team's name
     *
     * @return the away team's name
     */
    public String getAway() {
        return away;
    }

    /**
     * Setter for the away team's name
     *
     * @param away the away team's name
     */
    public void setAway(String away) {
        this.away = away;
    }
}
