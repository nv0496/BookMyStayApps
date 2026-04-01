import java.util.*;

/**
 * Use Case 8: Booking History & Reporting
 * Maintains a persistent record of confirmed bookings for reporting purposes.
 */
public class UseCase8BookingHistory {

    // Internal storage for booking history
    private static List<String> historyLog = new ArrayList<>();

    /**
     * History Service: Records a new entry into the log.
     */
    public static void recordBooking(String guestName, String roomType, double totalBill) {
        String timestamp = new java.util.Date().toString();
        String record = String.format("[%s] Guest: %s | Room: %s | Total: %.2f",
                timestamp, guestName, roomType, totalBill);

        // Step 1: Add record to the sequential log
        historyLog.add(record);
        System.out.println("History Updated: Record added for " + guestName);
    }

    /**
     * Reporting Service: Generates a summary of all past bookings.
     */
    public static void generateReport() {
        System.out.println("\n========== BOOKING HISTORY REPORT ==========");
        if (historyLog.isEmpty()) {
            System.out.println("No booking records found.");
        } else {
            // Step 2: Iterate and display historical data
            for (String entry : historyLog) {
                System.out.println(entry);
            }
        }
        System.out.println("============================================\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Booking History & Reporting System ===\n");

        // Simulate successful bookings being recorded
        recordBooking("Nirmal", "Suite Room", 5000.0);
        recordBooking("Vivek", "Double Room", 2500.0);
        recordBooking("Alice", "Single Room", 1500.0);

        // Step 3: Admin requests a report
        generateReport();
    }
}