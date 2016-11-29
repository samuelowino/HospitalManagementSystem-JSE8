/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controller.SkeletonView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HACKER
 */
public class AuthenticationService {
     public final void authenticateUser(String enteredPasswordHashed, String emailAddress) {

        String password = "";

        //obtain user password cipher
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://"
                + "localhost:3306/payrollSystem", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE emailAddress IN(?);");
            preparedStatement.setString(1, emailAddress);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString(1);
            }

            //compare password ciphers
            if (enteredPasswordHashed.equals(password)) {
                // authentication succefull...
                 new SkeletonView();

            } else if (!enteredPasswordHashed.equals(password)) {
                //authetication failed
                JOptionPane.showMessageDialog(null, "WRONG PASSWORD !", "Alpha Payroll System", JOptionPane.ERROR_MESSAGE);
                /* frame.setVisible(false);
                new PayrollSystem();*/

                //temp
                // authentication succefull...

                //return AUTHENTICATION_FAILED;
            } else {
                new SkeletonView();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred", "Alpha payroll System", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ":Could't connect to database\n Click on the red- wamp  server icon to activate the server" + e.getMessage(),
                    "Alpha Payroll System", JOptionPane.ERROR_MESSAGE);
        }
    }
}
