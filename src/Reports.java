
public class Reports {

    // Generate hotel occupancy report
    public void occupancyReport(Hotel hotel) {

        int totalRooms = hotel.getRooms().size();
        int occupiedRooms = 0;
        int availableRooms = 0;

        // Count occupied and available rooms
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable()) {
                availableRooms++;
            } else {
                occupiedRooms++;
            }
        }

        // Calculate occupancy percentage
        double occupancyRate = totalRooms == 0 ? 0 :
                (occupiedRooms * 100.0) / totalRooms;

        System.out.println("\n===== OCCUPANCY REPORT =====");
        System.out.println("Total Rooms: " + totalRooms);
        System.out.println("Occupied Rooms: " + occupiedRooms);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println("Occupancy Rate: " + occupancyRate + "%");
        System.out.println("============================");
    }

    // Display all current bookings
    public void bookingReport(Hotel hotel) {

        System.out.println("\n===== BOOKING REPORT =====");

        if (hotel.getBookings().isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking booking : hotel.getBookings()) {
            booking.displayBooking();
            System.out.println("----------------------");
        }
    }
}
