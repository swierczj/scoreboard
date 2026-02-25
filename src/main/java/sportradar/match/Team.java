package sportradar.match;

import java.util.Objects;

public class Team {

    private final String name;

    Team(String name) {
        Objects.requireNonNull(name, "Team name cannot be null!");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
