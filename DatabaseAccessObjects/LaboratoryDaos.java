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
public class LaboratoryDaos {
    public static final void registerANewLabTest(String sampleType,
            String patientFirstName,
            String patientLastName,
            String testType,
            String testResults) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO labrequestform VALUES(?,?,?,?,?)");
            preparedStatement.setString(1,sampleType);
            preparedStatement.setString(2,patientFirstName);
            preparedStatement.setString(3,patientLastName);
            preparedStatement.setString(4,testType);
            preparedStatement.setString(5,testResults);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Test Logging Succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
