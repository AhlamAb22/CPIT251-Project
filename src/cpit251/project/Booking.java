public class Booking {
    private String clientName;
    private String serviceType;
    private String appointmentDate;
    private String stylistName;

    public Booking(String clientName, String serviceType, String appointmentDate, String stylistName) {
        this.clientName = clientName;
        this.serviceType = serviceType;
        this.appointmentDate = appointmentDate;
        this.stylistName = stylistName;
    }

    public String getClientName() { return clientName; }

    @Override
    public String toString() {
        return "Client: " + clientName +
                ", Service: " + serviceType +
                ", Date: " + appointmentDate +
                ", Stylist: " + stylistName;
    }
}
