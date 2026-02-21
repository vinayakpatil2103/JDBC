import java.io.*;
import java.sql.*;
import java.util.ResourceBundle;

public class imageData {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Vinayak@102711";
        String folder_path="C:\\Users\\VINAYAK PATIL\\Downloads\\";
        String query="SELECT image_data from image_table where image_id=(?)";
//        String image_path="C:\\Users\\VINAYAK PATIL\\Downloads\\lnkedin.png";
//        String query= "INSERT INTO image_table(image_data) VALUES(?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully !");
           PreparedStatement preparedStatement=con.prepareStatement(query);
           preparedStatement.setInt(1,1);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                byte[] image_data=resultSet.getBytes("image_data");
                String image_path=folder_path+"extractedImage.jpg";
                OutputStream outputStream=new FileOutputStream(image_path);
                outputStream.write(image_data);

            }else {
                System.out.println("Image Not found");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





//        try{
//                Connection con= DriverManager.getConnection(url,username,password);
//                System.out.println("Connection Established successfully !");
//                FileInputStream fileInputStream=new FileInputStream(image_path);
//                byte[] imageData=new byte[fileInputStream.available()];
//                fileInputStream.read(imageData);
//                PreparedStatement preparedStatement=con.prepareStatement(query);
//                preparedStatement.setBytes(1,imageData);
//                int affectedRows=preparedStatement.executeUpdate();
//                if(affectedRows>0){
//                System.out.println("Image inserted Successfully !!");
//                }else {
//                System.out.println("Image Not Inserted !!");
//                }
//
//                }catch (SQLException e){
//                System.out.println(e.getMessage());
//                } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                } catch (IOException e) {
//                e.printStackTrace();
//                }
