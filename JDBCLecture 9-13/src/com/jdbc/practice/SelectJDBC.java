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
public class SelectJDBC {
    public static void main(String[] args) {
        try {
            Connection con=connectionProvider.getConnection();
            String q="select * from table1";
            Statement stmt=con.createStatement();
            ResultSet set=stmt.executeQuery(q); // the returned query is ResultSet which is a table like structure, and the cursor is pointing just before the first row.
            // so we need to iterate row by row
            while(set.next()) // if next row is available then return true and make cursor forward a row.
            {
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);
                System.out.println(id + " : " + name + " : " + city);
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
