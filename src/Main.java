
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();
        Reports reports = new Reports();

        // Add sample hotel rooms
        hotel.addRoom(new Room(101, "Single", 1500));
        hotel.addRoom(new Room(102, "Double", 2500));
        hotel.addRoom(new Room(103, "Deluxe", 4000));
        hotel.addRoom(new Room(104, "Suite", 6000));

        int choice;

        do {
            System.out.println("\n===== HOTEL ROOM BOOKING SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Check In");
            System.out.println("4. Check Out");
            System.out.println("5. Occupancy Report");
            System.out.println("6. Booking Report");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.displayAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter Booking ID: ");
                    int bookingId = sc.nextInt();

                    System.out.print("Enter Guest ID: ");
                    int guestId = sc.nextInt();

                    System.out.print("Enter Guest Name: ");
sc.nextLine();
String name = sc.nextLine();

                   System.out.print("Enter Phone Number: ");
String phone = sc.next();

if (!phone.matches("[6-9][0-9]{9}")) {
    System.out.println("Invalid phone number! Enter a valid 10-digit mobile number.");
    break;
}
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    Room room = null;

                    for (Room r : hotel.getRooms()) {
                        if (r.getRoomNumber() == roomNo) {
                            room = r;
                            break;
                        }
                    }

                    if (room == null || !room.isAvailable()) {
                        System.out.println("Room unavailable!");
                        break;
                    }

                    System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
                    LocalDate inDate = LocalDate.parse(sc.next());

                    System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
                    LocalDate outDate = LocalDate.parse(sc.next());

                    Guest guest = new Guest(guestId, name, phone);

                    Booking booking = new Booking(
                            bookingId, guest, room, inDate, outDate
                    );

                    hotel.allocateRoom(booking);
                    break;

                case 3:
                    System.out.print("Enter Booking ID: ");
                    hotel.checkIn(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Booking ID: ");
                    hotel.checkOut(sc.nextInt());
                    break;

                case 5:
                    reports.occupancyReport(hotel);
                    break;

                case 6:
                    reports.bookingReport(hotel);
                    break;

                case 7:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
