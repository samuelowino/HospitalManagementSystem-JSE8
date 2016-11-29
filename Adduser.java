/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;


/**
 *
 * @author HACKER
 */
   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Services.PasswordEncryptionService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author HACKER
 */
public class Adduser extends JPanel {

    private static JLabel firstNameLabel;
    private static JLabel lastNameLabel;
    private static JLabel emailAddressLabel;
    private static JLabel passwordLabel;
    private static JButton submitButton;
    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextField addressField;
    private static JPasswordField passwordField;

    public  Adduser() {
        setSize(1000, 765);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        addressField = new JTextField();
        passwordField = new JPasswordField();

        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        emailAddressLabel = new JLabel("Email Addreess:");
        passwordLabel = new JLabel("Password:");
        submitButton = new JButton("Submit");
        
        firstNameLabel.setBounds(30,30,100,25);
        firstNameField.setBounds(160,30,200,25);
        lastNameLabel.setBounds(30,70,100,25);
        lastNameField.setBounds(160,70,200,25);
        emailAddressLabel.setBounds(30,100,200,25);
        passwordField.setBounds(160,160,200,25);
        passwordLabel.setBounds(30,160,100,25);
        addressField.setBounds(160,100,200,25);
        submitButton.setBounds(400,75,200,30);
        
        submitButton.setBackground(Color.decode("#1e90ff"));
        submitButton.setBorder( new LineBorder(Color.decode("#1e90ff")));
        submitButton.setForeground(Color.white);
        
        List<JLabel> labels = Arrays.asList(firstNameLabel,lastNameLabel,passwordLabel,
                emailAddressLabel,emailAddressLabel);
        List<JTextField> textFields = Arrays.asList(firstNameField,lastNameField,
                addressField,passwordField);
        setLabelProperties(labels);
        setFieldProperties(textFields);
        
        submitButton.addActionListener(e -> {
            //encrypt password
            String cipher = PasswordEncryptionService.getCipherText( String.valueOf(passwordField.getPassword()));
            
            DatabaseAccessObjects.UsersDaos.registerUser(
                    firstNameField.getText(), 
                    lastNameField.getText(),
                    addressField.getText(),
                    cipher
                    );
        });
        
        add(submitButton);

        repaint();
        setVisible(true);
    }

    public final void setFieldProperties(List<JTextField> labels) {
        labels.forEach(e -> {
            e.setForeground(Color.black);
            e.setFont(new Font("Calibri", Font.BOLD, 18));
            e.setBorder(new LineBorder(Color.decode("#f5f5f5")));
            e.addFocusListener(
                    new FocusListener() {
                @Override
                public void focusGained(FocusEvent event) {
                    e.setBorder(new LineBorder(Color.decode("#1e90ff")));
                }

                @Override
                public void focusLost(FocusEvent event) {
                    e.setBorder(new LineBorder(Color.decode("#f5f5f5")));
                }
            }
            );
            add(e);
        });
    }

    public final void setLabelProperties(List<JLabel> labels) {
        labels.forEach(e -> {
            e.setForeground(Color.black);
            e.setFont(new Font("Calibri", Font.BOLD, 18));
            add(e);
        });
    }

}


