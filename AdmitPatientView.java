/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patients;

import com.toedter.calendar.JDateChooser;
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
import javax.swing.border.TitledBorder;

/**
 *
 * @author HACKER
 */
public class AdmitPatientView extends JPanel {

    private static JLabel bedSpaceLabel;
    private static JLabel bedsOcuppiedLabel;
    private static JLabel firstNameLabel;
    private static JLabel lastNameLabel;
    private static JLabel phoneLabel;
    private static JLabel phone2Label;
    private static JLabel addressLabel;
    private static JLabel dateOfBirthLabel;
    private static JButton submitButton;
    private static JPanel wardDetailsPanel;
    private static JLabel wardIDNoLabel;
    private static JTextField wardIDNoField;

    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextField phoneField;
    private static JTextField phone2Field;
    private static JTextField addressField;
    private static JTextField bedSpaceField;
    private static JTextField bedsOcuppiedField;
    private static JDateChooser dateOfBirthField;

    public AdmitPatientView() {
        setSize(1000, 765);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        phone2Field = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        dateOfBirthField = new JDateChooser();
        wardDetailsPanel = new JPanel(null);
        wardIDNoField = new JTextField();
        wardIDNoLabel = new JLabel("Ward No:");
        bedSpaceLabel = new JLabel("Bed Space:");
        bedSpaceField = new JTextField();
        bedsOcuppiedLabel = new JLabel("Beds Ocuppied:");
        bedsOcuppiedField = new JTextField();
        

        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        phone2Label = new JLabel("Phone:");
        phoneLabel = new JLabel("Phone 2:");
        addressLabel = new JLabel("Address:");
        dateOfBirthLabel = new JLabel("Date of Birth:");
        submitButton = new JButton("Submit");
        
        firstNameLabel.setBounds(30,30,100,25);
        firstNameField.setBounds(140,30,200,25);
        lastNameLabel.setBounds(30,70,100,25);
        lastNameField.setBounds(140,70,200,25);
        phone2Label.setBounds(30,100,100,25);
        phone2Field.setBounds(140,100,200,25);
        phoneLabel.setBounds(30,130,100,25);
        phoneField.setBounds(140,130,200,25);
        addressLabel.setBounds(30,160,100,25);
        addressField.setBounds(140,160,200,25);
        dateOfBirthLabel.setBounds(30,200,100,25);
        dateOfBirthField.setBounds(140,200,200,25);
        submitButton.setBounds(500,350,140,30);
        wardIDNoLabel.setBounds(10,20,100,25);
        wardIDNoField.setBounds(100,20,230,25);
        bedSpaceLabel.setBounds(10,60,100,25);
        bedSpaceField.setBounds(100,60,230,25);
        bedsOcuppiedLabel.setBounds(10,100,100,25);
        bedsOcuppiedField.setBounds(100,100,230,25);
        wardDetailsPanel.setBounds(30,250,450,150);
        
        submitButton.setBackground(Color.decode("#1e90ff"));
        submitButton.setBorder( new LineBorder(Color.decode("#1e90ff")));
        submitButton.setForeground(Color.white);
        wardDetailsPanel.setBorder( new TitledBorder(
                new LineBorder(Color.decode("#1e90ff")),"Fill only if patient is admited."));
        wardDetailsPanel.add(wardIDNoField);
        wardDetailsPanel.add(wardIDNoLabel);
        wardDetailsPanel.add(bedSpaceField);
        wardDetailsPanel.add(bedSpaceLabel);
        wardDetailsPanel.add(bedsOcuppiedField);
        wardDetailsPanel.add(bedsOcuppiedLabel);
        
        List<JLabel> labels = Arrays.asList(firstNameLabel,lastNameLabel,
                phone2Label,phoneLabel,addressLabel,dateOfBirthLabel);
        List<JTextField> textFields = Arrays.asList(firstNameField,lastNameField,
                phone2Field,phoneField,addressField);
        setLabelProperties(labels);
        setFieldProperties(textFields);
        
        submitButton.addActionListener(e -> {
            DatabaseAccessObjects.PatientsDaos.registerPatient(
                    firstNameField.getText(), 
                    lastNameField.getText(),
                    phoneField.getText(),
                    phone2Field.getText(),
                    addressField.getText(), 
                    dateOfBirthField.getDate().toString(), 
                    wardIDNoField.getText());
            //chec if patint is admited.
            String isAdmmited = "Admited";
            String bedSpace = "";
            String bedsOccupied = "";
            switch(wardIDNoField.getText()){
                case "":
                    isAdmmited = "Not admited";
                    bedSpace = "n/a";
                    bedsOccupied = "n/a";
                    break;
                default:
                    isAdmmited = wardIDNoField.getText();
                    break;
            }
            
            DatabaseAccessObjects.WardLogsDaos.registerWard(
                    isAdmmited, 
                    bedSpaceField.getText(),
                    bedsOcuppiedField.getText());
        });
        
        add(submitButton);
        add(dateOfBirthField);
        add(wardDetailsPanel);

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
