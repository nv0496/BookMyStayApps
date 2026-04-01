import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 4: Room Search & Availability Check
 * Implements defensive programming to ensure only available rooms are displayed.
 */
public class UseCase4SearchAvailability {

    // Centralized inventory storage
    private static Map<String, Integer> roomInventory = new HashMap<>();

    // Room details storage (Price and Size)
    private static Map<String, String> roomDetails = new HashMap<>();

    static {
        // Initialize Inventory
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 0); // Setting to 0 to test search filtering
        roomInventory.put("Suite Room", 2);

        // Initialize Room Details
        roomDetails.put("Single Room", "1 Bed, 250 sqft, Price: 1500.0");
        roomDetails.put("Double Room", "2 Beds, 400 sqft, Price: 2500.0");
        roomDetails.put("Suite Room", "3 Beds, 750 sqft, Price: 5000.0");
    }

    /**
     * Search Service: Handles read-only access to inventory.
     * Filters out rooms with availability <= 0.
     */
    public static void performSearch() {
        System.out.println("=== Searching for Available Rooms ===\n");
        boolean found = false;

        for (String roomType : roomInventory.keySet()) {
            int availableCount = roomInventory.get(roomType);

            // Display only room types with availability greater than zero
            if (availableCount > 0) {
                System.out.println("Room Type: " + roomType);
                System.out.println("Details: " + roomDetails.get(roomType));
                System.out.println("Available Units: " + availableCount);
                System.out.println("-----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms are currently available.");
        }
    }

    public static void main(String[] args) {
        // Step 1: User initiates a search request
        performSearch();

        System.out.println("\n=== End of Use Case 4 Search ===");
    }
}