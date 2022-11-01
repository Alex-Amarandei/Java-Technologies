package fii.jt.lab3.model;

/**
 * Class modelling a match object (basically a pair)
 */
public class Match {
    private Long firstTeam;
    private Long secondTeam;

    /**
     * Constructor
     * @param firstTeam The first team's id
     * @param secondTeam The second team's id
     */
    public Match(Long firstTeam, Long secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    /**
     * Getter for the first team.
     * @return The first team's id
     */
    public Long getFirstTeam() {
        return firstTeam;
    }

    /**
     * Getter for the second team.
     * @return The second team's id
     */
    public Long getSecondTeam() {
        return secondTeam;
    }

    /**
     * Setter for the first team.
     * @param firstTeam The first team's id
     */
    public void setFirstTeam(Long firstTeam) {
        this.firstTeam = firstTeam;
    }

    /**
     * Setter for the second team.
     * @param secondTeam The second team's id
     */
    public void setSecondTeam(Long secondTeam) {
        this.secondTeam = secondTeam;
    }
}

