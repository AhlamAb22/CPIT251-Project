/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cpit251.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CPIT251ProjectTest {
    public static CPIT251Project instance;
    public static ClientManager clientManager;
    public static BookingManager bookingManager;
    public CPIT251ProjectTest() {
    }
    
    @BeforeAll
    public static void setUp() {
        instance = new CPIT251Project();
        clientManager = new ClientManager();
        bookingManager = new BookingManager();
    }
    
    // Test of First Function (Add Client)   
    @Test
    public void testAddClient() {
        // Testing data
        String name = "Tala";
        String phone = "0567586407";
        
        // calling the method
        Client client = new Client(name, phone);
        clientManager.addClient(client);
        Client result = clientManager.getClients().get(0);
        
        // Checking if the client object is added to the array list
        assertNotNull(result);
    }
    
    // Test of Second Function (book Service)   
    @Test
    public void testBookService() {
        // Testing data
        String clientName = "Tala";
        String serviceType = "haircut";
        String appointmentDate = "2025-12-01 14:00";
        String stylistName = "Almas";
        
        // calling the method
        Booking booking = new Booking(clientName, serviceType, appointmentDate, stylistName);
        bookingManager.addBooking(booking);
        Booking result = bookingManager.getBookings().get(0);
        
        // Checking if the booking object is added to the array list
        assertNotNull(result);
    }
    
    // Test of Third Function (view All Bookings)   
    @Test
    public void testViewAllBookings() {
        // Testing data
        String clientName1 = "Tala";
        String serviceType1 = "haircut";
        String appointmentDate1 = "2025-12-01 14:00";
        String stylistName1 = "Almas";

        String clientName2 = "Asala";
        String serviceType2 = "manicure";
        String appointmentDate2 = "2025-12-01 17:00";
        String stylistName2 = "Dana";
        
        // calling the method
        Booking booking1 = new Booking(clientName1, serviceType1, appointmentDate1, stylistName1);
        bookingManager.addBooking(booking1);

        Booking booking2 = new Booking(clientName2, serviceType2, appointmentDate2, stylistName2);
        bookingManager.addBooking(booking2);
        bookingManager.viewAllBookings();
        
        // Checking if the bookings are written in the file
        assertEquals(2, bookingManager.getBookings().size());
    }

    // Test of Fourth Function (delete Booking)   
    @Test
    public void testDeleteBooking() {
        // Testing data
        String clientName1 = "Tala";
        String clientName2 = "Asala";
        
        // calling the method
        bookingManager.deleteBooking(clientName1); 
        bookingManager.deleteBooking(clientName2);
        
        // Checking if the booking object is deleted from the array list
        assertTrue(bookingManager.getBookings().isEmpty());
    }    
}
