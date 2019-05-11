/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.uri;
import hastane.Visit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author hasangenc
 */
public class Visits extends Database {

    public static ArrayList<Visit> getAll() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT * FROM visits ORDER BY DATE DESC")) {

            ResultSet rs = st.executeQuery();

            ArrayList<hastane.Visit> visits = new ArrayList<>();

            while (rs.next()) {
                hastane.Visit visit = new hastane.Visit();
                visit.setUrl(rs.getString("url"));
                
                Date date = rs.getDate("date");
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                String strDate = df.format(date);
                visit.setDate(strDate);
                
                visits.add(visit);
            }

            return visits;

        } catch (SQLException e) {

            return null;
        }
    }

    public static int getCount() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT COUNT(*) AS total FROM visits")) {

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
    
    public static void visited(String url) {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("INSERT INTO visits (url) VALUES (?)")) {
            
            st.setString(1, url);
            st.executeUpdate();

            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
