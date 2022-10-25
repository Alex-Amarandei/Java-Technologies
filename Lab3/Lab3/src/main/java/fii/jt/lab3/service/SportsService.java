package fii.jt.lab3.service;

import fii.jt.lab3.model.Team;
import fii.jt.lab3.repository.SportsDB;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service managing operations related to the teams
 */
@Named
@ManagedBean
public class SportsService {
    private SportsDB sportsDB;

    /**
     * Constructor
     */
    @PostConstruct
    public void init() {
        sportsDB = new SportsDB();
    }

    /**
     * Method for retrieving all the available teams using the database connection
     * @return A list of all the available teams
     */
    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        try {
            teams = sportsDB.retrieveTeams();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teams;
    }
}
