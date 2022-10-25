package fii.jt.lab3.controller;

import fii.jt.lab3.model.Team;
import fii.jt.lab3.repository.SportsDB;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller responsible with handling the Team-related database operations.
 */
@ManagedBean
@RequestScoped
public class TeamController implements Serializable {
    private List<Team> teams;

    /**
     * Getter for all the available teams list.
     * @return the existing teams
     */
    public List<Team> getTeams() {
        return this.teams;
    }

    /**
     * Retrieves the teams from the table
     */
    @PostConstruct
    public void init() {
        SportsDB sportsDB = new SportsDB();
        try {
            teams = sportsDB.retrieveTeams();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}