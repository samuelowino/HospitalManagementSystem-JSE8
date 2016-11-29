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
public class EquipmentDaos {
     public static final void AddNewEquipment(String equipmentID,String ItemName,String PurchaseDate,String ShelfID,String Viability) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Equipment VALUES(?,?,?,?)");
            preparedStatement.setString(1,ItemName);
            preparedStatement.setString(2,PurchaseDate);
            preparedStatement.setString(3,ShelfID);
            preparedStatement.setString(4,Viability);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Equipment Registration Succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public static final void logOutEquipment(String equipmentID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Equipment WHERE equipmentID = ?");
            preparedStatement.setString(1,equipmentID);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Equipment Logged out Succefully...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
      public static final void updateEquipmentDetails(String equipmentID,String itemName,String purchaseDate,String shelfID,String viability) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE equipment SET itemName = ?, purchaseDate = ?,shelfID = ?,viability = ? WHERE ");
            preparedStatement.setString(1,equipmentID);
            preparedStatement.setString(1,itemName);
            preparedStatement.setString(2,purchaseDate);
            preparedStatement.setString(3,shelfID);
            preparedStatement.setString(4,viability);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "User Registration Succefull...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
