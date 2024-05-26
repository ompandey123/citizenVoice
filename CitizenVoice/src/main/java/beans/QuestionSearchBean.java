/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ompan
 */
@Named(value = "questionSearchBean")
@SessionScoped
public class QuestionSearchBean implements Serializable {

    @EJB AdminLocal adl;
    
    AdminClient ac;
    Response rs;
    
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
    
    GenericType<Collection<Statetb>> gstates;
    GenericType<Collection<Districttb>> gdistricts;
    GenericType<Collection<Talukatb>> gtalukas;
    GenericType<Collection<Villagetb>> gvillages;
    GenericType<Collection<Citytb>> gcities;
    GenericType<Collection<Zonetb>> gzones;
    GenericType<Collection<Wardtb>> gwards;
    GenericType<Collection<Category>> gcategories;
    GenericType<Collection<Questiontb>> gquestions;
    
    int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    
    public String getLevel() {
        
        if(level!=null){
        if(level.equals("state"))
        {
            pid = stateid;
        }
        else if(level.equals("district"))
        {
         pid = districtid;
        }
        else if(level.equals("city"))
        {
            pid = cityid;
        }
        else if(level.equals("zone"))
        {
            pid = zoneid;
        }
        else if(level.equals("ward"))
        {
            pid = wardid;
        }
        else if(level.equals("taluka"))
        {
            pid = talukaid;
        }
        else if(level.equals("village"))
        {
         pid = villageid;
        }
      }
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
        System.out.println("in get states");
        ac = new AdminClient();
        rs = ac.getAllStates(Response.class);
       
        states= new ArrayList<>();
       gstates = new GenericType<Collection<Statetb>>(){};
       
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

    public Collection<Talukatb> getTalukas() {
        if(districtid != 0){
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
         if(talukaid != 0){
             rs = ac.getVillagesByTaluka(Response.class, String.valueOf(talukaid));
             villages = rs.readEntity(gvillages);
         return villages;
        }
        return null;
    }

    public void setVillages(Collection<Villagetb> villages) {
        this.villages = villages;
    }

    public Collection<Citytb> getCities() {
        if(districtid != 0){
            rs = ac.getCitiesByDistrict(Response.class, String.valueOf(districtid));
            cities = rs.readEntity(gcities);
        return cities;
        }
        return null;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        if(cityid != 0){
            rs = ac.getZonesByCity(Response.class, String.valueOf(cityid));
            zones = rs.readEntity(gzones);
        return zones;
        }
        return null;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards() {
        if(zoneid != 0){
            rs = ac.getWardsByZone(Response.class, String.valueOf(zoneid));
            wards = rs.readEntity(gwards);
        return wards;
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
            return ac.getQuestionsByState(Response.class, String.valueOf(stateid)).readEntity(gquestions);
        }
        else if(level.equals("district"))
        {
         if(districtid!=0)
            return ac.getQuestionsByDistrict(Response.class, String.valueOf(districtid)).readEntity(gquestions);
        }
        else if(level.equals("city"))
        {
            if(cityid!=0)
            return ac.getQuestionsByCity(Response.class, String.valueOf(cityid)).readEntity(gquestions);
        }
        else if(level.equals("zone"))
        {
            if(zoneid!=0)
            return ac.getQuestionsByZone(Response.class, String.valueOf(zoneid)).readEntity(gquestions);
        }
        else if(level.equals("ward"))
        {
            if(wardid!=0)
            return ac.getQuestionsByWard(Response.class, String.valueOf(wardid)).readEntity(gquestions);
        }
        else if(level.equals("taluka"))
        {
            if(talukaid!=0)
            return ac.getQuestionsByTaluka(Response.class, String.valueOf(talukaid)).readEntity(gquestions);
        }
        else if(level.equals("village"))
        {
         if(villageid!=0)
            return ac.getQuestionsByVillage(Response.class, String.valueOf(villageid)).readEntity(gquestions);
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
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        talukas = new ArrayList<>();
        villages = new ArrayList<>();
        cities = new ArrayList<>();
        zones = new ArrayList<>();
        wards = new ArrayList<>();
        questions = new ArrayList<>();
        categories = new ArrayList<>();
        
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gtalukas = new GenericType<Collection<Talukatb>>(){};
        gvillages = new GenericType<Collection<Villagetb>>(){};
        gcities = new GenericType<Collection<Citytb>>(){};
        gzones = new GenericType<Collection<Zonetb>>(){};
        gwards = new GenericType<Collection<Wardtb>>(){};
        gquestions = new GenericType<Collection<Questiontb>>(){};
        gcategories = new GenericType<Collection<Category>>(){};
    }
    
}
