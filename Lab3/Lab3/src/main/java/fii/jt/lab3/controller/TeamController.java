package fii.jt.lab3.controller;

import fii.jt.lab3.model.Team;
import fii.jt.lab3.model.Tournament;
import fii.jt.lab3.repository.SportsDB;
import fii.jt.lab3.service.MatchMaker;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
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
    private List<Tournament> pairings;

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

    /**
     * Uses the matchmaker to create a tournament
     */
    public void createTournament() throws IOException {
        MatchMaker matchMaker = new MatchMaker(teams);
        this.pairings = matchMaker.getPairings();
        System.out.println(this.pairings);
        FacesContext.getCurrentInstance().getExternalContext().redirect("tournament.xhtml");
    }

    /**
     * Getter for pairings
     * @return the pairings
     */
    public List<Tournament> getPairings() {
        System.out.println(pairings);
        return pairings;
    }
}