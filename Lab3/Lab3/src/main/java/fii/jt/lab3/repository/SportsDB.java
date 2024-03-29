package fii.jt.lab3.repository;

import fii.jt.lab3.model.City;
import fii.jt.lab3.model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class providing the connection between the app and the Postgresql database.
 */
public class SportsDB {
    private Connection connection;

    /**
     * Constructor which initiates the connection
     */
    public SportsDB() {
        getConnection();
    }

    /**
     * Creates the connection between the app and the Postgresql database
     */
    private void getConnection() {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java-technologies", "postgres", "1234");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Function used for creating and storing a new team in the database
     * @param teamName The team's name
     * @param foundingDate The date the team was founded
     * @param cityId The id of the city the team belongs to
     * @throws SQLException In case there are problems regarding the database operations
     */
    public void storeTeam(String teamName, String foundingDate, int cityId) throws SQLException {

        String insertTeam = "insert into teams (name, date, city_id) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertTeam);

        preparedStatement.setString(1, teamName);
        preparedStatement.setString(2, foundingDate);
        preparedStatement.setInt(3, cityId);

        preparedStatement.executeUpdate();
    }

    /**
     * Method used for retrieving all the available cities
     * @return A list of all the available cities
     * @throws SQLException In case there are problems regarding the database operations
     */
    public List<City> retrieveCities() throws SQLException {
        String retrieveTeam = "SELECT * from cities";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(retrieveTeam);
        List<City> cities = new ArrayList<>();

        while (resultSet.next()) {

            City city = new City(resultSet.getLong("id"), resultSet.getString("name"));
            cities.add(city);
        }
        statement.close();
        return cities;
    }

    /**
     * Method used for retrieving all the available teams
     * @return A list of all the available teams
     * @throws SQLException In case there are problems regarding the database operations
     */
    public List<Team> retrieveTeams() throws SQLException {

        String retrieveTeam = "SELECT * from teams";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(retrieveTeam);

        List<Team> teams = new ArrayList<>();

        while (resultSet.next()) {

            Team team = new Team(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("date"), resultSet.getLong("city_id"));
            teams.add(team);

        }
        statement.close();
        return teams;
    }
}

