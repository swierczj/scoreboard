package sportradar.match;

import java.util.Objects;

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private final Score score = new Score();
    private boolean isStarted = false;

    Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = Objects.requireNonNull(homeTeam, "Home Team cannot be null!");
        this.awayTeam = Objects.requireNonNull(awayTeam, "Away Team cannot be null!");
    }

    public void startMatch() {
        isStarted = true;
    }

    // how to recognize if it's finished or not started, start match in constructor?
    public void finishMatch() {
        isStarted = false;
    }

    public boolean isFinished() {
        return !isStarted;
    }

    public Score getScore() {
        return score;
    }
}
