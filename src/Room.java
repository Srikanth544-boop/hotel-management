
public class Room {

    private int roomNumber;
    private String roomType;
    private double tariff;
    private boolean available;

    // Initialize room details
    public Room(int roomNumber, String roomType, double tariff) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.tariff = tariff;
        this.available = true;
    }

    // Return room details
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getTariff() {
        return tariff;
    }

    public boolean isAvailable() {
        return available;
    }

    // Change room availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display room information
    public void displayRoom() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Tariff: Rs." + tariff);
        System.out.println("Status: " + (available ? "Available" : "Occupied"));
    }
}
