import java.io.*;
import java.util.*;

/**
 * Use Case 12: Data Persistence & System Recovery
 * Ensures critical system state is saved to a durable medium.
 */
public class UseCase12DataPersistence {

    private static final String DATA_FILE = "hotel_data.txt";
    private static Map<String, Integer> roomInventory = new HashMap<>();

    static {
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 2);
    }

    /**
     * Persistence Service: Saves current inventory state to a file.
     */
    public static void saveState() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, Integer> entry : roomInventory.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println("SUCCESS: System state saved to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("ERROR: Could not save state: " + e.getMessage());
        }
    }

    /**
     * Recovery Service: Loads inventory state from the file on startup.
     */
    public static void loadState() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("No previous state found. Using default inventory.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(":");
                if (parts.length == 2) {
                    roomInventory.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
            System.out.println("SUCCESS: System state recovered from " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("ERROR: Recovery failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Data Persistence & Recovery System ===\n");

        // Step 1: Simulate system startup and recovery
        loadState();
        System.out.println("Current Inventory: " + roomInventory);

        // Step 2: Simulate changes
        System.out.println("\nModifying inventory (Booking a Suite)...");
        roomInventory.put("Suite Room", roomInventory.get("Suite Room") - 1);

        // Step 3: Explicitly save state before shutdown
        saveState();

        System.out.println("\nSystem shutting down. Run again to see recovered state.");
    }
}