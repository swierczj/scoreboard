package sportradar.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sportradar.match.Match;
import sportradar.match.Score;
import sportradar.match.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = Board.getInstance();
    }

    @AfterEach
    void tearDown() {
        board.resetBoard();
    }

    @Test
    void sameBoardInstanceTest() {
        Board otherBoard = Board.getInstance();

        assertSame(board, otherBoard, "Should be the same instance");
    }

    @Test
    void initializedBoardIsEmptyTest() {
        assertTrue(board.getMatchesSummary().isEmpty());
    }

    @Test
    void addMatchTest() {
        board.addMatch(Match.of("teamA", "teamB"));
        List<Match> summary = board.getMatchesSummary();

        assertEquals(1, summary.size());
        assertEquals("teamA", summary.getFirst().getHomeTeam().getName());
        assertEquals("teamB", summary.getFirst().getAwayTeam().getName());
        assertEquals(new Score(0, 0), summary.getFirst().getScore());
    }

    @Test
    void addMatchesWithSameTeamFailsTest() {
        Match match1 = Match.of("teamA", "teamB");
        Match match2 = Match.of("teamB", "teamA");
        board.addMatch(match1);

        assertThrows(IllegalArgumentException.class, () -> board.addMatch(match2));
    }

    @Test
    void notPlayingTeamNotFoundTest() {
        board.addMatch(Match.of("teamA", "teamB"));

        assertFalse(board.isTeamCurrentlyPlaying(new Team("teamC")));
    }

    @Test
    void finishMatchTest() {
        board.addMatch(Match.of("teamA", "teamB"));
        List<Match> summaryCopy = board.getMatchesSummary();
        board.finishMatch(Match.of("teamA", "teamB"));
        List<Match> latestSummary = board.getMatchesSummary();

        assertEquals(1, summaryCopy.size());
        assertEquals(0, latestSummary.size());
    }

    @Test
    void finishNonExistentMatchFailsTest() {
        board.addMatch(Match.of("teamA", "teamB"));

        assertThrows(IllegalArgumentException.class, () -> board.finishMatch(Match.of("teamB", "teamA")));
    }

    @Test
    void updateMatchScoreTest() {
        Score updatedScore = new Score(3, 1);
        board.addMatch(Match.of("teamA", "teamB"));

        board.updateMatchScore(Match.of("teamA", "teamB"), updatedScore);

        assertEquals(updatedScore, board.getMatchesSummary().getFirst().getScore());
    }

    @Test
    void updateNonExistentMatchScoreFailsTest() {
        board.addMatch(Match.of("teamA", "teamB"));

        assertThrows(IllegalArgumentException.class, () -> board.updateMatchScore(Match.of("teamB", "teamA"), new Score(3, 1)));
    }

    @Test
    void matchesSummaryOrderTest() {
        board.addMatch(Match.of("teamA", "teamB"));
        board.addMatch(Match.of("teamC", "teamD"));
        board.addMatch(Match.of("teamE", "teamF"));
        board.addMatch(Match.of("teamG", "teamH"));
        board.updateMatchScore(Match.of("teamA", "teamB"), new Score(5, 2));
        board.updateMatchScore(Match.of("teamC", "teamD"), new Score(1, 1));
        board.updateMatchScore(Match.of("teamE", "teamF"), new Score(1, 1));

        List<Match> matchesSummary = board.getMatchesSummary();

        assertIterableEquals(List.of(Match.of("teamA", "teamB"),
                Match.of("teamE", "teamF"), Match.of("teamC", "teamD"),
                Match.of("teamG", "teamH")), matchesSummary);
    }

    @Test
    void matchesSummaryLatestOrderTest() {
        board.addMatch(Match.of("teamA", "teamB"));
        board.addMatch(Match.of("teamC", "teamD"));

        List<Match> matchesSummary = board.getMatchesSummary();

        assertIterableEquals(List.of(Match.of("teamC", "teamD"),
                Match.of("teamA", "teamB")), matchesSummary);
    }

    @Test
    void resetBoardTest() {
        board.addMatch(Match.of("teamA", "teamB"));

        board.resetBoard();

        assertTrue(board.getMatchesSummary().isEmpty());
    }

    @Test
    void clearingSummaryDoesntClearBoardTest() {
        board.addMatch(Match.of("teamA", "teamB"));

        List<Match> summary = board.getMatchesSummary();

        assertThrows(UnsupportedOperationException.class, summary::clear);
        assertFalse(board.getMatchesSummary().isEmpty());
    }

}