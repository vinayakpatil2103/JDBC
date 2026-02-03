package com.vinu;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
        String url ="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password = "Enter Password ";
        String query="select * from employees;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con =DriverManager.getConnection(url, username,password);
            System.out.println("Connection establish successfully.");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                Double salary =rs.getDouble("salary");
                
                System.out.println();
                System.out.println("==========================");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("job_title : "+job_title);
                System.out.println("salary : "+salary);
                }
            
            rs.close();
            stmt.xc();
            con.close();
            System.out.println("Connection closed successfully");
         }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
