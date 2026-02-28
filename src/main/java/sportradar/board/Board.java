package sportradar.board;

import sportradar.match.Match;
import sportradar.match.Team;

import java.util.LinkedList;
import java.util.List;

// singleton? for experimental needs so far, should be changed in future to not singleton
public class Board {

    public static Board board;
    private final List<Match> matches = new LinkedList<>();

    private Board() {
    }

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public void addMatch(Match match) {
        if (isTeamPlaying(match.getHomeTeam()) || isTeamPlaying(match.getAwayTeam())) {
            throw new IllegalArgumentException("One of the teams is already playing!");
        }
        match.startMatch();
        matches.add(match);
    }

    private boolean isTeamPlaying(Team team) {
        return matches.stream().anyMatch(m -> m.getHomeTeam().equals(team) || m.getAwayTeam().equals(team));
    }

    public void removeMatch(Match match) {
        match.finishMatch();
        matches.remove(match);
    }

}
