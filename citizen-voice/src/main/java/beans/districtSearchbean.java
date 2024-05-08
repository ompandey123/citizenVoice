/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Districttb;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author ompan
 */
@Named(value = "districtSearchbean")
@SessionScoped

public class districtSearchbean implements Serializable {
    @EJB AdminLocal admin;
    int state;
    
    Collection<Districttb> districts;

    /**
     * Creates a new instance of districtSearchbean
     */
    public districtSearchbean() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Collection<Districttb> getDistricts() {
        districts = admin.getDistrictByState(state);
        return districts;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }
    
    public String redToRep()
    {
        System.out.println(state);
        return "report.jsf";
    }
    
}
