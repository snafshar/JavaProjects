# Starship Salvage: Gameplay Notes

## Decisions

- **Scan** to spend fuel learning about a sector. The current simple version reports a random risk index.
- **Salvage** to earn credits, accepting the chance of hull damage.
- **Repair** when hull damage is becoming dangerous, provided you can spare two fuel.
- **Return** to bank the haul. You do not need to use every unit of fuel.

## Suggested challenges

1. Finish a mission with at least 100 salvage credits.
2. Change the starting fuel and compare the strategy.
3. Add a limited number of med-kits or repair parts.
4. Add a difficulty setting.
5. Split the game into Ship, Sector, and Game classes.
6. Add JUnit tests if you later introduce a build tool such as Maven or Gradle.

## Design note

This is deliberately a compact single-file Java game so it can be compiled with the JDK alone. A natural next step is to separate the model from terminal input/output and test the model independently.
