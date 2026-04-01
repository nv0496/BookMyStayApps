import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 5: Inventory Update & Booking (Read-Write)
 * Implements the logic for updating availability after a successful booking.
 */
public class UseCase5BookingSystem {

    // Centralized inventory
    private static Map<String, Integer> roomInventory = new HashMap<>();

    static {
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 2);
    }

    /**
     * Booking Service: Handles both reading availability and writing updates.
     * Uses Atomic Update logic to prevent overbooking.
     */
    public static void processBooking(String guestName, String roomType) {
        System.out.println("Processing booking for " + guestName + " (" + roomType + ")...");

        // Step 1: Read current availability
        int currentAvailability = roomInventory.getOrDefault(roomType, 0);

        if (currentAvailability > 0) {
            // Step 2: Write update to inventory
            roomInventory.put(roomType, currentAvailability - 1);

            System.out.println("SUCCESS: Booking confirmed for " + guestName);
            System.out.println("Updated " + roomType + " availability: " + (currentAvailability - 1));
        } else {
            System.out.println("FAILURE: " + roomType + " is sold out.");
        }
        System.out.println("-----------------------------------\n");
    }

    public static void displayStatus() {
        System.out.println("=== Current Inventory Status ===");
        roomInventory.forEach((type, count) -> System.out.println(type + ": " + count));
        System.out.println("================================\n");
    }

    public static void main(String[] args) {
        displayStatus();

        // Simulate a series of bookings
        processBooking("Nirmal", "Suite Room");
        processBooking("Vivek", "Suite Room");

        // This third attempt should fail as Suite Rooms were only 2
        processBooking("John", "Suite Room");

        displayStatus();
    }
}