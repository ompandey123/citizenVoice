/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Citytb;
import entities.Districttb;
import entities.Statetb;
import entities.Zonetb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author ompan
 */
@Named(value = "zoneBean")
@SessionScoped
public class ZoneBean implements Serializable {
    @EJB AdminLocal adl;
    int zoneid;
    int cityid;
    int districtid;
    int stateid;
    String zonename;
    Collection<Zonetb> zones;
    Collection<Citytb> cities;
    Collection<Statetb> states;
    Collection<Districttb> districts;
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
        zones = adl.getAllZones();
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
            return adl.getCitiesByDistrict(districtid);
        }
        return cities;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Statetb> getStates() {
        states = adl.getAllStates();
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public Collection<Districttb> getDistricts() {
        if(stateid != 0)
        {
            return adl.getDistrictByState(stateid);
        }
        return null;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }
    
    
    public String addZone()
    {
        adl.addZone(cityid, zonename);
        return "ZoneOperation.jsf";
    }
    
    public String deleteZone(Zonetb zone)
    {
        current = zone;
        zoneid = current.getZoneId();
        adl.deleteZone(zoneid);
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
        adl.updateZone(zoneid, cityid, zonename);
        return "ZoneOperation.jsf";
    }
    
    /**
     * Creates a new instance of ZoneBean
     */
    public ZoneBean() {
    }
    
}
