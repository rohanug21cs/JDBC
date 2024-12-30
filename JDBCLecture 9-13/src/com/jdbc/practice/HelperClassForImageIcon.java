/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;
import java.sql.Blob;
import java.awt.Image;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

/**
 *
 * @author Rohan Choudhary
 */

//the image icon returned from this class will be used to set to the label of DisplayImage
public class HelperClassForImageIcon {
    public static ImageIcon getImageIconById(int id, Connection con)
    {
        ImageIcon icon=null;
        try
        {
            String q="select pic from images where id=?"; //creating a query to fire
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setInt(1,id);
            ResultSet  set=pstmt.executeQuery();
            if(set.next())
            {
                Blob b=set.getBlob("pic");
                InputStream is=b.getBinaryStream();
                Image image=ImageIO.read(is); // read method read the data from input stream to make image.
                icon=new ImageIcon(image);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return icon;
    }         
}
