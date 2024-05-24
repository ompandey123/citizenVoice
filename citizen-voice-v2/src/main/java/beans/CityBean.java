/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Citytb;
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
@Named(value = "cityBean")
@SessionScoped
public class CityBean implements Serializable {

    @EJB AdminLocal adl;
    int cityid;
    int districtid;
    int stateid;
    String cityname;
    Collection<Citytb> cities;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Citytb current;

    public Collection<Citytb> getCities() {
        cities = adl.getAllCities();
        return cities;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
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

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Citytb getCurrent() {
        return current;
    }

    public void setCurrent(Citytb current) {
        this.current = current;
    }
    
    public Collection<Statetb> getStates() {
        states = adl.getAllStates();
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public Collection<Districttb> getDistricts() {
        if(stateid != 0){
      return adl.getDistrictByState(stateid);
        }
        return null;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }
    
    public String addCity()
    {
        System.out.println(stateid + " " + districtid + " " + cityname);
        adl.addCity(districtid, cityname, stateid);
        return "CityOperation.jsf";
    }

    
    public String deleteCity(Citytb city)
    {
        current = city;
        cityid = current.getCityId();
        adl.deleteCity(cityid);
        return "CityOperation.jsf";
    }
    
    public String updateCity()
    {
        cityid = current.getCityId();
        districtid = current.getDistrictId().getDistrictId();
        stateid = current.getStateId().getStateId();
        cityname = current.getCityName();
        adl.updateCity(cityid, districtid, stateid, cityname);
        return "CityOperation.jsf"; 
    }
    
    public String redirectToEdit()
    {
        return "updateCity.jsf";
    }
    
    /**
     * Creates a new instance of CityBean
     */
    public CityBean() {
    }
    
}
