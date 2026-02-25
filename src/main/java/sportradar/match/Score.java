package sportradar.match;

// or get score from match, and modify to have team the number of goals scored
public class Score {
    private int homeGoals = 0;
    private int awayGoals = 0;

    public int getGoalsNumber() {
        return homeGoals + awayGoals;
    }

    public void updateHomeGoals() {
        homeGoals++;
    }

    public void upadteAwayGoals() {
        awayGoals++;
    }
}
