package fii.jt.lab4.controller;

import fii.jt.lab4.model.Team;
import fii.jt.lab4.model.Tournament;
import fii.jt.lab4.repository.SportsDB;
import fii.jt.lab4.service.MatchMaker;

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
    private String selectedTeamName;
    private String selectedTeamFoundingDate;
    private Long selectedTeamCityId;
    private SportsDB sportsDB;
    private List<Team> teams;
    private List<Tournament> pairings;

    /**
     * Getter for all the available teams list.
     *
     * @return the existing teams
     */
    public List<Team> getTeams() {
        return this.teams;
    }

    /**
     * Used for refreshing the database after an update was made
     *
     * @throws SQLException In case of a malfunction with regard to the connection
     */
    public void refresh() throws SQLException {
        teams = sportsDB.retrieveTeams();
    }

    /**
     * Called for adding a new team to the database
     *
     * @throws SQLException In case of a malfunction with regard to the connection
     */
    public void addTeam() throws SQLException {
        sportsDB.storeTeam(selectedTeamName, selectedTeamFoundingDate, selectedTeamCityId.intValue());
        refresh();
    }

    /**
     * Retrieves the teams from the table
     */
    @PostConstruct
    public void init() {
        sportsDB = new SportsDB();
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
     *
     * @return the pairings
     */
    public List<Tournament> getPairings() {
        System.out.println(pairings);
        return pairings;
    }

    /**
     * Getter for the selected team name private field
     *
     * @return the selected team's name
     */
    public String getSelectedTeamName() {
        return selectedTeamName;
    }

    /**
     * Setter for the selected team name private field
     *
     * @param selectedTeamName the selected team's name
     */
    public void setSelectedTeamName(String selectedTeamName) {
        this.selectedTeamName = selectedTeamName;
    }

    /**
     * Getter for the selected team founding date private field
     *
     * @return the selected team's founding date
     */
    public String getSelectedTeamFoundingDate() {
        return selectedTeamFoundingDate;
    }

    /**
     * Setter for the selected team founding date private field
     *
     * @param selectedTeamFoundingDate the selected team's founding date
     */
    public void setSelectedTeamFoundingDate(String selectedTeamFoundingDate) {
        this.selectedTeamFoundingDate = selectedTeamFoundingDate;
    }

    /**
     * Getter for the selected team city id private field
     *
     * @return the selected team's city id
     */
    public Long getSelectedTeamCityId() {
        return selectedTeamCityId;
    }

    /**
     * Setter for the selected team city id private field
     *
     * @param selectedTeamCityId the selected team's city id
     */
    public void setSelectedTeamCityId(Long selectedTeamCityId) {
        this.selectedTeamCityId = selectedTeamCityId;
    }
}