/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Districttb;
import entities.Statetb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author ompan
 */
@Named(value = "districtBean")
@SessionScoped
public class DistrictBean implements Serializable {
    @EJB AdminLocal adl;
    Collection<Districttb> districts;
    int districtid;
    int stateid;
    String districtname;
    Collection<Statetb> states;
    Districttb current;

    public int getDistrictid() {
        return districtid;
    }

    public void setDistrictid(int districtid) {
        this.districtid = districtid;
    }

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public Collection<Statetb> getStates() {
        states = adl.getAllStates();
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }
    
    
    
    
    public Collection<Districttb> getDistricts() {
        districts = adl.getAllDistricts();
        return districts;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public Districttb getCurrent() {
        return current;
    }

    public void setCurrent(Districttb current) {
        this.current = current;
    }
    
    
    
    
    public String addDistrict()
    {
        adl.addDistricts(stateid, districtname);
        return "DistrictOperation";
    }
    
    public String deleteDistrict(Districttb district)
    {
        current = district;
        districtid = current.getDistrictId();
        System.out.println("district id = " + districtid);
        adl.deleteDistrict(districtid);
        return "DistrictOperation";
    }
    
    
    public String updateDistrict()
    {
        districtid  = current.getDistrictId();
        stateid = current.getStateId().getStateId();
        districtname = current.getDistrictName();
//        System.out.println(districtid + " " + stateid  + " " + districtname);
        adl.updateDistrict(districtid, stateid, districtname);
        return "DistrictOperation.jsf";
    }
    
    public String redirectToedit()
    {
        return "updateDistrict.jsf";
    }
    
    public DistrictBean() {
    }
    
}
