package sportradar.board;

import org.junit.jupiter.api.Test;
import sportradar.match.Match;
import sportradar.match.Team;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {

    @Test
    void addMatchesWithSameTeamFailsTest() {
        Board board = Board.getInstance();
        Match match1 = new Match(new Team("teamA"), new Team("teamB"));
        Match match2 = new Match(new Team("teamB"), new Team("teamA"));
        board.addMatch(match1);
        assertThrows(IllegalArgumentException.class, () -> board.addMatch(match2));

    }
}