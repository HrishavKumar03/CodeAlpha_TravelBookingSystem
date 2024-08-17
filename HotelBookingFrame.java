package TravelManageMentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelBookingFrame extends JFrame {

    private JTextField checkInDateField;
    private JTextField checkOutDateField;
    private JComboBox<String> hotelComboBox;
    private JComboBox<String> bookedHotelsComboBox;
    private JButton bookButton;
    private JButton deleteButton;


    private final String[] hotels = {
            "Taj Mahal Palace, Mumbai - $200",
            "Oberoi Udaivilas, Udaipur - $300",
            "The Leela Palace, Bengaluru - $250",
            "ITC Grand Chola, Chennai - $220",
            "The Oberoi Amarvilas, Agra - $270",
            "The Lalit, Delhi - $190",
            "JW Marriott, Jaipur - $240",
            "The Park, Kolkata - $210",
            "Ramada Plaza, Hyderabad - $230",
            "Hyatt Regency, Goa - $260"
    };


    private final ArrayList<String> bookedHotels = new ArrayList<>();

    public HotelBookingFrame() {
        setTitle("Hotel Booking - Travel Management System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY); // Set background color
        add(panel, BorderLayout.CENTER);

        // Enhanced font
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JLabel hotelLabel = new JLabel("Hotel:");
        hotelLabel.setFont(labelFont);
        hotelComboBox = new JComboBox<>(hotels);
        JLabel checkInDateLabel = new JLabel("Check-In Date:");
        checkInDateLabel.setFont(labelFont);
        checkInDateField = new JTextField();
        JLabel checkOutDateLabel = new JLabel("Check-Out Date:");
        checkOutDateLabel.setFont(labelFont);
        checkOutDateField = new JTextField();

        JLabel bookedHotelsLabel = new JLabel("Booked Hotels:");
        bookedHotelsLabel.setFont(labelFont);
        bookedHotelsComboBox = new JComboBox<>();

        bookButton = new JButton("Book");
        bookButton.setFont(buttonFont);
        bookButton.setBackground(Color.DARK_GRAY);
        bookButton.setForeground(Color.WHITE);

        deleteButton = new JButton("Delete Booking");
        deleteButton.setFont(buttonFont);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);

        panel.add(hotelLabel);
        panel.add(hotelComboBox);
        panel.add(checkInDateLabel);
        panel.add(checkInDateField);
        panel.add(checkOutDateLabel);
        panel.add(checkOutDateField);
        panel.add(bookedHotelsLabel);
        panel.add(bookedHotelsComboBox);
        panel.add(bookButton);
        panel.add(deleteButton);

        // Book button action
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedHotel = (String) hotelComboBox.getSelectedItem();
                String checkInDate = checkInDateField.getText();
                String checkOutDate = checkOutDateField.getText();

                String bookingDetails = selectedHotel + " | Check-In: " + checkInDate + " | Check-Out: " + checkOutDate;
                bookedHotels.add(bookingDetails);
                bookedHotelsComboBox.addItem(bookingDetails);

                JOptionPane.showMessageDialog(null, "Hotel Booking Successful!\n" +
                        "Hotel: " + selectedHotel + "\n" +
                        "Check-In Date: " + checkInDate + "\n" +
                        "Check-Out Date: " + checkOutDate);
            }
        });

         
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBooking = (String) bookedHotelsComboBox.getSelectedItem();
                if (selectedBooking != null) {
                    bookedHotels.remove(selectedBooking);
                    bookedHotelsComboBox.removeItem(selectedBooking);
                    JOptionPane.showMessageDialog(null, "Hotel Booking Deleted Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No booking selected for deletion.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HotelBookingFrame().setVisible(true));
    }
}
