import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings scheduled.\n");
            return;
        }

        System.out.println("----- Bookings -----");
        for (Booking b : bookings) {
            System.out.println(b);
        }
        System.out.println();
    }

    public boolean deleteBooking(String clientName) {
        return bookings.removeIf(b -> b.getClientName().equalsIgnoreCase(clientName));
    }
}
