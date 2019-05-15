package DAL;

import hastane.AppList;
import hastane.Doctor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User extends Database {

    public static ArrayList<hastane.User> getAllUsers() {

        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT * FROM users")) {

            ResultSet rs = st.executeQuery();

            ArrayList<hastane.User> users = new ArrayList<hastane.User>();

            int size = 0;
            while (rs.next()) {
                size += 1;
                hastane.User user = new hastane.User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setTcid(rs.getString("tcid"));
                user.setAdmin(rs.getBoolean("admin"));
                users.add(user);
            }

            return users;

        } catch (SQLException e) {

            return null;
        }
    }

    public static int getUserCount() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT COUNT(*) AS total FROM users")) {

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }

            return 0;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ArrayList<Doctor> getAllDoctors() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT * FROM doctors")) {

            ResultSet rs = st.executeQuery();

            ArrayList<hastane.Doctor> doctors = new ArrayList<hastane.Doctor>();

            while (rs.next()) {
                hastane.Doctor doc = new hastane.Doctor();
                doc.setId(rs.getInt("id"));
                doc.setFirstName(rs.getString("first_name"));
                doc.setLastName(rs.getString("second_name"));

                doctors.add(doc);
            }

            return doctors;

        } catch (SQLException e) {

            return null;
        }
    }

    public static int getDoctorCount() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT COUNT(*) AS total FROM doctors")) {

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }

            return 0;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public static boolean saveUser(hastane.User user) {
        hastane.User isMember = User.checkUser(user);

        if (isMember != null) {
            return false;
        }

        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("INSERT INTO users (firstname, lastname, password, email, phone, tcid) VALUES (?, ?, ?, ?, ?, ?)")) {
            st.setString(1, user.getFirstname());
            st.setString(2, user.getLastname());
            st.setString(3, User.hash(user.getPassword()));
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

    public static hastane.User checkUser(hastane.User user) {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE email=?")) {
            st.setString(1, user.getEmail());
            ResultSet rs = st.executeQuery();

            int size = 0;
            while (rs.next()) {
                size += 1;
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(User.hash(rs.getString("password")));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setTcid(rs.getString("tcid"));

            }

            if (size > 0) {
                return user;
            }

            return null;

        } catch (SQLException e) {
            System.out.println("checkUser Hatası");
            return null;
        }
    }

    public static hastane.User getUser(hastane.User user) {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=? LIMIT 1")) {
            st.setString(1, user.getEmail());
            st.setString(2, User.hash(user.getPassword()));
            ResultSet rs = st.executeQuery();

            int size = 0;
            while (rs.next()) {
                size += 1;
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setTcid(rs.getString("tcid"));
                user.setAdmin(rs.getBoolean("admin"));
            }

            if (size > 0) {
                return user;
            }

            return new hastane.User();

        } catch (SQLException e) {

            return null;
        }
    }

    public static String hash(String pass) {
        int hash = 0;
        for (int i = 0; i < pass.length(); i++) {
            hash = 32 * hash + pass.charAt(i);
        }
        return Integer.toString(hash);
    }

    public static boolean addDoctor(Doctor doctor) {

        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("INSERT INTO doctors (first_name, second_name) VALUES (?, ?)")) {
            st.setString(1, doctor.getFirstName());
            st.setString(2, doctor.getLastName());

            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean deleteDoctor(Doctor doctor) {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("DELETE FROM doctors WHERE id = ?")) {
            System.out.println(doctor.getId());
            st.setInt(1, doctor.getId());
            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean updateDoctor(Doctor doctor) {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("UPDATE doctors set first_name = ? second_name = ?  WHERE id = ?")) {
            st.setString(1, doctor.getFirstName());
            st.setString(2, doctor.getLastName());
            st.setInt(3, doctor.getId());
            st.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}
