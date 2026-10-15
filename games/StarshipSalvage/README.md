# Starship Salvage

A small turn-based terminal game written in plain Java. Explore a damaged sector, collect salvage, manage hull integrity and fuel, and return to base before the ship is lost.

## Requirements

- Java 17 or later
- No external libraries

## Compile and run

From this directory:

    javac StarshipSalvage.java
    java StarshipSalvage

## Rules

- The ship begins with 100 hull, 8 fuel, and 0 salvage.
- Each turn you can scan, salvage, repair, or return to base.
- Scanning costs 1 fuel and reveals the current sector's risk.
- Salvaging costs 1 fuel; success depends on sector risk and may damage the hull.
- Repairing uses 2 fuel to restore up to 25 hull.
- Returning to base ends the mission and banks the salvage.
- If hull reaches zero or fuel runs out before returning, the mission fails.

The game uses random outcomes so each run differs. Input is validated so an accidental blank or invalid command does not crash the game.

## Learning goals

Practice classes, enums, loops, random numbers, methods, input validation, and simple state-machine design.
