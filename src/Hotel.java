
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hotel {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    // Add a room to the hotel
    public void addRoom(Room room) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == room.getRoomNumber()) {
                System.out.println("Room already exists!");
                return;
            }
        }

        rooms.add(room);
        System.out.println("Room added successfully!");
    }

    // Display available rooms
    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            if (room.isAvailable()) {
                room.displayRoom();
            }
        }
    }

    // Allocate a room to a guest
    public void allocateRoom(Booking booking) {
        // Check for duplicate booking ID
for (Booking b : bookings) {
    if (b.getBookingId() == booking.getBookingId()) {
        System.out.println("Booking ID already exists!");
        return;
    }
}

        Room room = booking.getRoom();

        if (!room.isAvailable() || !rooms.contains(room)) {
            System.out.println("Room is not available!");
            return;
        }

        if (!booking.getCheckOutDate().isAfter(booking.getCheckInDate())) {
            System.out.println("Invalid booking dates!");
            return;
        }

        room.setAvailable(false);
        bookings.add(booking);

        System.out.println("Room allocated successfully!");
    }

    // Check in a guest
    public void checkIn(int bookingId) {

        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                if (b.isCheckedIn()) {
                    System.out.println("Guest already checked in!");
                    return;
                }

                if (!b.getCheckInDate().equals(LocalDate.now())) {
                    System.out.println("Check-in date does not match today!");
                    return;
                }

                b.setCheckedIn(true);
                System.out.println("Guest checked in successfully!");
                return;
            }
        }

        System.out.println("Booking not found!");
    }

    // Check out a guest and calculate tariff
    public void checkOut(int bookingId) {

        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {

                if (!b.isCheckedIn()) {
                    System.out.println("Guest has not checked in!");
                    return;
                }

                long days = ChronoUnit.DAYS.between(
                    b.getCheckInDate(), b.getCheckOutDate()
                );

                // Minimum one day's tariff
                double bill = Math.max(1, days) * b.getRoom().getTariff();

                System.out.println("Guest: " + b.getGuest().getGuestName());
                System.out.println("Total Stay: " + days + " days");
                System.out.println("Total Bill: Rs." + bill);

                b.getRoom().setAvailable(true);
                bookings.remove(b);

                System.out.println("Check-out completed!");
                return;
            }
        }

        System.out.println("Booking not found!");
    }

    // Return booking list for reports
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    // Return room list for reports
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
