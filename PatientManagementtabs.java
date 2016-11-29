/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patients;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author HACKER
 */
public class PatientManagementtabs extends JPanel{
    
    private static JTabbedPane tabbedPane;
    
    public PatientManagementtabs(){
        setSize(700, 700);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,700,700);
        
        tabbedPane.add("Admit Patient", new AdmitPatientView());
        tabbedPane.add("Patient Records", new ViewPatientRecordsView());
        tabbedPane.add("Ward Logs", new wardLogs());
        
        
        add(tabbedPane);
        
        repaint();
    }
}
