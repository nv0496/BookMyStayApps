/**
 * Use Case 2: Basic Room Types & Static Availability
 * Single file version containing Room, SingleRoom, DoubleRoom, SuiteRoom, and Main
 * @version 2.1
 */
public class UseCase2RoomInitialization {

    // =======================
    // Abstract Room class
    // =======================
    public static abstract class Room {
        protected int numberOfBeds;
        protected int squareFeet;
        protected double pricePerNight;

        public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
            this.numberOfBeds = numberOfBeds;
            this.squareFeet = squareFeet;
            this.pricePerNight = pricePerNight;
        }

        public void displayRoomDetails() {
            System.out.println("Beds: " + numberOfBeds);
            System.out.println("Size: " + squareFeet + " sqft");
            System.out.println("Price per night: " + pricePerNight);
        }
    }

    // =======================
    // SingleRoom class
    // =======================
    public static class SingleRoom extends Room {
        public SingleRoom() {
            super(1, 250, 1500.0);
        }
    }

    // =======================
    // DoubleRoom class
    // =======================
    public static class DoubleRoom extends Room {
        public DoubleRoom() {
            super(2, 400, 2500.0);
        }
    }

    // =======================
    // SuiteRoom class
    // =======================
    public static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 750, 5000.0);
        }
    }

    // =======================
    // Static availability
    // =======================
    static int singleRoomAvailable = 5;
    static int doubleRoomAvailable = 3;
    static int suiteRoomAvailable = 2;

    // =======================
    // Main method
    // =======================
    public static void main(String[] args) {
        System.out.println("=== Hotel Room Initialization ===\n");

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable + "\n");

        System.out.println("Double Room:");
        dbl.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable + "\n");

        System.out.println("=== End of Use Case 2 ===");
    }
}