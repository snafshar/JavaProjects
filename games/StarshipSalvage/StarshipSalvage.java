import java.util.Random;
import java.util.Scanner;

/**
 * Starship Salvage: a compact, turn-based terminal game.
 * Compile with: javac StarshipSalvage.java
 * Run with:     java StarshipSalvage
 */
public class StarshipSalvage {
    private static final int MAX_HULL = 100;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private int hull = MAX_HULL;
    private int fuel = 8;
    private int salvage = 0;
    private int sector = 1;
    private boolean missionEnded = false;

    private enum Action { SCAN, SALVAGE, REPAIR, RETURN, INVALID }

    public static void main(String[] args) {
        new StarshipSalvage().play();
    }

    private void play() {
        printIntro();
        while (!missionEnded) {
            if (hull <= 0) {
                System.out.println("\nYour hull has failed. Mission lost.");
                missionEnded = true;
                break;
            }
            if (fuel <= 0) {
                System.out.println("\nNo fuel remains. You cannot return to base. Mission lost.");
                missionEnded = true;
                break;
            }
            showStatus();
            System.out.print("\nChoose [S]can, [L]oot salvage, [R]epair, [B]ase/return: ");
            Action action = parseAction(scanner.nextLine());
            switch (action) {
                case SCAN -> scan();
                case SALVAGE -> salvageSector();
                case REPAIR -> repair();
                case RETURN -> returnToBase();
                default -> System.out.println("Unknown action. Try S, L, R, or B.");
            }
        }
        scanner.close();
    }

    private void printIntro() {
        System.out.println("================================");
        System.out.println("       STARSHIP SALVAGE");
        System.out.println("================================");
        System.out.println("Recover cargo from a damaged sector and make it home.");
        System.out.println("Every action matters: watch hull integrity and fuel.");
    }

    private void showStatus() {
        System.out.printf("%nSector %d | Hull %d/%d | Fuel %d | Salvage %d%n",
                sector, hull, MAX_HULL, fuel, salvage);
    }

    private Action parseAction(String input) {
        if (input == null || input.isBlank()) return Action.INVALID;
        return switch (input.trim().toLowerCase()) {
            case "s", "scan" -> Action.SCAN;
            case "l", "loot", "salvage" -> Action.SALVAGE;
            case "r", "repair" -> Action.REPAIR;
            case "b", "base", "return" -> Action.RETURN;
            default -> Action.INVALID;
        };
    }

    private void scan() {
        fuel--;
        int risk = random.nextInt(100);
        String description = risk < 35 ? "Low debris" : risk < 70 ? "Unstable wreckage" : "Severe radiation";
        System.out.printf("Scan complete: %s (risk index %d/99). Fuel -1.%n", description, risk);
    }

    private void salvageSector() {
        fuel--;
        int risk = random.nextInt(100);
        if (risk < 72) {
            int found = 10 + random.nextInt(41);
            salvage += found;
            System.out.printf("Cargo recovered: %d salvage credits!%n", found);
        } else {
            int damage = 8 + random.nextInt(18);
            hull = Math.max(0, hull - damage);
            System.out.printf("A debris impact causes %d hull damage. No cargo recovered.%n", damage);
        }
        sector++;
    }

    private void repair() {
        if (fuel < 2) {
            System.out.println("Repair requires 2 fuel. Not enough fuel.");
            return;
        }
        if (hull == MAX_HULL) {
            System.out.println("Hull is already at maximum integrity.");
            return;
        }
        fuel -= 2;
        int before = hull;
        hull = Math.min(MAX_HULL, hull + 25);
        System.out.printf("Repairs complete: hull restored by %d. Fuel -2.%n", hull - before);
    }

    private void returnToBase() {
        missionEnded = true;
        if (hull > 0 && fuel >= 0) {
            System.out.printf("%nDocking successful! You banked %d salvage credits after exploring %d sector(s).%n",
                    salvage, sector);
            if (salvage >= 100) {
                System.out.println("Rank: Elite Salvager!");
            } else if (salvage >= 50) {
                System.out.println("Rank: Skilled Recycler.");
            } else {
                System.out.println("Rank: Rookie Pilot. Try another run!");
            }
        } else {
            System.out.println("The ship cannot make it back to base.");
        }
    }
}
