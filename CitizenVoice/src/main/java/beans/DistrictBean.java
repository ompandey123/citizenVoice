/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
import ejb.AdminLocal;
import entities.Districttb;
import entities.Statetb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import sun.security.provider.certpath.ResponderId;

/**
 *
 * @author ompan
 */
@Named(value = "districtBean")
@SessionScoped
public class DistrictBean implements Serializable {
    @EJB AdminLocal adl;
    
    AdminClient ac;
    Response rs;
    
    int districtid;
    int stateid;
    String districtname;
    Collection<Districttb> districts;
    Collection<Statetb> states;
    GenericType<Collection<Districttb>> gdistricts;
    GenericType<Collection<Statetb>> gstates;
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
        rs = ac.getAllStates(Response.class);
        states = rs.readEntity(gstates);
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }
    
    
    
    
    public Collection<Districttb> getDistricts() {
        rs = ac.getAllDistricts(Response.class);
        districts = rs.readEntity(gdistricts);
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
        ac.addDistricts(String.valueOf(stateid), districtname);
        return "DistrictOperation";
    }
    
    public String deleteDistrict(Districttb district)
    {
        current = district;
        districtid = current.getDistrictId();
        ac.deleteDistrict(String.valueOf(districtid));
        return "DistrictOperation";
    }
    
    
    public String updateDistrict()
    {
        districtid  = current.getDistrictId();
        stateid = current.getStateId().getStateId();
        districtname = current.getDistrictName();
        ac.updateDistrict(String.valueOf(districtid), String.valueOf(stateid), districtname);
        return "DistrictOperation.jsf";
    }
    
    public String redirectToedit()
    {
        return "updateDistrict.jsf";
    }
    
    public DistrictBean() {
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
    }
    
}
