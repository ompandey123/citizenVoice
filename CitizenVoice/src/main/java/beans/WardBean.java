/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
import ejb.AdminLocal;
import entities.Citytb;
import entities.Districttb;
import entities.Statetb;
import entities.Wardtb;
import entities.Zonetb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ompan
 */
@Named(value = "wardBean")
@SessionScoped
public class WardBean implements Serializable {
    
    @EJB AdminLocal adl;
    
    AdminClient ac;
    Response rs;
    
    int stateid;
    int districtid;
    int cityid;
    int zoneid;
    int wardid;
    String wardname;
    Collection<Wardtb> wards;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Citytb> cities;
    Collection<Zonetb> zones;
    GenericType<Collection<Districttb>> gdistricts;
    GenericType<Collection<Statetb>> gstates;
    GenericType<Collection<Citytb>> gcities;
    GenericType<Collection<Zonetb>> gzones;
    GenericType<Collection<Wardtb>> gwards;
    Wardtb current;
    Statetb selectedState;

    public Statetb getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(Statetb selectedState) {
        this.selectedState = selectedState;
    }

    
    
    
    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public int getDistrictid() {
        return districtid;
    }

    public void setDistrictid(int districtid) {
        this.districtid = districtid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getWardid() {
        return wardid;
    }

    public void setWardid(int wardid) {
        this.wardid = wardid;
    }

    public String getWardname() {
        return wardname;
    }

    public void setWardname(String wardname) {
        this.wardname = wardname;
    }

    public Collection<Wardtb> getWards() {
        rs = ac.getAllWards(Response.class);
        wards = rs.readEntity(gwards);
        return wards;
    }

    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
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
        if(stateid != 0)
        {
             rs = ac.getDistrictByState(Response.class, String.valueOf(stateid));
             districts = rs.readEntity(gdistricts);
             return districts;
        }
        return null;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public Collection<Citytb> getCities() {
        if(districtid != 0)
        {
             rs = ac.getCitiesByDistrict(Response.class, String.valueOf(districtid));
            cities = rs.readEntity(gcities);
            return cities;
        }
        return null;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        if(cityid != 0)
        {
            rs = ac.getZonesByCity(Response.class, String.valueOf(cityid));
            zones = rs.readEntity(gzones);
            return zones;
        }
        return null;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Wardtb getCurrent() {
        return current;
    }

    /**
     * Creates a new instance of WardBean
     */
    
    public void setCurrent(Wardtb current) {
        this.current = current;
    }
    
    public String addWard()
    {
        ac.addWard(String.valueOf(zoneid), wardname);
        return "WardOperation.jsf";
    }
    
    public String deleteWard()
    {
        wardid = current.getWardId();
        ac.deleteWard(String.valueOf(wardid));
        return "WardOperation.jsf";
    }

    
    public String redirectToEdit()
    {
        return "updateWard.jsf";
    }
    
    public String updateWard()
    {
        wardid = current.getWardId();
        zoneid = current.getZoneId().getZoneId();
        wardname = current.getWardName();
        ac.updateWard(String.valueOf(wardid), String.valueOf(zoneid), wardname);
        return "WardOperation.jsf";
    }
    
    public WardBean() {
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        cities = new ArrayList<>();
        zones = new ArrayList<>();
        wards = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gcities = new GenericType<Collection<Citytb>>(){};
        gzones = new GenericType<Collection<Zonetb>>(){};
        gwards = new GenericType<Collection<Wardtb>>(){};
    }
    
}
