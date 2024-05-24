/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Citytb;
import entities.Districttb;
import entities.Statetb;
import entities.Wardtb;
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
@Named(value = "wardBean")
@SessionScoped
public class WardBean implements Serializable {
    
    @EJB AdminLocal adl;
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
        wards = adl.getAllWards();
        return wards;
    }

    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
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

    public Collection<Citytb> getCities() {
        if(districtid != 0)
        {
            return adl.getCitiesByDistrict(districtid);
        }
        return null;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        if(cityid != 0)
        {
            return adl.getZonesByCity(cityid);
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
        adl.addWard(zoneid, wardname);
        return "WardOperation.jsf";
    }
    
    public String deleteWard(Wardtb ward)
    {
        current = ward;
        wardid = current.getWardId();
        System.out.println("Wardid = " + wardid);
        adl.deleteWard(wardid);
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
        System.out.println("WARD ID = " + wardid);
        adl.updateWard(wardid, zoneid, wardname);
        return "WardOperation.jsf";
    }
    
    public WardBean() {
    }
    
}
