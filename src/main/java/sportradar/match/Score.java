package sportradar.match;

// or get score from match, and modify to have team the number of goals scored
public class Score {

    private int homeGoals = 0;
    private int awayGoals = 0;

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public int getTotalGoalsScored() {
        return homeGoals + awayGoals;
    }

    public void scoreGoal(Side side) {
        switch (side) {
            case HOME:
                homeGoals++;
                break;
            case AWAY:
                awayGoals++;
                break;
        }
    }

}
