/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import Controller.SkeletonView;
import Services.PasswordEncryptionService;

/**
 *
 * @author HACKER
 */
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HACKER
 */
public class LogInScreen extends JFrame {

    private static JLabel passwordLabel;
    private static JLabel emailAddressLabel;
    private static JTextField emailField;
    private static JPasswordField passwordField;
    private static JButton logInButton;
    private static JLabel backgroundImage;

    public LogInScreen() {

        setSize(400, 340);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Spam-Detect Soft");
        setResizable(false);

        passwordField = new JPasswordField();
        emailAddressLabel = new JLabel("Email Address:");
        emailField = new JTextField();
        passwordLabel = new JLabel("Password:");
        logInButton = new JButton("Sign in");
        backgroundImage = new JLabel(new ImageIcon(getClass().getResource("/appimages/Hospital.jpg")));

        emailAddressLabel.setBounds(60, 30, 200, 25);
        emailField.setBounds(60, 60, 200, 25);
        passwordLabel.setBounds(60, 85, 150, 25);
        passwordField.setBounds(60, 120, 200, 25);
        logInButton.setBounds(100, 170, 150, 30);
        backgroundImage.setBounds(0, 0, 400, 340);

        passwordLabel.setForeground(Color.WHITE);
        emailAddressLabel.setForeground(Color.WHITE);
        logInButton.setBackground(Color.decode("#1e90ff"));
        logInButton.setForeground(Color.WHITE);

        add(emailAddressLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(logInButton);
        add(backgroundImage);

        logInButton.addActionListener(e -> {
            //auth
            int auth_sucess = authenticateUser(
                    PasswordEncryptionService.getCipherText(String.valueOf(passwordField.getPassword())),
                    emailField.getText());
            switch (auth_sucess) {
                case 1:
                    DatabaseAccessObjects.SessionLogsDaos.registerASession(
                            LocalDate.now().toString(),
                            Integer.toString(Math.abs((new Random(LocalTime.now().getSecond()).nextInt()))),
                            emailField.getText());
                    setVisible(false);
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        });

        repaint();
        setVisible(true);
    }

    /**
     * Authenticate user...
     *
     * @param enteredPasswordHashed
     * @param emailAddress
     */
    public final int authenticateUser(String enteredPasswordHashed, String emailAddress) {

        String password = "";

        //obtain user password cipher
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/hospitalManagmentSystem", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(""
                    + "SELECT password FROM users WHERE emailAddress IN(?);");
            preparedStatement.setString(1, emailAddress);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString(1);
            }

            //compare password ciphers
            if (enteredPasswordHashed.equals(password)) {
                // authentication succefull...
                JOptionPane.showMessageDialog(this, "Log in succefull!", "", JOptionPane.ERROR_MESSAGE);
                this.setVisible(false);
                new SkeletonView();
                return 1;

            } else if (!enteredPasswordHashed.equals(password)) {
                //authetication failed
                JOptionPane.showMessageDialog(this, "WRONG PASSWORD !", "Alpha Payroll System", JOptionPane.ERROR_MESSAGE);
                /* frame.setVisible(false);
                new PayrollSystem();*/

                //temp
                // authentication succefull...
                return 0;
            } else {
                this.setVisible(false);
                new SkeletonView();
                JOptionPane.showMessageDialog(this, "An unexpected error occurred", "Alpha payroll System", JOptionPane.ERROR_MESSAGE);
                return 0;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, ":Could't connect to database\n Click on the red- wamp  server icon to activate the server" + e.getMessage(),
                    "Alpha Payroll System", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

}
