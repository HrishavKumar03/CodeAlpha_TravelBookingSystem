 package TravelManageMentSystem;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

 public class BookingOptionsFrame extends JFrame {

     private JButton bookHotelButton;
     private JButton bookFlightButton;
     private JButton bookTransportButton;
     private JButton logoutButton;

     public BookingOptionsFrame() {
         setTitle("Booking Options - Travel Management System");
         setSize(400, 300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);

         JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
         panel.setBackground(Color.LIGHT_GRAY); // Set background color
         add(panel, BorderLayout.CENTER);

         // Enhanced font
         Font buttonFont = new Font("Arial", Font.BOLD, 14);

         bookHotelButton = new JButton("Book Hotel");
         bookHotelButton.setFont(buttonFont);
         bookHotelButton.setBackground(Color.DARK_GRAY);
         bookHotelButton.setForeground(Color.WHITE);

         bookFlightButton = new JButton("Book Flight");
         bookFlightButton.setFont(buttonFont);
         bookFlightButton.setBackground(Color.DARK_GRAY);
         bookFlightButton.setForeground(Color.WHITE);

         bookTransportButton = new JButton("Book Transportation");
         bookTransportButton.setFont(buttonFont);
         bookTransportButton.setBackground(Color.DARK_GRAY);
         bookTransportButton.setForeground(Color.WHITE);

         logoutButton = new JButton("Logout");
         logoutButton.setFont(buttonFont);
         logoutButton.setBackground(Color.DARK_GRAY);
         logoutButton.setForeground(Color.WHITE);

         panel.add(bookHotelButton);
         panel.add(bookFlightButton);
         panel.add(bookTransportButton);
         panel.add(logoutButton);

         // Book Hotel button action
         bookHotelButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new HotelBookingFrame().setVisible(true);
             }
         });

         // Book Flight button action
         bookFlightButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new FlightBookingFrame().setVisible(true);
             }
         });

         // Book Transport button action
         bookTransportButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new TransportationBookingFrame().setVisible(true);
             }
         });

         // Logout button action
         logoutButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new LoginFrame().setVisible(true);
                 dispose();
             }
         });
     }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> new BookingOptionsFrame().setVisible(true));
     }
 }
