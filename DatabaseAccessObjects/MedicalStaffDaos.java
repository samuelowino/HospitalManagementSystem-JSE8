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
public class MedicalStaffDaos {
    public static final void registerMedicalStaff(
            String firstName
            ,String lastName,
            String role,
            String phone,
            String depertment,
            String employeeID) {
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicalStaff VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,role);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,depertment);
            preparedStatement.setString(6,employeeID);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Staff Registration Succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
