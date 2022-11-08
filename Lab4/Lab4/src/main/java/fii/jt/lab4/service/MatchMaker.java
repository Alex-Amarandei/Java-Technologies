package fii.jt.lab4.service;

import fii.jt.lab4.model.Match;
import fii.jt.lab4.model.Team;
import fii.jt.lab4.model.Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The service responsible with matchmaking
 */
public class MatchMaker {
    private final List<Tournament> pairings;
    private boolean exit = false;

    /**
     * Constructor
     * @param teams The list of teams
     */
    public MatchMaker(List<Team> teams) {
        List<Match> c = new ArrayList<>();
        for (int i = 0; i < teams.size() - 1; i++)
            for (int j = i + 1; j < teams.size(); j++) {
                c.add(new Match((long) i, (long) j));
            }
        Match[][] tournament = new Match[teams.size() - 1][teams.size() / 2];
        getTournament(teams.size() - 1, tournament, 0, teams.size() / 2, c);
        pairings = new ArrayList<>();
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = 0; j < teams.size() / 2; j++) {
                pairings.add(new Tournament(i + 1, teams.get(tournament[i][j].getFirstTeam().intValue()).getName(), teams.get(tournament[i][j].getSecondTeam().intValue()).getName()));
            }
        }
    }

    /**
     * Getter for pairings
     * @return the pairings
     */
    public List<Tournament> getPairings() {
        return pairings;
    }

    /**
     * Generates the tournament
     * @param days available days
     * @param tournament the match matrix
     * @param game the game
     * @param gamesPerDay how many games per day
     * @param l a list of matches
     */
    public void getTournament(int days, Match[][] tournament, int game, int gamesPerDay, List<Match> l) {
        if (game == gamesPerDay) {
            game = 0;
            days = days - 1;
        }
        if (days == 0) {
            this.exit = true;
        } else {
            int found;
            List<Match> trial = new ArrayList<>(l);
            for (Match match : l) {
                found = 0;
                for (int i = 0; i < game; i++)
                    if (tournament[days - 1][i] != null)
                        if (Objects.equals(match.getFirstTeam(), tournament[days - 1][i].getFirstTeam()) || Objects.equals(match.getSecondTeam(), tournament[days - 1][i].getSecondTeam()) ||
                                Objects.equals(match.getSecondTeam(), tournament[days - 1][i].getFirstTeam()) || Objects.equals(match.getFirstTeam(), tournament[days - 1][i].getSecondTeam())) {
                            found = 1;
                            break;
                        }
                if (found == 0) {
                    tournament[days - 1][game] = match;
                    trial.remove(match);
                    getTournament(days, tournament, game + 1, gamesPerDay, trial);
                    if (this.exit)
                        return;
                    trial.add(match);
                    tournament[days - 1][game] = null;
                }
            }
        }
    }
}
