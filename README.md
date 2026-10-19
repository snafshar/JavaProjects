# Java Projects

Java 17 exercises covering algorithms, collections, streams, immutable data models, and networking.

## Projects

- `src/NetworkRoutingSimulator.java` — weighted graph routing with Dijkstra
- `src/NetworkHealth.java` — validates latency/loss measurements and classifies network health
- `projects/Measurements.java` — stream-based device statistics
- `projects/StudyPlanner.java` — immutable study-task filtering and prioritisation
- [NumberQuest](https://github.com/snafshar/JavaProjects/tree/main/games/NumberQuest) — terminal number guessing game
- [Starship Salvage](https://github.com/snafshar/JavaProjects/tree/main/games/StarshipSalvage) — console game exercise
- [TaskTrail](https://github.com/snafshar/JavaProjects/tree/main/exercises/2026-10-19/TaskTrail) — file-backed task tracker with a service layer and dependency-free tests

## Compile

```bash
javac src/NetworkRoutingSimulator.java
javac src/NetworkHealth.java
java -cp src NetworkHealth
cd exercises/2026-10-19/TaskTrail
./run-tests.sh
```

Individual projects under `projects/` can be compiled and run with Java 17. TaskTrail uses Java 17 and stores its data in a local TSV file.
