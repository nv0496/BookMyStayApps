import java.util.*;

/**
 * Use Case 9: Error Handling & Validation
 * Implements defensive programming and custom error messaging.
 */
public class UseCase9ErrorHandling {

    private static Map<String, Integer> roomInventory = new HashMap<>();

    static {
        roomInventory.put("Single Room", 5);
    }

    /**
     * Validator Service: Checks for nulls, empty strings, and logic errors.
     */
    public static void validateAndBook(String guestName, String roomType) {
        System.out.println("Initiating booking for: " + (guestName == null ? "NULL" : guestName));

        try {
            // Step 1: Input Validation
            if (guestName == null || guestName.trim().isEmpty()) {
                throw new IllegalArgumentException("ERROR: Guest name cannot be empty.");
            }

            if (!roomInventory.containsKey(roomType)) {
                throw new NoSuchElementException("ERROR: Room type '" + roomType + "' does not exist.");
            }

            // Step 2: System State Validation
            int available = roomInventory.get(roomType);
            if (available <= 0) {
                throw new IllegalStateException("ERROR: No availability for " + roomType);
            }

            // Process booking if all validations pass
            roomInventory.put(roomType, available - 1);
            System.out.println("SUCCESS: Booking confirmed for " + guestName);

        } catch (IllegalArgumentException | NoSuchElementException | IllegalStateException e) {
            // Step 3: Precise Error Messaging
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // Generic fallback for unexpected failures
            System.err.println("CRITICAL ERROR: An unexpected system failure occurred.");
        } finally {
            System.out.println("Validation process complete.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Error Handling & Validation System ===\n");

        // 1. Test Valid Input
        validateAndBook("Nirmal", "Single Room");

        // 2. Test Empty Name
        validateAndBook("", "Single Room");

        // 3. Test Invalid Room Type
        validateAndBook("Vivek", "Penthouse");

        // 4. Test Out of Stock
        roomInventory.put("Single Room", 0);
        validateAndBook("John", "Single Room");
    }
}