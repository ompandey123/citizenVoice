/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Districttb;
import entities.Statetb;
import entities.Talukatb;
import entities.Villagetb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author ompan
 */
@Named(value = "villageBean")
@SessionScoped
public class VillageBean implements Serializable {
    
    @EJB AdminLocal adl;
    int stateid;
    int districtid;
    int talukaid;
    int villageid;
    String villagename;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Talukatb> talukas;
    Collection<Villagetb> villages;
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

    public Collection<Talukatb> getTalukas() {
        if(districtid != 0)
        {
            return adl.getTalukaByDistrict(districtid);
        }
        return null;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }

    public Collection<Villagetb> getVillages() {
        villages = adl.getAllVillages();
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
    adl.addVillage(talukaid, villagename);
    return "VillageOperation.jsf";
}

    public String deleteVillage(Villagetb village)
    {
        current = village;
        villageid = current.getVillageId();
        adl.deleteVillage(villageid);
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
        adl.updateVillage(villageid, talukaid, villagename);
        return "VillageOperation.jsf";
    }
    /**
     * Creates a new instance of VillageBean
     */
    public VillageBean() {
    }
    
}
