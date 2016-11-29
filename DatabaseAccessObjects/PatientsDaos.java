/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HACKER
 */
public class PatientsDaos {
     public static final void registerPatient(String firstName,String lastName,String phone,String phone2,String emailAddress,String dateOfBirth,String wardNo) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,emailAddress);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,phone2);
            preparedStatement.setString(6,dateOfBirth);
            preparedStatement.setString(7,wardNo);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "User Registration Succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public static final void deletePatientRecords(String emailAddress) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE emailAddress = ?");
            preparedStatement.setString(1,emailAddress);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "User Registration Succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
