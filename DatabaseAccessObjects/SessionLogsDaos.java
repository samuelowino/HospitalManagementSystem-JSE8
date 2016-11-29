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
public class SessionLogsDaos {

    /**
     *
     * @param startTime
     * @param SessionEnd
     * @param emailAddress
     */
    public static final void registerASession(String startTime,String SessionEnd,String emailAddress) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagmentSystem","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sessionLogs VALUES(?,?,?)");
            preparedStatement.setString(1,startTime);
            preparedStatement.setString(2,SessionEnd);
            preparedStatement.setString(3,emailAddress);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
}
