package sportradar.match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void nullTeamsTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Match(null, null));
        assertTrue(exception.getMessage().contains("Team cannot be null!"));
    }

    @Test
    void matchOfTest() {
        Match matchOf = Match.of("Home", "Away");

        assertEquals("Home", matchOf.getHomeTeam().getName());
        assertEquals("Away", matchOf.getAwayTeam().getName());
        assertEquals(0, matchOf.getScore().getHomeGoals());
        assertEquals(0, matchOf.getScore().getAwayGoals());
    }

    @Test
    void nullMatchOfTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> Match.of(null, null));
        assertTrue(exception.getMessage().contains("Team name cannot be null!"));
    }

    @Test
    void matchEqualsTest() {
        assertEquals(Match.of("home", "away"), Match.of("Home", "Away"));
        assertNotEquals(Match.of("home", "away"), Match.of("away", "home"));
        assertNotEquals(null, Match.of("home", "away"));
    }

}