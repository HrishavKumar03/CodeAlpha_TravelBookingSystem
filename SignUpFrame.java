package TravelManageMentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public SignUpFrame() {
        setTitle("Sign Up - Travel Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY); // Set background color
        add(panel, BorderLayout.CENTER);


        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField();

        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(buttonFont);
        signUpButton.setBackground(Color.DARK_GRAY);
        signUpButton.setForeground(Color.WHITE);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(signUpButton);


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                JOptionPane.showMessageDialog(null, "Sign Up Successful! You can now log in.");
                new LoginFrame().setVisible(true);
                dispose();
            }
        });
    }
}
