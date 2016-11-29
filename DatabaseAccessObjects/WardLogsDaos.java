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
public class WardLogsDaos {
     public static final void registerWard(String wardNo,String bedSpace,String bedOcupied) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO wardLogs VALUES(?,?,?)");
            preparedStatement.setString(1,wardNo);
            preparedStatement.setString(2,bedSpace);
            preparedStatement.setString(3,bedOcupied);
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public static final void deleteUser(String emailAddress) {
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
