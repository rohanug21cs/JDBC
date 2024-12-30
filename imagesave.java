import java.sql.*;
import java.io.*;
class imagesave
{
    public static void main(String args[])
    {
        try{
            //load the driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url="jdbc:mysql://localhost:3306/youtube";
            String username="root";
            String password="1235";
            Connection con=DriverManager.getConnection(url,username,password);

            //create query
            String q="insert into images(pic) values(?)";
            //give this query to prepared statement
            PreparedStatement pstmt=con.prepareStatement(q);
            FileInputStream fis=new FileInputStream("C:/Users/Rohan kumar/Desktop/logo.png");
            pstmt.setBinaryStream(1,fis, fis.available());
            pstmt.executeUpdate();
            System.out.println("Done....");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}