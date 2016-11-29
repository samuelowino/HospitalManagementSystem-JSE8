/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab;

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
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author HACKER
 */
public class LabRequestForm extends JPanel {

    private static JLabel firstNameLabel;
    private static JLabel lastNameLabel;
    private static JLabel sampleTypeLabel;
    private static JLabel testTypeLabel;
    private static JLabel addressLabel;
    private static JLabel dateOfBirthLabel;
    private static JButton submitButton;
    private static JPanel patientDetailsPanel;
    private static JPanel examinationRequestedPanel;
    private static JPanel resultsPanel;
    private static JTextArea testResultArea;

    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextField testTypeField;
    private static JTextField sampleTypeField;
    private static JTextField addressField;
    private static JTextField dateOfBirthField;

    /**
     * Lab tests
     */
    private static JRadioButton G2000;
    private static JRadioButton GTI;
    private static JRadioButton GT9;
    private static JRadioButton NEO;
    private static JRadioButton CEA;
    private static JRadioButton CA1;
    private static JRadioButton CA5;
    private static JRadioButton Glucose;
    private static JRadioButton UricAcid;
    private static JRadioButton HBA1c;
    private static JRadioButton HBsAg;
    private static JRadioButton HPyloric;
    private static JRadioButton FreeT4;
    private static JRadioButton FBE;
    private static JRadioButton FBC;
    private static JRadioButton TWDC;
    private static JRadioButton RPR;
    private static JRadioButton AFB;
    private static JRadioButton ABO;
    private static JRadioButton Histology;
    private static ButtonGroup buttonGroup;

