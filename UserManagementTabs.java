/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Patients.AdmitPatientView;
import Patients.ViewPatientRecordsView;
import Patients.wardLogs;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
public class UserManagementTabs extends JPanel{
    
    private static JTabbedPane tabbedPane;
    
    public UserManagementTabs(){
        setSize(700, 700);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,700,700);
        
        tabbedPane.add("Register User", new Adduser());
        tabbedPane.add("Manage Users", new ViewUsers());
        tabbedPane.add("Session Logs", new SessionLogs());
        
        
        add(tabbedPane);
        
        repaint();
    }
}

