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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ompan
 */
@Named(value = "cityBean")
@SessionScoped
public class CityBean implements Serializable {

    @EJB AdminLocal adl;
    AdminClient ac;
    Response rs;
    
    int cityid;
    int districtid;
    int stateid;
    String cityname;
    Collection<Citytb> cities;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    GenericType<Collection<Statetb>> gstates;
    GenericType<Collection<Districttb>> gdistricts;
    GenericType<Collection<Citytb>> gcities;
    Citytb current;

    public Collection<Citytb> getCities() {
        rs = ac.getAllCities(Response.class);
        cities = rs.readEntity(gcities);
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
        rs = ac.getAllStates(Response.class);
        states = rs.readEntity(gstates);
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public Collection<Districttb> getDistricts() {
       if(stateid != 0){
            rs = ac.getDistrictByState(Response.class, String.valueOf(stateid));
            districts = rs.readEntity(gdistricts);
            return districts;
        }
        return null;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }
    
    public String addCity()
    {
        
        ac.addCity(String.valueOf(districtid), cityname, String.valueOf(stateid));
        return "CityOperation.jsf";
    }

    
    public String deleteCity()
    {
        cityid = current.getCityId();
        ac.deleteCity(String.valueOf(cityid));
        return "CityOperation.jsf";
    }
    
    public String updateCity()
    {
        cityid = current.getCityId();
        districtid = current.getDistrictId().getDistrictId();
        stateid = current.getStateId().getStateId();
        cityname = current.getCityName();
        ac.updateCity(String.valueOf(cityid), String.valueOf(districtid), String.valueOf(stateid), cityname);
        return "CityOperation.jsf"; 
    }
    
    public String redirectToEdit()
    {
        return "updateCity.jsf";
    }
    
    public CityBean() {
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        cities = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gcities = new GenericType<Collection<Citytb>>(){};
    }
    
    public void delete() {
        addMessage("Confirmed", "Record deleted");
    }
    
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
