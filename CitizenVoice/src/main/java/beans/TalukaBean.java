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
@Named(value = "talukaBean")
@SessionScoped
public class TalukaBean implements Serializable {
    
    @EJB AdminLocal adl;
    
    AdminClient ac;
    Response rs;
    
    int stateid;
    int districtid;
    int talukaid;
    String talukaname;
    Collection<Talukatb> talukas;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    GenericType<Collection<Talukatb>> gtalukas;
    GenericType<Collection<Statetb>> gstates;
    GenericType<Collection<Districttb>> gdistricts;
    Talukatb current;

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

    public String getTalukaname() {
        return talukaname;
    }

    public void setTalukaname(String talukaname) {
        this.talukaname = talukaname;
    }

    public Collection<Talukatb> getTalukas() {
        rs = ac.getAllTaluka(Response.class);
        talukas = rs.readEntity(gtalukas);
        return talukas;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
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

    public Talukatb getCurrent() {
        return current;
    }

    public void setCurrent(Talukatb current) {
        this.current = current;
    }
    
    public String addTaluka()
    {
        ac.addTaluka(String.valueOf(districtid), talukaname);
        return "TalukaOperation.jsf";
    }
    
    public String deleteTaluka()
    {
        talukaid = current.getTalukaId();
        ac.deleteTaluka(String.valueOf(talukaid));
        return "TalukaOperation.jsf";
    }

    public String redirectToEdit()
    {
        return "updateTaluka.jsf";
    }
    
    
    public String updateTaluka()
    {
        talukaid = current.getTalukaId();
        districtid = current.getDistrictId().getDistrictId();
        talukaname = current.getTalukaName();
        ac.updateTaluka(String.valueOf(talukaid), String.valueOf(districtid), talukaname);
        return "TalukaOperation.jsf";
   }
    
    /**
     * Creates a new instance of TalukaBean
     */
    public TalukaBean() {
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        talukas = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gtalukas = new GenericType<Collection<Talukatb>>(){};
    }
    
}
