/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
import ejb.AdminLocal;
import entities.Districttb;
import entities.Statetb;
import entities.Talukatb;
import entities.Villagetb;
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
@Named(value = "villageBean")
@SessionScoped
public class VillageBean implements Serializable {
    
    @EJB AdminLocal adl;
    
    AdminClient ac;
    Response rs;
    
    int stateid;
    int districtid;
    int talukaid;
    int villageid;
    String villagename;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Talukatb> talukas;
    Collection<Villagetb> villages;
    GenericType<Collection<Statetb>> gstates;
    GenericType<Collection<Districttb>> gdistricts;
    GenericType<Collection<Talukatb>> gtalukas;
    GenericType<Collection<Villagetb>> gvillages;
    Villagetb current;

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

    public int getTalukaid() {
        return talukaid;
    }

    public void setTalukaid(int talukaid) {
        this.talukaid = talukaid;
    }

    public int getVillageid() {
        return villageid;
    }

    public void setVillageid(int villageid) {
        this.villageid = villageid;
    }

    public String getVillagename() {
        return villagename;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
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

    public Collection<Talukatb> getTalukas() {
        if(districtid != 0)
        {
            rs = ac.getTalukaByDistrict(Response.class, String.valueOf(districtid));
            talukas = rs.readEntity(gtalukas);
            return talukas;
        }
        return null;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }

    public Collection<Villagetb> getVillages() {
        rs = ac.getAllVillages(Response.class);
        villages = rs.readEntity(gvillages);
        return villages;
    }

    public void setVillages(Collection<Villagetb> villages) {
        this.villages = villages;
    }

    public Villagetb getCurrent() {
        return current;
    }

    public void setCurrent(Villagetb current) {
        this.current = current;
    }
    
    
public String addVillage()
{
    ac.addVillage(String.valueOf(talukaid), villagename);
    return "VillageOperation.jsf";
}

    public String deleteVillage(Villagetb village)
    {
        current = village;
        villageid = current.getVillageId();
        ac.deleteVillage(String.valueOf(villageid));
        return "VillageOperation.jsf";
    }
    
    public String redirectToEdit()
    {
        return "updateVillage.jsf";
    }
    
    public String updateVillage()
    {
        villageid = current.getVillageId();
        talukaid = current.getTalukaId().getTalukaId();
        villagename = current.getVillageName();
        ac.updateVillage(String.valueOf(villageid), String.valueOf(talukaid), villagename);
        return "VillageOperation.jsf";
    }
    /**
     * Creates a new instance of VillageBean
     */
    public VillageBean() {
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        talukas = new ArrayList<>();
        villages = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gtalukas = new GenericType<Collection<Talukatb>>(){};
        gvillages = new GenericType<Collection<Villagetb>>(){};
    }
    
}
