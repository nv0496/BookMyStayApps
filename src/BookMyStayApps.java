// BookMyStayApp.java
import java.util.*;

public class BookMyStayApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Initialize hotel rooms using a Queue (FIFO for booking requests)
        Queue<String> availableRooms = new LinkedList<>();
        availableRooms.add("Room101");
        availableRooms.add("Room102");
        availableRooms.add("Room103");

        System.out.println("Welcome to BookMyStay Hotel Booking System!");
        System.out.println("Available rooms: " + availableRooms);

        // Step 2: Accept user booking requests
        System.out.print("Enter your name to book a room: ");
        String guestName = sc.nextLine();

        // Step 3: Book the first available room
        if (!availableRooms.isEmpty()) {
            String bookedRoom = availableRooms.poll(); // removes from queue
            System.out.println("Booking successful! " + guestName + " has booked " + bookedRoom);
        } else {
            System.out.println("Sorry, no rooms available at the moment.");
        }

        // Step 4: Show remaining rooms
        System.out.println("Remaining rooms: " + availableRooms);

        sc.close();
    }
}