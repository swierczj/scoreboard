# Football World Cup Live Score Board

An object-oriented Java implementation for managing and displaying live football match scores.

## Assumptions
* **Single Match Constraint:** A team can participate in only one match at most at a time. This means that the team can be visible only in one place in the board.
* **Concurrency:** For convenience and simplicity the system is provided for single-threaded use. In a multi-threaded environment, `Board` would require explicit synchronization or thread-safe collections.
* **Tracking only live matches:** I assumed the board should show matches that are under play at the given moment, so there's no need for more than one board. Can be changed in the future depending on needs, probably new class that handles multiple boards would be needed then too.
* **Ignoring the case of teams names:** Linked with first constraint - teams which names are differently cased are the same teams e.g. Poland is the same as POLAND.

## Design Decisions
* **Singleton Pattern:** To handle the live matches assumption - `Board` is implemented as singleton.
* **Data Integrity:** `Score`, `Match` and `Team` objects are self-validating (e.g. negative scores are rejected at the constructor level), ensuring the board never holds an inconsistent state.
* **Defensive Copying:** The `getSummary()` method returns an unmodifiable view of the matches list. This prevents external code from accidentally modifying or clearing the internal list of active matches, protecting the board's state integrity.

* **Sorting Logic:** The summary list is sorted by total score (descending) and then by the insertion order (most recently added matches first) using a custom `Comparator`.
* **Testing:** The project is fully covered by **JUnit 5** unit tests, covering edge cases for sorting, input validation, and Singleton instance integrity.
* `equals()` and `hashCode()` are implemented based on teams names in given `Match` to ensure correct object identification.

## Usage Example
```java
// Get the board instance
Board board = Board.getInstance();

// Add a match to board and start it
board.addMatch(Match.of("Mexico", "Canada"));

// Update score
board.updateScore(Match.of("Mexico", "Canada"), new Score(0, 5));

// Get the sorted summary
List<Match> summary = board.getSummary();

// Finish the match
board.finishMatch(Match.of("Mexico", "Canada"));