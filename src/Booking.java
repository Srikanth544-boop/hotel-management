
import java.time.LocalDate;

public class Booking {

    private int bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean checkedIn;

    // Initialize booking details
    public Booking(int bookingId, Guest guest, Room room,
                   LocalDate checkInDate, LocalDate checkOutDate) {

        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.checkedIn = false;
    }

    // Get booking details
    public int getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    // Update check-in status
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    // Display booking information
    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getGuestName());
        System.out.println("Room: " + room.getRoomNumber());
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Status: " +
                (checkedIn ? "Checked In" : "Booked"));
    }
}
