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
@Named(value = "zoneBean")
@SessionScoped
public class ZoneBean implements Serializable {
    @EJB AdminLocal adl;
    
    AdminClient ac;
    Response rs;
    
    int zoneid;
    int cityid;
    int districtid;
    int stateid;
    String zonename;
    Collection<Zonetb> zones;
    Collection<Citytb> cities;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    
    GenericType<Collection<Districttb>> gdistricts;
    GenericType<Collection<Statetb>> gstates;
    GenericType<Collection<Citytb>> gcities;
    GenericType<Collection<Zonetb>> gzones;
    Zonetb current;

    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    public Collection<Zonetb> getZones() {
        rs = ac.getAllZones(Response.class);
        zones = rs.readEntity(gzones);
        return zones;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Zonetb getCurrent() {
        return current;
    }

    public void setCurrent(Zonetb current) {
        this.current = current;
    }

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

    public Collection<Citytb> getCities() {
        if(districtid != 0)
        {
            rs = ac.getCitiesByDistrict(Response.class, String.valueOf(districtid));
            cities = rs.readEntity(gcities);
            return cities;
        }
        return cities;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
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
    
    
    public String addZone()
    {
        ac.addZone(String.valueOf(cityid), zonename);
        return "ZoneOperation.jsf";
    }
    
    public String deleteZone(Zonetb zone)
    {
        current = zone;
        zoneid = current.getZoneId();
        ac.deleteZone(String.valueOf(zoneid));
        return "ZoneOperation.jsf";
    }
    
    public String redirectToEdit()
    {
        return "updateZone.jsf";
    }
    
    public String updateZone()
    {
        zoneid = current.getZoneId();
        cityid = current.getCityId().getCityId();
        zonename = current.getZoneName();
        System.out.println("zonename" + zonename);
        ac.updateZone(String.valueOf(zoneid), String.valueOf(cityid), zonename);
        return "ZoneOperation.jsf";
    }
    
    /**
     * Creates a new instance of ZoneBean
     */
    public ZoneBean() {
        ac = new AdminClient();
         states = new ArrayList<>();
        districts = new ArrayList<>();
        cities = new ArrayList<>();
        zones = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gcities = new GenericType<Collection<Citytb>>(){};
        gzones = new GenericType<Collection<Zonetb>>(){};
    }
    
}
