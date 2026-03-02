package sportradar.board;

import sportradar.match.Match;
import sportradar.match.Score;
import sportradar.match.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Board {

    public static Board board;
    private final List<Match> matches = new ArrayList<>();

    private Board() {
    }

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public void addMatch(Match match) {
        if (isTeamCurrentlyPlaying(match.getHomeTeam()) || isTeamCurrentlyPlaying(match.getAwayTeam())) {
            throw new IllegalArgumentException("One of the teams is already playing!");
        }
        matches.add(match);
    }

    public boolean isTeamCurrentlyPlaying(Team team) {
        return matches.stream().anyMatch(m -> m.getHomeTeam().equals(team) || m.getAwayTeam().equals(team));
    }

    public void finishMatch(Match match) {
        if (!matches.remove(match)) {
            throw new IllegalArgumentException(String.format("Match between %s and %s not found, can't finish it",
                    match.getHomeTeam().getName(), match.getAwayTeam().getName()));
        }
    }

    public List<Match> getMatchesSummary() {
        List<Match> mostRecentMatches = new ArrayList<>(matches.reversed());
        return mostRecentMatches.stream().sorted(Comparator.comparingInt((Match m) -> m.getScore().getTotalGoalsScored()).reversed()).toList();
    }

    public void updateMatchScore(Match match, Score updatedScore) {
        int index = matches.indexOf(match);
        if (index == -1) {
            throw new IllegalArgumentException(String.format("Match between %s and %s not found, can't update the score",
                    match.getHomeTeam().getName(), match.getAwayTeam().getName()));
        }

        matches.get(index).getScore().updateScore(updatedScore);
    }

    public void resetBoard() {
        matches.clear();
    }

}
