package sportradar.board;

import sportradar.match.Match;
import sportradar.match.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// singleton?
public class Board {

    private List<Match> matches; // Set?
    private Set<Team> teamsPlaying = new HashSet<>();
}
