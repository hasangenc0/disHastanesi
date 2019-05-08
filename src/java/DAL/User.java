package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User extends Database {

    public User() {

    }

    public static boolean saveUser(hastane.IUser user) {
        try (
            Connection connection = DriverManager.getConnection(uri, user_name, pass); 
            PreparedStatement st = connection.prepareStatement("INSERT INTO users (firstname, lastname, password, email, phone, tcid) VALUES (?, ?, ?, ?, ?, ?)")
        ) {
            st.setString(1, user.getFirstname());
            st.setString(2, user.getLastname());
            st.setString(3, user.getPassword());
            st.setObject(4, user.getEmail());
            st.setObject(5, user.getPhone());
            st.setObject(6, user.getTcid());            
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

            return false;
        }

        return true;
    }
    
    public static hastane.User getUser(hastane.User user) {
        try (
            Connection connection = DriverManager.getConnection(uri, user_name, pass); 
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=? LIMIT 1")
        ) {
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());         
            ResultSet rs = st.executeQuery();
            
             while (rs.next()) {
                 user.setFirstname(rs.getString("firstname"));
                 user.setLastname(rs.getString("lastname"));
                 user.setPassword(rs.getString("password"));
                 user.setEmail(rs.getString("email"));
                 user.setPhone(rs.getString("phone"));
                 user.setTcid(rs.getString("tcid"));
            }
             
            return user;

        } catch (SQLException e) {
            System.out.println(e);

            return null;
        }
    }

}
