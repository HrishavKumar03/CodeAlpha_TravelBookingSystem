package TravelManageMentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightBookingFrame extends JFrame {

    private JComboBox<String> flightComboBox;
    private JTextField departureDateField;
    private JTextField returnDateField;
    private JComboBox<String> routeComboBox;
    private JComboBox<String> bookedFlightsComboBox;
    private JButton bookButton;
    private JButton deleteButton;

    // Example flight numbers and names
    private final String[] flights = {
            "AI101 - Air India",
            "6E202 - IndiGo",
            "SG303 - SpiceJet",
            "G804 - GoAir",
            "UK505 - Vistara",
            "9W606 - Jet Airways",
            "AI707 - Air India",
            "6E808 - IndiGo",
            "SG909 - SpiceJet",
            "UK010 - Vistara"
    };

    // Example routes and costs
    private final String[] routes = {
            "Delhi to Mumbai - $200",
            "Bengaluru to Kolkata - $250",
            "Chennai to Hyderabad - $220",
            "Pune to Jaipur - $230",
            "Goa to Kerala - $240",
            "Delhi to Bengaluru - $210",
            "Mumbai to Kolkata - $260",
            "Hyderabad to Jaipur - $270",
            "Chennai to Goa - $280",
            "Pune to Kerala - $290"
    };

    // List to store booked flights
    private final ArrayList<String> bookedFlights = new ArrayList<>();

    public FlightBookingFrame() {
        setTitle("Flight Booking - Travel Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        add(panel, BorderLayout.CENTER);

        JLabel flightLabel = new JLabel("Flight:");
        flightComboBox = new JComboBox<>(flights);

        JLabel departureDateLabel = new JLabel("Departure Date:");
        departureDateField = new JTextField();

        JLabel returnDateLabel = new JLabel("Return Date:");
        returnDateField = new JTextField();

        JLabel routeLabel = new JLabel("Route:");
        routeComboBox = new JComboBox<>(routes);

        JLabel bookedFlightsLabel = new JLabel("Booked Flights:");
        bookedFlightsComboBox = new JComboBox<>();

        bookButton = new JButton("Book Flight");
        deleteButton = new JButton("Delete Booking");

        panel.add(flightLabel);
        panel.add(flightComboBox);
        panel.add(departureDateLabel);
        panel.add(departureDateField);
        panel.add(returnDateLabel);
        panel.add(returnDateField);
        panel.add(routeLabel);
        panel.add(routeComboBox);
        panel.add(bookedFlightsLabel);
        panel.add(bookedFlightsComboBox);
        panel.add(bookButton);
        panel.add(deleteButton);

        // Book button action
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFlight = (String) flightComboBox.getSelectedItem();
                String departureDate = departureDateField.getText();
                String returnDate = returnDateField.getText();
                String selectedRoute = (String) routeComboBox.getSelectedItem();

                String bookingDetails = selectedFlight + " | " + departureDate + " - " + returnDate + " | " + selectedRoute;
                bookedFlights.add(bookingDetails);
                bookedFlightsComboBox.addItem(bookingDetails);

                // Here, you would typically save these details to the database and confirm the booking.
                JOptionPane.showMessageDialog(null, "Flight Booking Successful!\n" +
                        "Flight: " + selectedFlight + "\n" +
                        "Departure: " + departureDate + "\n" +
                        "Return: " + returnDate + "\n" +
                        "Route: " + selectedRoute);
            }
        });

        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBooking = (String) bookedFlightsComboBox.getSelectedItem();
                if (selectedBooking != null) {
                    bookedFlights.remove(selectedBooking);
                    bookedFlightsComboBox.removeItem(selectedBooking);
                    JOptionPane.showMessageDialog(null, "Flight Booking Deleted Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No booking selected for deletion.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlightBookingFrame().setVisible(true));
    }
}
