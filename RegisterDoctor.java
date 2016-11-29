/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalStaff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author HACKER
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author HACKER
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author HACKER
 */
   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class RegisterDoctor   extends JPanel {

    private static JLabel firstNameLabel;
    private static JLabel lastNameLabel;
    private static JLabel phoneLabel;
    private static JLabel phone2Label;
    private static JLabel addressLabel;
    private static JLabel employeeIdLabel;
    private static JLabel depertmentLabel;
    private static JLabel roleLabel;
    private static JTextField roleField;
    private static JTextField depertmentField;
    private static JButton submitButton;
    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextField phoneField;
    private static JTextField phone2Field;
    private static JTextField addressField;
    private static JTextField employeeIdField;

    public  RegisterDoctor() {
        setSize(1000, 765);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        phone2Field = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        employeeIdField = new JTextField();
        depertmentField = new JTextField();
        depertmentLabel = new JLabel("Depertment:");
        roleLabel = new JLabel("Role:");
        roleField = new JTextField();

        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        phone2Label = new JLabel("Phone:");
        phoneLabel = new JLabel("Phone 2:");
        addressLabel = new JLabel("Address:");
        employeeIdLabel = new JLabel("Employee ID:");
        submitButton = new JButton("Submit");
        
        firstNameLabel.setBounds(30,30,100,25);
        firstNameField.setBounds(140,30,200,25);
        lastNameLabel.setBounds(30,70,100,25);
        lastNameField.setBounds(140,70,200,25);
        roleLabel.setBounds(30,100,100,25);
        roleField.setBounds(140,100,200,25);
        phoneLabel.setBounds(30,130,100,25);
        phoneField.setBounds(140,130,200,25);
        depertmentLabel.setBounds(30,160,100,25);
        depertmentField.setBounds(140,160,200,25);
        employeeIdLabel.setBounds(30,190,100,25);
        employeeIdField.setBounds(140,190,200,25);
        submitButton.setBounds(400,75,200,30);
        
        submitButton.setBackground(Color.decode("#1e90ff"));
        submitButton.setBorder( new LineBorder(Color.decode("#1e90ff")));
        submitButton.setForeground(Color.white);
        
        List<JLabel> labels = Arrays.asList(firstNameLabel,lastNameLabel,
                phone2Label,roleLabel,phoneLabel,addressLabel,depertmentLabel,employeeIdLabel);
        List<JTextField> textFields = Arrays.asList(firstNameField,lastNameField,
                phone2Field,roleField,phoneField,addressField,depertmentField,employeeIdField);
        setLabelProperties(labels);
        setFieldProperties(textFields);
        
        submitButton.addActionListener(e -> {
            DatabaseAccessObjects.MedicalStaffDaos.registerMedicalStaff(
                    firstNameField.getText(), 
                    lastNameField.getText(), 
                    roleField.getText(), 
                    phoneField.getText(), 
                    depertmentField.getText(), 
                    employeeIdField.getText());
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




