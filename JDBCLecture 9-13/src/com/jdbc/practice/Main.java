/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Rohan Choudhary
 */
public class Main {
    public static void main(String[] args) {
        try {
            Connection c=connectionProvider.getConnection();
            String q="insert into images(pic) values(?)";
            PreparedStatement pstmt=c.prepareStatement(q);
            
            //selecting file through dialog box
            JFileChooser jfc=new JFileChooser();
            jfc.showOpenDialog(null);
            File file=jfc.getSelectedFile();
            //creating file stream object
            FileInputStream fis=new FileInputStream(file);
            pstmt.setBinaryStream(1,fis,fis.available());
            pstmt.executeUpdate();
            System.out.println("Done...");
            //showing message in GUI form
            JOptionPane.showMessageDialog(null, "success");
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
