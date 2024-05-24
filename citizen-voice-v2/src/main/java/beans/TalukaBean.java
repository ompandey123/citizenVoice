/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Districttb;
import entities.Statetb;
import entities.Talukatb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author ompan
 */
@Named(value = "talukaBean")
@SessionScoped
public class TalukaBean implements Serializable {
    
    @EJB AdminLocal adl;
    int stateid;
    int districtid;
    int talukaid;
    String talukaname;
    Collection<Talukatb> talukas;
    Collection<Statetb> states;
    Collection<Districttb> districts;
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
        talukas = adl.getAllTaluka();
        return talukas;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
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

    public Talukatb getCurrent() {
        return current;
    }

    public void setCurrent(Talukatb current) {
        this.current = current;
    }
    
    public String addTaluka()
    {
        adl.addTaluka(districtid, talukaname);
        return "TalukaOperation.jsf";
    }
    
    public String deleteTaluka(Talukatb taluka)
    {
        current = taluka;
        talukaid = current.getTalukaId();
        adl.deleteTaluka(talukaid);
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
        adl.updateTaluka(talukaid, districtid, talukaname);
        return "TalukaOperation.jsf";
   }
    
    /**
     * Creates a new instance of TalukaBean
     */
    public TalukaBean() {
    }
    
}
