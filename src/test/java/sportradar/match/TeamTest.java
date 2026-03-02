package sportradar.match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void constructorThrowsWhenNullTeamNameTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Team(null));
        assertEquals("Team name cannot be null!", exception.getMessage());
    }

    @Test
    void constructorThrowsWhenEmptyTeamNameTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Team(""));
        assertEquals("Team name cannot be empty!", exception.getMessage());
    }

    @Test
    void getNameTest() {
        Team team = new Team("teamA");

        assertNotEquals("teamB", team.getName());
        assertNotEquals("TeamA", team.getName());
        assertEquals("teamA", team.getName());
    }

    @Test
    void isTeamNameTrimmedTest() {
        Team team = new Team(" teamA ");

        assertNotEquals(" teamA ", team.getName());
        assertEquals("teamA", team.getName());
    }

    @Test
    void hashCodeRemainsTheSameTest() {
        Team team = new Team("teamA");
        int hashCode1 = team.hashCode();
        int hashCode2 = team.hashCode();

        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void sameTeamEqualsTest() {
        Team team = new Team("teamA");

        assertEquals(team, team);
    }

    @Test
    void ignoreCaseTeamsEqualsTest() {
        Team team = new Team("teamA");
        Team sameTeam = new Team("TeamA");

        assertEquals(team, sameTeam);
    }

    @Test
    void notEqualsTeamTest() {
        Team team = new Team("teamA");
        Team differentTeam = new Team("teamB");

        assertNotEquals(differentTeam, team);
        assertNotEquals(null, team);
        assertNotEquals("teamA", team);
    }

}