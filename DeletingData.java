import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletingData {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Vinayak@102711";
        String query = "DELETE FROM employees where id=3";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded successfully.");


        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        try {  Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully");
            Statement stmt=con.createStatement();
            int rowsAffected=stmt.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Deletion  successful "+rowsAffected+" row(s) affected");
            }else {
                System.out.println("Deletion  failed!");
            }
            con.close();
            stmt.close();
            System.out.println("Connection closed successfully");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
