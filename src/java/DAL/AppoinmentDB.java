/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import hastane.Appoinment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author hasangenc
 */
public class AppoinmentDB extends Database {

    public static ArrayList<hastane.Doctor> getDoctors() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("SELECT * FROM doctors")) {

            ResultSet rs = st.executeQuery();

            ArrayList<hastane.Doctor> doctor = new ArrayList<hastane.Doctor>();

            while (rs.next()) {
                hastane.Doctor tmp = new hastane.Doctor();
                tmp.setFirstName(rs.getString("first_name"));
                tmp.setLastName(rs.getString("second_name"));
                tmp.setId(rs.getInt("id"));
                System.out.println("DOCTOR:" + tmp.getFirstName());
                doctor.add(tmp);
            }

            return doctor;

        } catch (SQLException e) {
            return null;

        }
    }

    public static ArrayList<hastane.AppList> getAppoinments() {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement(
                        "select t1.date, t1.clock, t2.firstname as usrfn, t2.lastname as usrln, t3.first_name as drfn, t3.second_name as drln\n"
                        + "from appoinments t1 inner join users t2 on t1.user_id = t2.id\n"
                        + "inner join doctors t3 on t1.doctor_id=t3.id")) {

            ResultSet rs = st.executeQuery();

            ArrayList<hastane.AppList> appList = new ArrayList<hastane.AppList>();
            
            while (rs.next()) {
                hastane.AppList tmp = new hastane.AppList();
                tmp.setUserFirstName(rs.getString("usrfn"));
                tmp.setUserLastName(rs.getString("usrln"));
                tmp.setDoctorFirstName(rs.getString("drfn"));
                tmp.setDoctorLastName(rs.getString("drln"));
                tmp.setClock(rs.getString("clock"));
                tmp.setDate(rs.getDate("date").toString());
                appList.add(tmp);
            }

            return appList;

        } catch (SQLException e) {
            return null;

        }
    }

    public static boolean save(Appoinment app) throws ParseException {
        try (
                Connection connection = DriverManager.getConnection(uri, user_name, pass);
                PreparedStatement st = connection.prepareStatement("INSERT INTO appoinments (user_id, doctor_id, date, clock) VALUES (?, ?, ?, ?)")) {

            System.out.println(app.getUserId());

            st.setInt(1, app.getUserId());
            st.setInt(2, app.getDoctorId());

            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            java.util.Date dateString = format.parse(app.getDate());
            java.sql.Date date = new java.sql.Date(dateString.getTime());
            System.out.println(date);
            st.setDate(3, date);

            st.setString(4, app.getClock());
            ResultSet rs = st.executeQuery();
            System.out.println("kayıt");

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;

        }
    }
}
