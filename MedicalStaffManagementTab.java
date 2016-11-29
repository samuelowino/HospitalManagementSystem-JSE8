/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalStaff;

import Reception.LogInDoctorShift;
import Reception.LogInVisitors;
import Reception.ViewVisitors;

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
public class MedicalStaffManagementTab extends JPanel{
    
    private static JTabbedPane tabbedPane;
    
    public MedicalStaffManagementTab(){
        setSize(700, 700);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,700,700);
        
        tabbedPane.add("Register Doctors/Nurses", new RegisterDoctor());
        tabbedPane.add("View Availble Doctors/Nurses", new ViewMedicalStaff());
        
        
        add(tabbedPane);
        
        repaint();
    }
}



