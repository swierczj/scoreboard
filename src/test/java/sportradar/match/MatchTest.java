package sportradar.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    // mocks?
//    private final Team homeTeam = new Team("Home");
//    private final Team awayTeam = new Team("Away");
    private Match match;

    @BeforeEach
    void setUp() {
        Team homeTeam = new Team("Home");
        Team awayTeam = new Team("Away");
        match = new Match(homeTeam, awayTeam);
    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void nullTeamsTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Match(null, null));
        assertTrue(exception.getMessage().contains("Team cannot be null!"));
    }

    @Test
    void startMatchTest() {
        match.startMatch();

        assertFalse(match.isFinished());
    }

    @Test
    void finishMatchTest() {
        assertFalse(match.isFinished());
    }

    @Test
    void getInitialScoreTest() {
        // or in score class tests?
    }
}