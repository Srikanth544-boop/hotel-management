
public class Guest {

    private int guestId;
    private String guestName;
    private String phoneNumber;

    // Initialize guest details
    public Guest(int guestId, String guestName, String phoneNumber) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
    }

    // Get guest details
    public int getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Display guest information
    public void displayGuest() {
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
