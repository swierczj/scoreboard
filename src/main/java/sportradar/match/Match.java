package sportradar.match;

import java.util.Objects;

public class Match {

    private final Team homeTeam;
    private final Team awayTeam;
    private final Score score = new Score();

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = Objects.requireNonNull(homeTeam, "Home Team cannot be null!");
        this.awayTeam = Objects.requireNonNull(awayTeam, "Away Team cannot be null!");
    }

    public static Match of(String homeTeamName, String awayTeamName) {
        return new Match(new Team(homeTeamName), new Team(awayTeamName));
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(homeTeam, match.homeTeam) && Objects.equals(awayTeam, match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }
}