    public LabRequestForm() {

        setSize(1000, 765);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        buttonGroup = new ButtonGroup();

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        sampleTypeField = new JTextField();
        testTypeField = new JTextField();
        addressField = new JTextField();
        dateOfBirthField = new JTextField();
        patientDetailsPanel = new JPanel(null);
        examinationRequestedPanel = new JPanel(new GridLayout(5,3,3,3));
        resultsPanel = new JPanel(null);
        testResultArea = new JTextArea();
        
        G2000 = new JRadioButton("G2000");
        GT9 = new JRadioButton("GT9");
        GTI = new JRadioButton("GTI");
        Glucose = new JRadioButton("Glucose");
        NEO = new JRadioButton("NEO");
        CEA = new JRadioButton("CEA");
        CA1 = new JRadioButton("CA1");
        CA5 = new JRadioButton("CA5");
        HBA1c = new JRadioButton("HBA 1c");
        HBsAg = new JRadioButton("HBsAg");
        HPyloric = new JRadioButton("H.Pyloric");
        UricAcid = new JRadioButton("Uric Acid");
        FreeT4 = new JRadioButton("Free T4");
        FBE = new JRadioButton("RBE");
        FBC = new JRadioButton("FBC");
        
        buttonGroup.add(G2000);
        buttonGroup.add(GT9);
        buttonGroup.add(GTI);
        buttonGroup.add(Glucose);
        buttonGroup.add(NEO);
        buttonGroup.add(CEA);
        buttonGroup.add(CA1);
        buttonGroup.add(CA5);
        buttonGroup.add(HBA1c);
        buttonGroup.add(HBsAg);
        buttonGroup.add(HPyloric);
        buttonGroup.add(UricAcid);
        buttonGroup.add(FreeT4);
        buttonGroup.add(FBC);
        buttonGroup.add(FBE);
        

        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        testTypeLabel = new JLabel("Test Type:");
        sampleTypeLabel = new JLabel("Sample Type:");
        addressLabel = new JLabel("Address:");
        dateOfBirthLabel = new JLabel("Date of Birth:");
        submitButton = new JButton("Submit");

        firstNameLabel.setBounds(30, 30, 100, 25);
        firstNameField.setBounds(140, 30, 200, 25);
        lastNameLabel.setBounds(30, 70, 100, 25);
        lastNameField.setBounds(140, 70, 200, 25);
        testTypeLabel.setBounds(30, 100, 100, 25);
        sampleTypeField.setBounds(140, 100, 200, 25);
        sampleTypeLabel.setBounds(30, 130, 130, 25);
        testTypeField.setBounds(140, 130, 200, 25);
        addressLabel.setBounds(30, 160, 100, 25);
        addressField.setBounds(140, 160, 200, 25);
        submitButton.setBounds(450, 390, 110, 30);

        patientDetailsPanel.setBounds(10, 10, 390, 200);
        patientDetailsPanel.setBackground(Color.decode("#f5f5f5"));
        patientDetailsPanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#1e90ff")), "Patient Details"));

        examinationRequestedPanel.setBounds(10, 220, 390, 200);
        examinationRequestedPanel.setBackground(Color.decode("#f5f5f5"));
        examinationRequestedPanel.setBorder(new TitledBorder(
                new LineBorder(Color.decode("#1e90ff")), "Examination(s) Requested"));
        
        examinationRequestedPanel.add(G2000);
        examinationRequestedPanel.add(GT9);
        examinationRequestedPanel.add(GTI);
        examinationRequestedPanel.add(Glucose);
        examinationRequestedPanel.add(NEO);
        examinationRequestedPanel.add(CEA);
        examinationRequestedPanel.add(CA1);
        examinationRequestedPanel.add(CA5);
        examinationRequestedPanel.add(HBsAg);
        examinationRequestedPanel.add(HPyloric);
        examinationRequestedPanel.add(UricAcid);
        examinationRequestedPanel.add(FreeT4);
        examinationRequestedPanel.add(FBE);
        examinationRequestedPanel.add(FBC);

        resultsPanel.setBounds(10, 440, 600, 120);
        resultsPanel.setBackground(Color.white);
        resultsPanel.setBorder(new TitledBorder(
                new LineBorder(Color.decode("#1e90ff")), "Test Results:"));
        testResultArea.setBounds(10, 20, 580, 95);
        resultsPanel.add(testResultArea);

        submitButton.setBackground(Color.decode("#1e90ff"));
        submitButton.setBorder(new LineBorder(Color.decode("#1e90ff")));
        submitButton.setForeground(Color.white);

        List<JLabel> labels = Arrays.asList(firstNameLabel, lastNameLabel,
                testTypeLabel, sampleTypeLabel, addressLabel, dateOfBirthLabel);
        List<JTextField> textFields = Arrays.asList(firstNameField, lastNameField,
                sampleTypeField, testTypeField, addressField, dateOfBirthField);
        setLabelProperties(labels);
        setFieldProperties(textFields);
        
        
        submitButton.addActionListener(e -> {
            
            String selection = "";
            
            if(buttonGroup.isSelected(G2000.getModel())){
                System.err.println("G2000");
                selection = "G2000";
            }else if(buttonGroup.isSelected(GT9.getModel())){
                System.err.println("GT9");
                selection = "GT9";
            }else if(buttonGroup.isSelected(GTI.getModel())){
                System.err.println("GTI");
                selection = "GTI";
            }else if(buttonGroup.isSelected(Glucose.getModel())){
                System.err.println("Glucose");
                selection = "Glucose";
            }else if(buttonGroup.isSelected(NEO.getModel())){
                System.err.println("NEO");
                selection = "NEO";
            }else if(buttonGroup.isSelected(CEA.getModel())){
                System.err.println("CEA");
                selection = "CEA";
            }else if(buttonGroup.isSelected(CA1.getModel())){
                System.err.println("CA1");
                selection = "CA1";
            }else if(buttonGroup.isSelected(CA5.getModel())){
                System.err.println("CA5");
                selection = "CA5";
            }else if(buttonGroup.isSelected(HBsAg.getModel())){
                System.err.println("HBsAg");
                selection = "HBsAg";
            }else if(buttonGroup.isSelected(HPyloric.getModel())){
                System.err.println("HPyloric");
                selection = "HPyloric";
            }else if(buttonGroup.isSelected(FreeT4.getModel())){
                System.err.println("FreeT4");
                selection = "FreeT4";
            }else if(buttonGroup.isSelected(FBE.getModel())){
                System.err.println("FBE");
                selection = "FBE";
            }else if(buttonGroup.isSelected(FBC.getModel())){
                System.err.println("FBC");
                selection = "FBC";
            }else {
            
            }
            
            
            DatabaseAccessObjects.LaboratoryDaos.registerANewLabTest(
            sampleTypeField.getText(),
            firstNameField.getText(),
            lastNameField.getText(),
            selection,
            testResultArea.getText());
        });

        add(submitButton);
        add(patientDetailsPanel);
        add(examinationRequestedPanel);
        add(resultsPanel);

        repaint();
        setVisible(true);
    }

    public final void setFieldProperties(List<JTextField> labels) {
        labels.forEach(e -> {
            e.setForeground(Color.black);
            e.setFont(new Font("Calibri", Font.BOLD, 18));
            e.setBorder(new LineBorder(Color.decode("#f5f5f5")));
            e.addFocusListener(
                    new FocusListener() {
                @Override
                public void focusGained(FocusEvent event) {
                    e.setBorder(new LineBorder(Color.decode("#1e90ff")));
                }

                @Override
                public void focusLost(FocusEvent event) {
                    e.setBorder(new LineBorder(Color.decode("#f5f5f5")));
                }
            }
            );
            patientDetailsPanel.add(e);
        });
    }

    public final void setLabelProperties(List<JLabel> labels) {
        labels.forEach(e -> {
            e.setForeground(Color.black);
            e.setFont(new Font("Calibri", Font.BOLD, 18));
            patientDetailsPanel.add(e);
        });
    }

}
