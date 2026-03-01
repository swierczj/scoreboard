package sportradar.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // TODO: change it, score goal doesn't exist now
    @Test
    void homeSideScoresGoalTest() {
        score.scoreGoal(Side.HOME);

        assertEquals(1, score.getHomeGoals());
        assertEquals(0, score.getAwayGoals());
        assertEquals(1, score.getTotalGoalsScored());
    }

    // TODO: same as above
    @Test
    void awaySideScoresGoalTest() {
        score.scoreGoal(Side.AWAY);

        assertEquals(1, score.getAwayGoals());
        assertEquals(0, score.getHomeGoals());
        assertEquals(1, score.getTotalGoalsScored());
    }

}