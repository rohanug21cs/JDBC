/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;
import java.sql.*;
/**
 *
 * @author Rohan Choudhary
 */

public class connectionProvider {
    private static Connection con;
    
    public static Connection getConnection() // the return type is connection
    {
        try
        {
        if(con==null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","1235");
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        return con;
    }
}
