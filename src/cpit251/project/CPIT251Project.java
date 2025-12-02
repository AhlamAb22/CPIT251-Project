/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251.project;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CPIT251Project {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClientManager clientManager = new ClientManager();
        BookingManager bookingManager = new BookingManager();

        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addNewClient(scanner, clientManager);
                case 2 -> bookService(scanner, bookingManager);
                case 3 -> viewAllBookings(bookingManager);
                case 4 -> deleteBooking(scanner, bookingManager);
                case 5 -> {
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
// ----------------------- MENU DISPLAY -----------------------
    private static void displayMenu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("|                   Salon Booking System                    |");
        System.out.println("-------------------------------------------------------------");
        System.out.println("1. Add a new client");
        System.out.println("2. Book a salon service");
        System.out.println("3. View all bookings");
        System.out.println("4. Delete a booking");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------------------------");
    }
    
// ----------------------- FILE WRITER -----------------------
    public static void writeToFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(content);
            writer.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }
    
 // ----------------------- ADD CLIENT -----------------------
    private static void addNewClient(Scanner scanner, ClientManager clientManager) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter client phone number: ");
        String phone = scanner.nextLine();

        Client client = new Client(name, phone);
        clientManager.addClient(client);

        String output = "Added Client:\nName: " + name + "\nPhone: " + phone;
        writeToFile("add_client.txt", output);

        System.out.println("Client added successfully!\n");
    }


    // ----------------------- BOOK SERVICE -----------------------
    private static void bookService(Scanner scanner, BookingManager bookingManager) {
        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter service type (e.g., haircut, manicure): ");
        String serviceType = scanner.nextLine();

        System.out.print("Enter appointment date (e.g., 2025-12-01 14:00): ");
        String appointmentDate = scanner.nextLine();

        System.out.print("Enter stylist name: ");
        String stylistName = scanner.nextLine();

        Booking booking = new Booking(clientName, serviceType, appointmentDate, stylistName);
        bookingManager.addBooking(booking);

        String output = "Booked Service:\nClient: " + clientName +
                "\nService: " + serviceType +
                "\nDate: " + appointmentDate +
                "\nStylist: " + stylistName;

        writeToFile("book_service.txt", output);

        System.out.println("Booking scheduled successfully!\n");
    }

    // ----------------------- VIEW BOOKINGS -----------------------
    private static void viewAllBookings(BookingManager bookingManager) {
        StringBuilder output = new StringBuilder("All Bookings:\n");

        for (Booking b : bookingManager.getBookings()) {
            output.append(b).append("\n");
        }

        writeToFile("view_bookings.txt", output.toString());

        bookingManager.viewAllBookings();
    }

    // ----------------------- DELETE BOOKING -----------------------
    private static void deleteBooking(Scanner scanner, BookingManager bookingManager) {
        System.out.print("Enter the name of the client whose booking you want to delete: ");
        String clientName = scanner.nextLine();

        boolean removed = bookingManager.deleteBooking(clientName);

        String output;

        if (removed) {
            output = "Deleted Booking for Client: " + clientName;
            System.out.println("Booking deleted successfully!\n");
        } else {
            output = "No booking found for client: " + clientName;
            System.out.println("No booking found for this client.\n");
        }

        writeToFile("delete_booking.txt", output);
    }
}

    

