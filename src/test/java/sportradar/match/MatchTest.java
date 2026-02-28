package sportradar.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    
    private Match match;

    @BeforeEach
    void setUp() {
        Team homeTeam = new Team("Home");
        Team awayTeam = new Team("Away");
        match = new Match(homeTeam, awayTeam);
    }

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
    void startAndFinishMatchTest() {
        match.startMatch();
        match.finishMatch();

        assertTrue(match.isFinished());
    }

    @Test
    void createdMatchIsNotStartedByDefaultTest() {
        assertTrue(match.isFinished());
    }

}