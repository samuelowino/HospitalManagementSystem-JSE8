/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab;

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
public class LabManagementTabs extends JPanel{
    
    private static JTabbedPane tabbedPane;
    
    public LabManagementTabs(){
        setSize(1300, 700);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,700,700);
        
        tabbedPane.add("Fill Lab Request Form", new LabRequestForm());
        tabbedPane.add("Lab Request Logs", new LabRequestLogs());
        tabbedPane.add("Equipment Inventory", new EquipmentInventory());
        
        
        add(tabbedPane);
        
        repaint();
    }
}

