package sportradar.match;

import java.util.Objects;

public class Team {

    private final String name;

    public Team(String name) {
        Objects.requireNonNull(name, "Team name cannot be null!");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty!");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name.toLowerCase(), team.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name.toLowerCase());
    }
}
