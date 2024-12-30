import java.sql.*;
class insertjdbc
{
    public static void main(String args[])
    {
        try
        {
            //load the driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url="jdbc:mysql://localhost:3306/youtube";
            String username="root";
            String password="1235";
            Connection con=DriverManager.getConnection(url,username,password);

            //create a query
            String q="create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";

            //create a statement
            Statement stmt=con.createStatement();
            stmt.executeUpdate(q); //fire query
            System.out.println("Tabel created in database...");
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}