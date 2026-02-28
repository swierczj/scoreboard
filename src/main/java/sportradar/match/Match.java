package sportradar.match;

import java.util.Objects;

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private final Score score = new Score();
    private boolean isStarted = false; //use enum MatchStatus { NOT_STARTED, STARTED, FINISHED }?

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = Objects.requireNonNull(homeTeam, "Home Team cannot be null!");
        this.awayTeam = Objects.requireNonNull(awayTeam, "Away Team cannot be null!");
    }

    public void startMatch() {
        isStarted = true;
        // put to the board? should be here the board reference/id?
    }

    // how to recognize if it's finished or not started, start match in constructor? don't start it in the constructor, adding to board should start the match
    public void finishMatch() {
        isStarted = false;
    }

    // should be checked on board? static method of board?
    public boolean isFinished() {
        return !isStarted;
    }

    public Score getScore() {
        return score;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

}
