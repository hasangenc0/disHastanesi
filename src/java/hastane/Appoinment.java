package hastane;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import DAL.AppoinmentDB;
import java.text.ParseException;
import java.util.ArrayList;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author hasangenc
 */
@ManagedBean(name = "appoinment", eager = true)
@RequestScoped
public class Appoinment {
    
    @ManagedProperty(value="#{signin}")
    private signin signin;
    private ArrayList<hastane.AppList> appList;
    private ArrayList<hastane.Doctor> doctors;
    private int userId;
    private int doctorId;
    private String date;
    private String clock;
    private ArrayList<String> availableClocks = new ArrayList<String>();
    
    public Appoinment() {
        availableClocks.add("09.00");
        availableClocks.add("10.00");
        availableClocks.add("11.00");
        availableClocks.add("12.00");
        availableClocks.add("14.00");
        availableClocks.add("15.00");
        availableClocks.add("16.00");
    }

    public void submit() throws ParseException {
        AppoinmentDB.save(this);
    }
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the clock
     */
    public String getClock() {
        return clock;
    }

    /**
     * @param clock the clock to set
     */
    public void setClock(String clock) {
        this.clock = clock;
    }

    /**
     * @return the doctors
     */
    public ArrayList<hastane.Doctor> getDoctors() {
        this.setDoctors(AppoinmentDB.getDoctors());
        return doctors;
    }

    /**
     * @param doctors the doctor to set
     */
    public void setDoctors(ArrayList<hastane.Doctor> doctors) {
        this.doctors = doctors;
    }

    /**
     * @return the doctorId
     */
    public int getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * @return the availableClocks
     */
    public ArrayList<String> getAvailableClocks() {
        return availableClocks;
    }

    /**
     * @param availableClocks the availableClocks to set
     */
    public void setAvailableClocks(ArrayList<String> availableClocks) {
        this.availableClocks = availableClocks;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return getSignin().user.getId();
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the signin
     */
    public signin getSignin() {
        return signin;
    }

    /**
     * @param signin the signin to set
     */
    public void setSignin(signin signin) {
        this.signin = signin;
    }

    /**
     * @return the appList
     */
    public ArrayList<hastane.AppList> getAppList() {
        return DAL.AppoinmentDB.getAppoinments();
    }

    /**
     * @param appList the appList to set
     */
    public void setAppList(ArrayList<hastane.AppList> appList) {
        this.appList = appList;
    }

    
}
