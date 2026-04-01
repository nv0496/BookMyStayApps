import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 3: Centralized Room Inventory Management
 * Manages room availability using a centralized Map.
 */
public class UseCase3InventoryManagement {

    // Centralized inventory to track room availability
    private static Map<String, Integer> roomInventory = new HashMap<>();

    static {
        // Initializing inventory
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 2);
    }

    /**
     * Checks if a specific room type is available
     */
    public static boolean checkAvailability(String roomType) {
        return roomInventory.getOrDefault(roomType, 0) > 0;
    }

    /**
     * Reduces the count of a room type upon booking
     */
    public static void bookRoom(String roomType) {
        if (checkAvailability(roomType)) {
            roomInventory.put(roomType, roomInventory.get(roomType) - 1);
            System.out.println("Booking successful for: " + roomType);
        } else {
            System.out.println("Sorry, " + roomType + " is currently unavailable.");
        }
    }

    public static void displayInventory() {
        System.out.println("--- Current Room Inventory ---");
        roomInventory.forEach((type, count) ->
                System.out.println(type + ": " + count + " available"));
        System.out.println("------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Hotel Inventory Management System ===\n");

        displayInventory();

        // Simulate booking
        System.out.println("Attempting to book a Suite Room...");
        bookRoom("Suite Room");

        displayInventory();

        System.out.println("Attempting to book another Suite Room...");
        bookRoom("Suite Room");

        System.out.println("Attempting to book a third Suite Room...");
        bookRoom("Suite Room");

        displayInventory();
    }
}