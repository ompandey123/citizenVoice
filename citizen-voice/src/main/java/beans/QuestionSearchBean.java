/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Category;
import entities.Citytb;
import entities.Districttb;
import entities.Questiontb;
import entities.Statetb;
import entities.Talukatb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ompan
 */
@Named(value = "questionSearchBean")
@SessionScoped
public class QuestionSearchBean implements Serializable {

    @EJB AdminLocal adl;
    
    int stateid;
    int districtid;
    int cityid;
    int talukaid;
    int villageid;
    int zoneid;
    int wardid;
    int categoryid;
    String level;
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Talukatb> talukas;
    Collection<Villagetb> villages;
    Collection<Citytb> cities;
    Collection<Zonetb> zones;
    Collection<Wardtb> wards;
    Collection<Category> categories;
    Collection<Questiontb> questions;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    
    
    public AdminLocal getAdl() {
        return adl;
    }

    public void setAdl(AdminLocal adl) {
        this.adl = adl;
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

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
    
    

    public Collection<Statetb> getStates() {
        return adl.getAllStates();
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
        if(districtid != 0){
        return adl.getTalukaByDistrict(districtid);
        }
        return null;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }

    public Collection<Villagetb> getVillages() {
         if(talukaid != 0){
         return adl.getVillagesByTaluka(talukaid);
        }
        return null;
    }

    public void setVillages(Collection<Villagetb> villages) {
        this.villages = villages;
    }

    public Collection<Citytb> getCities() {
        if(districtid != 0){
        return cities = adl.getCitiesByDistrict(districtid);
        }
        return null;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        if(cityid != 0){
        return adl.getZonesByCity(cityid);
        }
        return null;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards() {
        if(zoneid != 0){
        return adl.getWardsByZone(zoneid);
        }
        return null;
    }

    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Questiontb> getQuestions() {
        System.out.println("level="+level);
      if(level!=null){
        if(level.equals("state"))
        {
            System.out.println("level="+level + " stateid = " + stateid);
            if(stateid!=0)
            return adl.getQuestionsByState(stateid);
        }
        else if(level.equals("district"))
        {
         if(districtid!=0)
            return adl.getQuestionsByDistrict(districtid);
        }
        else if(level.equals("city"))
        {
            if(cityid!=0)
            return adl.getQuestionsByCity(cityid);
        }
        else if(level.equals("zone"))
        {
            if(zoneid!=0)
            return adl.getQuestionsByZone(zoneid);
        }
        else if(level.equals("ward"))
        {
            if(wardid!=0)
            return adl.getQuestionsByWard(wardid);
        }
        else if(level.equals("taluka"))
        {
            if(talukaid!=0)
            return adl.getQuestionsByTaluka(talukaid);
        }
        else if(level.equals("village"))
        {
         if(villageid!=0)
            return adl.getQuestionsByVillage(villageid);
        }
      }
       // Collection<Questiontb> q = new ArrayList<>();
        return  questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }
    
    
    
    /**
     * Creates a new instance of QuestionSearchBean
     */
    public QuestionSearchBean() {
    }
    
}
