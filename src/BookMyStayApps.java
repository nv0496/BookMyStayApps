import java.util.*;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Restores inventory counts when a confirmed reservation is cancelled.
 */
public class UseCase10CancellationSystem {

    private static Map<String, Integer> roomInventory = new HashMap<>();
    private static Set<String> confirmedReservations = new HashSet<>();

    static {
        roomInventory.put("Single Room", 4); // Assume 1 is already booked
        confirmedReservations.add("RES-12345"); // A sample confirmed reservation
    }

    /**
     * Cancellation Service: Validates the request and performs rollback.
     */
    public static void cancelBooking(String reservationId, String roomType) {
        System.out.println("Processing cancellation for: " + reservationId);

        // Step 1: Validate the reservation exists
        if (confirmedReservations.contains(reservationId)) {

            // Step 2: Inventory Rollback - Increment availability
            int currentCount = roomInventory.getOrDefault(roomType, 0);
            roomInventory.put(roomType, currentCount + 1);

            // Step 3: Remove from confirmed list
            confirmedReservations.remove(reservationId);

            System.out.println("SUCCESS: Reservation " + reservationId + " cancelled.");
            System.out.println("Inventory Restored: " + roomType + " availability is now " + (currentCount + 1));
        } else {
            // Step 4: Handle invalid cancellation requests
            System.err.println("ERROR: Reservation ID " + reservationId + " not found or already cancelled.");
        }
        System.out.println("-------------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Booking Cancellation & Rollback System ===\n");

        // 1. Valid Cancellation
        cancelBooking("RES-12345", "Single Room");

        // 2. Invalid Cancellation (ID doesn't exist)
        cancelBooking("RES-99999", "Double Room");
    }
}