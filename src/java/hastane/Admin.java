/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastane;

import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author hasangenc
 */
@ManagedBean(name = "admin", eager = true)
@RequestScoped
public class Admin {

    public ArrayList<hastane.User> allUsers;
    public ArrayList<hastane.Doctor> allDoctors;
    public hastane.Doctor doctor = new hastane.Doctor();
    public ArrayList<hastane.AppList> allApps;
    private ArrayList<hastane.Visit> allVisits;
    private int visitCount;
    public int appCount;
    public int doctorCount;
    public int userCount;

    /**
     * @return the allVisits
     */
    public ArrayList<hastane.Visit> getAllVisits() {
        return DAL.Visits.getAll();
    }

    /**
     * @param allVisits the allVisits to set
     */
    public void setAllVisits(ArrayList<hastane.Visit> allVisits) {
        this.allVisits = allVisits;
    }

    /**
     * @return the visitCount
     */
    public int getVisitCount() {
        return DAL.Visits.getCount();
    }

    /**
     * @param visitCount the visitCount to set
     */
    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    /**
     * @return the allApps
     */
    public ArrayList<hastane.AppList> getAllApps() {
        return DAL.AppoinmentDB.getAllApps();
    }

    /**
     * @param allApps the allApps to set
     */
    public void setAllApps(ArrayList<hastane.AppList> allApps) {
        this.allApps = allApps;
    }

    /**
     * @return the appCount
     */
    public int getAppCount() {
        return DAL.AppoinmentDB.getAppCount();
    }

    /**
     * @param appCount the appCount to set
     */
    public void setAppCount(int appCount) {
        this.appCount = appCount;
    }

    /**
     * @return the allDoctors
     */
    public ArrayList<hastane.Doctor> getAllDoctors() {
        return DAL.User.getAllDoctors();
    }

    public boolean addDoctor() {
        return DAL.User.addDoctor(this.getDoctor());
    }

    public boolean deleteDoctor() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String id = ec.getRequestParameterMap().get("doctorId");

        this.getDoctor().setId(Integer.parseInt(id));

        return DAL.User.deleteDoctor(this.getDoctor());
    }

    /**
     * @return the doctorCount
     */
    public int getDoctorCount() {
        return DAL.User.getDoctorCount();
    }

    public int getUserCount() {
        return DAL.User.getUserCount();
    }

    public ArrayList<hastane.User> getAllUsers() {
        return DAL.User.getAllUsers();
    }

    /**
     * @return the doctor
     */
    public hastane.Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(hastane.Doctor doctor) {
        this.doctor = doctor;
    }
}
