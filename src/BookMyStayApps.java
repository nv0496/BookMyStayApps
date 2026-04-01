import java.util.*;

/**
 * Use Case 11: Sequential Booking Promotion (Smart Billing)
 * Applies a 10% discount if the user books more than 2 rooms.
 */
public class UseCase11SmartBilling {

    /**
     * Billing Service: Calculates total cost with bulk discount logic.
     */
    public static void calculateSmartBill(String guestName, List<Double> roomPrices) {
        System.out.println("Generating Smart Bill for: " + guestName);

        double subtotal = 0;
        for (double price : roomPrices) {
            subtotal += price;
        }

        int roomCount = roomPrices.size();
        double discount = 0;
        double finalTotal = subtotal;

        // Step 1: Check for promotion eligibility (More than 2 rooms)
        if (roomCount > 2) {
            discount = subtotal * 0.10; // 10% Discount
            finalTotal = subtotal - discount;
            System.out.println("PROMOTION APPLIED: 10% Bulk Booking Discount!");
        }

        // Step 2: Display breakdown
        System.out.println("Rooms Booked: " + roomCount);
        System.out.println("Subtotal: " + subtotal);
        if (discount > 0) {
            System.out.println("Discount Amount: -" + discount);
        }
        System.out.println("FINAL BILLING TOTAL: " + finalTotal);
        System.out.println("-------------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Smart Billing & Promotion System ===\n");

        // Case 1: Standard Booking (2 rooms - No Discount)
        List<Double> standardBooking = Arrays.asList(1500.0, 2500.0);
        calculateSmartBill("Nirmal", standardBooking);

        // Case 2: Bulk Booking (3 rooms - 10% Discount)
        List<Double> bulkBooking = Arrays.asList(1500.0, 2500.0, 5000.0);
        calculateSmartBill("Vivek", bulkBooking);
    }
}