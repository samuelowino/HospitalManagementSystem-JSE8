/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reception;

import Authentication.LogInScreen;
import Users.Adduser;
import Users.SessionLogs;
import Users.ViewUsers;

/**
 *
 * @author HACKER
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author HACKER
 */
public class ReceptionManagementTab extends JPanel{
    
    private static JTabbedPane tabbedPane;
    
    public ReceptionManagementTab(){
        setSize(700, 700);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,700,700);
        
        tabbedPane.add("Doctors Clock In/out", new LogInDoctorShift());
        tabbedPane.add("Visitors Log", new LogInVisitors());
        tabbedPane.add("View Visitors Logs", new ViewVisitors());
        
        
        add(tabbedPane);
        
        repaint();
    }
}


