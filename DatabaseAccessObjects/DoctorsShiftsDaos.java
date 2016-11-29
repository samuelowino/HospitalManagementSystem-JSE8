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
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author HACKER
 */
public class DoctorsShiftsDaos {

    public static final void clockIn(String ClockInTime, String firstName, String lastName, String employeeID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DoctorsShifd VALUES(?,?,?,?)");
            preparedStatement.setString(1, ClockInTime);
            preparedStatement.setString(2, "On Shift");
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(4, employeeID);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Clock in succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static final void clockOut(String emailAddress) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem", "root", "")) {

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE DoctorsShifts SET clockOutTime = ? WHERE emailAddress = ?");
            preparedStatement.setString(1, LocalDate.now().toString());
            preparedStatement.setString(2, emailAddress);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Clock out successfull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
