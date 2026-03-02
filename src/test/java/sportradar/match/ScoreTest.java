package sportradar.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void initialScoreTest() {
        assertEquals(0, score.getTotalGoalsScored());
        assertEquals(0, score.getHomeGoals());
        assertEquals(0, score.getAwayGoals());
    }

    @Test
    void initializingWithNegativeScoreFailsTest() {
        assertThrows(IllegalArgumentException.class, () -> new Score(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Score(0, -1));
    }

    @Test
    void updateScoreTest() {
        score.updateScore(new Score(3, 1));

        assertEquals(4, score.getTotalGoalsScored());
        assertEquals(3, score.getHomeGoals());
        assertEquals(1, score.getAwayGoals());
    }

    @Test
    void updateScoreWithNullFailsTest() {
        assertThrows(NullPointerException.class, () -> score.updateScore(null));
    }

    @Test
    void scoreEqualsTest() {
        score.updateScore(new Score(3, 1));
        Score otherEqual = new Score(3, 1);
        Score reversed = new Score(1, 3);

        assertEquals(otherEqual, score);
        assertNotEquals(reversed, score);
        assertNotEquals(null, score);
    }

}