/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Reception.ReceptionManagementTab;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HACKER
 */
public class HomeScreen extends JPanel {
    
    private static JLabel backgroundImageLabel;
    private static BufferedImage image;
    private static JLabel productNameLabel;
    private static JLabel upperSectionLabel;
    private static JButton quickStartButton;
    
    public HomeScreen(){
        setSize(700, 700);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        
        quickStartButton = new JButton("QUCIK START");
        image = getBufferedImage("/appimages/hospital.jpg");
        backgroundImageLabel = new JLabel( new ImageIcon(image));
        backgroundImageLabel.setBounds(0,0,800,800);
        upperSectionLabel = new JLabel("ALPHA MED.");
        upperSectionLabel.setBounds(230,150,800,30);
        upperSectionLabel.setForeground(Color.white);
        upperSectionLabel.setFont( new Font("Calibri",Font.BOLD,36));
        productNameLabel = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        productNameLabel.setBounds(80,250,800,30);
        productNameLabel.setFont( new Font("Calibri",Font.BOLD,36));
        productNameLabel.setForeground(Color.WHITE);
        quickStartButton.setForeground(Color.WHITE);
        quickStartButton.setBackground(Color.decode("#1e90ff"));
        quickStartButton.setBounds(250,330,150,30);
        quickStartButton.addActionListener(e -> {
            SkeletonView.replaceRightPanel( new ReceptionManagementTab());
        });
        
        add(productNameLabel);
        add(upperSectionLabel);
        add(quickStartButton);
        add(backgroundImageLabel);
        
        repaint();
    }
    
    public final BufferedImage getBufferedImage(String imageUrl){
        try{
            BufferedImage bufferedImage = null;
            bufferedImage = ImageIO.read(getClass().getResource(imageUrl));
            return bufferedImage;
        
        }catch(IOException ex){
            ex.printStackTrace();
            return new BufferedImage(0,0,0);
        }
    }
    
}
