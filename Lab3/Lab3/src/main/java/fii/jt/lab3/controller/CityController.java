package fii.jt.lab3.controller;

import fii.jt.lab3.model.City;
import fii.jt.lab3.repository.SportsDB;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller responsible with handling the City-related database operations.
 */
@ManagedBean
@ApplicationScoped
public class CityController implements Serializable {
    private List<City> cities;
    private String city;

    /**
     * Getter for all the available cities list.
     * @return the existing cities
     */
    public List<City> getCities() {
        return this.cities;
    }

    /**
     * Getter for City
     * @return The currently selected city's name
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for City
     * @param city City to select
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the cities from the table
     */
    @PostConstruct
    public void init() {
        SportsDB sportsDB = new SportsDB();
        try {
            cities = sportsDB.retrieveCities();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

