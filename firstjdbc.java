import java.sql.*;
class firstjdbc{
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

            if(con.isClosed())
            {
                System.out.println("Connection is closed");
            }
            else
            {
                System.out.println("Connection created");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}