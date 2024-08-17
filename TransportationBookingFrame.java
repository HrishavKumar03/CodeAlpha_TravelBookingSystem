package TravelManageMentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TransportationBookingFrame extends JFrame {

    private JComboBox<String> vehicleTypeComboBox;
    private JComboBox<String> pickupLocationComboBox;
    private JComboBox<String> dropoffLocationComboBox;
    private JTextField pickupDateField;
    private JComboBox<String> bookingIdComboBox;
    private JTextField priceField;
    private JButton bookButton;
    private JButton deleteButton;


    private final String[] cities = {
            "Delhi", "Mumbai", "Bengaluru", "Kolkata", "Chennai",
            "Hyderabad", "Pune", "Jaipur", "Goa", "Kerala"
    };


    private final String[] bookingIds = {
            "Booking ID 1001", "Booking ID 1002", "Booking ID 1003",
            "Booking ID 1004", "Booking ID 1005", "Booking ID 1006",
            "Booking ID 1007", "Booking ID 1008", "Booking ID 1009",
            "Booking ID 1010"
    };


    private final HashMap<String, Integer> routePrices = new HashMap<>();


    private final int basePrice = 30;
    private final int perCityCharge = 10;

    public TransportationBookingFrame() {
        setTitle("Transportation Booking - Travel Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        initializeRoutePrices();

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY); // Set background color
        add(panel, BorderLayout.CENTER);


        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JLabel vehicleTypeLabel = new JLabel("Vehicle Type:");
        vehicleTypeLabel.setFont(labelFont);
        vehicleTypeComboBox = new JComboBox<>(new String[]{"Car", "Bus", "Taxi"});

        JLabel pickupLocationLabel = new JLabel("Pickup Location:");
        pickupLocationLabel.setFont(labelFont);
        pickupLocationComboBox = new JComboBox<>(cities);

        JLabel dropoffLocationLabel = new JLabel("Dropoff Location:");
        dropoffLocationLabel.setFont(labelFont);
        dropoffLocationComboBox = new JComboBox<>(cities);

        JLabel pickupDateLabel = new JLabel("Pickup Date:");
        pickupDateLabel.setFont(labelFont);
        pickupDateField = new JTextField();

        JLabel priceLabel = new JLabel("Route Price:");
        priceLabel.setFont(labelFont);
        priceField = new JTextField();
        priceField.setEditable(false);

        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setFont(labelFont);
        bookingIdComboBox = new JComboBox<>(bookingIds);

        bookButton = new JButton("Book Transportation");
        bookButton.setFont(buttonFont);
        bookButton.setBackground(Color.DARK_GRAY);
        bookButton.setForeground(Color.WHITE);

        deleteButton = new JButton("Delete Booking");
        deleteButton.setFont(buttonFont);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);

        panel.add(vehicleTypeLabel);
        panel.add(vehicleTypeComboBox);
        panel.add(pickupLocationLabel);
        panel.add(pickupLocationComboBox);
        panel.add(dropoffLocationLabel);
        panel.add(dropoffLocationComboBox);
        panel.add(pickupDateLabel);
        panel.add(pickupDateField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(bookingIdLabel);
        panel.add(bookingIdComboBox);
        panel.add(bookButton);
        panel.add(deleteButton);


        ActionListener updatePriceListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePrice();
            }
        };
        pickupLocationComboBox.addActionListener(updatePriceListener);
        dropoffLocationComboBox.addActionListener(updatePriceListener);


        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vehicleType = (String) vehicleTypeComboBox.getSelectedItem();
                String pickupLocation = (String) pickupLocationComboBox.getSelectedItem();
                String dropoffLocation = (String) dropoffLocationComboBox.getSelectedItem();
                String pickupDate = pickupDateField.getText();
                String price = priceField.getText();
                String bookingId = (String) bookingIdComboBox.getSelectedItem();


                JOptionPane.showMessageDialog(null, "Transportation Booking Successful!\n" +
                        "Booking ID: " + bookingId + "\n" +
                        "Vehicle: " + vehicleType + "\n" +
                        "From: " + pickupLocation + "\n" +
                        "To: " + dropoffLocation + "\n" +
                        "Pickup Date: " + pickupDate + "\n" +
                        "Price: " + price);
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBooking = (String) bookingIdComboBox.getSelectedItem();
                if (selectedBooking != null) {
                    bookingIdComboBox.removeItem(selectedBooking);
                    JOptionPane.showMessageDialog(null, "Transportation Booking Deleted Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No booking selected for deletion.");
                }
            }
        });
    }


    private void initializeRoutePrices() {
        routePrices.put("Delhi-Mumbai", 50);
        routePrices.put("Mumbai-Bengaluru", 45);
        routePrices.put("Bengaluru-Kolkata", 55);
        routePrices.put("Kolkata-Chennai", 60);
        routePrices.put("Chennai-Hyderabad", 40);
        routePrices.put("Hyderabad-Pune", 35);
        routePrices.put("Pune-Jaipur", 65);
        routePrices.put("Jaipur-Goa", 70);
        routePrices.put("Goa-Kerala", 75);
        routePrices.put("Kerala-Delhi", 80);
        // Add more routes as needed
    }


    private void updatePrice() {
        String pickupLocation = (String) pickupLocationComboBox.getSelectedItem();
        String dropoffLocation = (String) dropoffLocationComboBox.getSelectedItem();

        if (pickupLocation != null && dropoffLocation != null && !pickupLocation.equals(dropoffLocation)) {
            String routeKey = pickupLocation + "-" + dropoffLocation;
            Integer price = routePrices.get(routeKey);

            if (price != null) {
                priceField.setText("$" + price);
            } else {

                int totalPrice = basePrice + perCityCharge * (Math.abs(pickupLocationComboBox.getSelectedIndex() - dropoffLocationComboBox.getSelectedIndex()));
                priceField.setText("$" + totalPrice);
            }
        } else {
            priceField.setText("N/A");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TransportationBookingFrame().setVisible(true));
    }
}
