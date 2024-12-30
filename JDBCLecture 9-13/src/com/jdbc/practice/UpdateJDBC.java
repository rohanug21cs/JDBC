/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.practice;



import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
/**
 *
 * @author Rohan Choudhary
 */
public class UpdateJDBC {
    public static void main(String[] args) {
        try {
            //create connection to the database
            Connection c=connectionProvider.getConnection();
            //write the update query
            String q="update table1 set tName=?, tCity=? where tId=?";
            // to take the value of ?
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new name: ");
            String name=br.readLine();
            
            System.out.println("Enter new city: ");
            String city=br.readLine();
            
            System.out.println("Enter ID: ");
            int id=Integer.parseInt(br.readLine());
            
            //create a prepared statement using this query
            PreparedStatement pstmt=c.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Done...");
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
