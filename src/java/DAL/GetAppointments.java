package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAppointments extends Database {
    
    public GetAppointments() {
        try (Connection connection = DriverManager.getConnection(uri, user, pass)) {
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM appoinments;");
            
            while (resultSet.next()) {
                System.out.println("Sonuc:" +resultSet.getString("first_name"));
            }
 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main (String args []) {
        Database app = new GetAppointments();
    }
}
