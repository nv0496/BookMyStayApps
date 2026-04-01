import java.util.*;

/**
 * Use Case 7: Add-On Service Selection
 * Manages optional services and calculates total reservation costs.
 */
public class UseCase7AddOnServices {

    // Map of available add-on services and their fixed prices
    private static Map<String, Double> addOnMenu = new HashMap<>();

    static {
        addOnMenu.put("Breakfast Buffet", 500.0);
        addOnMenu.put("Airport Pickup", 1200.0);
        addOnMenu.put("Extra Bed", 800.0);
        addOnMenu.put("WiFi Premium", 200.0);
    }

    /**
     * Service Selector: Handles user selection and cost calculation.
     */
    public static void processBookingWithAddOns(String guestName, String roomType, double basePrice, List<String> selectedAddOns) {
        System.out.println("Booking Summary for: " + guestName);
        System.out.println("Room Type: " + roomType + " | Base Price: " + basePrice);

        double totalAddOnCost = 0.0;
        System.out.println("Selected Add-Ons:");

        // Step 1: Validate and add each selected service
        for (String service : selectedAddOns) {
            if (addOnMenu.containsKey(service)) {
                double cost = addOnMenu.get(service);
                totalAddOnCost += cost;
                System.out.println("- " + service + ": " + cost);
            } else {
                System.out.println("- WARNING: " + service + " is not an available service.");
            }
        }

        // Step 2: Calculate and display final total
        double finalTotal = basePrice + totalAddOnCost;
        System.out.println("Total Add-On Cost: " + totalAddOnCost);
        System.out.println("FINAL TOTAL BILL: " + finalTotal);
        System.out.println("-------------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Add-On Service Selection System ===\n");

        // Simulate user selecting services
        List<String> nirmalAddOns = Arrays.asList("Breakfast Buffet", "WiFi Premium");
        processBookingWithAddOns("Nirmal", "Suite Room", 5000.0, nirmalAddOns);

        List<String> vivekAddOns = Arrays.asList("Airport Pickup", "Extra Bed", "Spa Treatment"); // Spa is invalid
        processBookingWithAddOns("Vivek", "Double Room", 2500.0, vivekAddOns);
    }
}