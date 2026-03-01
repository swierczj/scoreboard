package sportradar.match;

import java.util.Objects;

public class Score {

    private int homeGoals;
    private int awayGoals;

    public Score() {
        this.homeGoals = 0;
        this.awayGoals = 0;
    }

    public Score(int homeGoals, int awayGoals) {
        if (homeGoals < 0 || awayGoals < 0) {
            throw new IllegalArgumentException("Score can't be negative!");
        }
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public int getTotalGoalsScored() {
        return homeGoals + awayGoals;
    }

    public void updateScore(Score newScore) {
        Objects.requireNonNull(newScore, "Score can't be null!");
        this.homeGoals = newScore.getHomeGoals();
        this.awayGoals = newScore.getAwayGoals();
    }

}
