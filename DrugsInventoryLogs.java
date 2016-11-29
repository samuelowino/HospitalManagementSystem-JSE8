/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

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
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HACKER
 */
public class DrugsInventoryLogs extends JPanel {
    
    private static JScrollPane scrollPane;
    private static JTable patientRecordsTable;
    private static JPanel topSectionPanel;
    private static JPanel managementPanel;
    private static JButton sortButton;
    private static JButton editButton;
    private static JButton deleteButton;
    private static JLabel patientRecordsLabel;
    private static DefaultTableModel tableModel;
    private static JTable newTable;
    
    public DrugsInventoryLogs(){
        setSize(1000, 765);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        scrollPane = new JScrollPane();
        patientRecordsTable = new JTable();
        topSectionPanel = new JPanel(null);
        managementPanel = new JPanel(null);
        sortButton = new JButton("Sort");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        patientRecordsLabel = new JLabel("Patient Records:");
        
        topSectionPanel.setBounds(20,0,650,70);
        managementPanel.setBounds(20,95,650,60);
        scrollPane.setBounds(20,175,650,300);
        patientRecordsLabel.setBounds(20,35,200,25);
        
        topSectionPanel.setBorder( new LineBorder(Color.decode("#1e90ff")));
        topSectionPanel.setBackground(Color.decode("#1e90ff"));
        managementPanel.setBorder( new LineBorder(Color.decode("#1e90ff")));
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder( new LineBorder(Color.decode("#1e90ff")));
        patientRecordsLabel.setForeground(Color.WHITE);
        
        sortButton.setBounds(100,10,100,30);
        editButton.setBounds(220,10,100,30);
        deleteButton.setBounds(340,10,100,30);
        
        managementPanel.setBackground(Color.white);
        
        sortButton.setBackground(Color.decode("#1e90ff"));
        sortButton.setForeground(Color.WHITE);
        editButton.setBackground(Color.decode("#1e90ff"));
        editButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.red);
        editButton.setForeground(Color.WHITE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        managementPanel.add(sortButton);
        managementPanel.add(editButton);
        managementPanel.add(deleteButton);
        topSectionPanel.add(patientRecordsLabel);
        
        add(topSectionPanel);
        add(managementPanel);
        add(scrollPane);
        
    }
    
    public static DefaultTableModel buildtableModel(ResultSet resultSet) throws SQLException {
        
        ResultSetMetaData metaData = resultSet.getMetaData();
        
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
            
        }
        
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }
        
        return new DefaultTableModel(data, columnNames);
        
    }
    
    private static JTable createView() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollSystem", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("select firstName,lastname,EmployeeEmail from employeebasicdetails;");

            patientRecordsTable = new JTable(buildtableModel(resultSet));
            UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            defaults.put("Table.alternateRowColor", Color.decode("#f5f5f5"));
            patientRecordsTable.setSelectionBackground(Color.decode("#1e90ff"));
            patientRecordsTable.setSelectionForeground(Color.WHITE);
            patientRecordsTable.setRowHeight(30);
            patientRecordsTable.setBackground(Color.WHITE);
            patientRecordsTable.setShowGrid(false);
            patientRecordsTable.setFont(new Font("calibri", Font.PLAIN, 16));
            resultSet.close();
            newTable = patientRecordsTable;

        } catch (SQLException | HeadlessException exc) {
            JOptionPane.showMessageDialog(null, exc);
        }
        return newTable;
    }
    
}

