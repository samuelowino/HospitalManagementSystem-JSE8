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
public class UsersDaos {

    public static final void registerUser(String firstName,String lastName,String emailAddress,String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,emailAddress);
            preparedStatement.setString(4,password);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "User Registration Succefull...");
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
