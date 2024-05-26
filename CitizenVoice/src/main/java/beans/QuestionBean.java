/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
import ejb.AdminLocal;
import ejb.PackedObjects;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ompan
 */
@Named(value = "questionBean")
@SessionScoped
public class QuestionBean implements Serializable {
    @EJB AdminLocal admin;
    
    AdminClient ac;
    Response rs;
    
    int qid;
    int stateid;
    int districtid;
    int cityid;
    int talukaid;
    int villageid;
    int zoneid;
    int wardid;
    int categoryid;
    
    String question;
    String level;
    String option1;
    String option2;
    String option3;
    String option4;
    
    Collection<Integer> stateids;
    Collection<Integer> districtids;
    Collection<Integer> cityids;
    Collection<Integer> zoneids;
    Collection<Integer> wardids;
    Collection<Integer> talukaids;
    Collection<Integer> villageids;
    
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
    GenericType<Collection<Questiontb>> gquestions;
    
    Questiontb current;
    
    public QuestionBean(){
        
        ac = new AdminClient();
        states = new ArrayList<>();
        districts = new ArrayList<>();
        talukas = new ArrayList<>();
        villages = new ArrayList<>();
        cities = new ArrayList<>();
        zones = new ArrayList<>();
        wards = new ArrayList<>();
        questions = new ArrayList<>();
        
        gstates = new GenericType<Collection<Statetb>>(){};
        gdistricts = new GenericType<Collection<Districttb>>(){};
        gtalukas = new GenericType<Collection<Talukatb>>(){};
        gvillages = new GenericType<Collection<Villagetb>>(){};
        gcities = new GenericType<Collection<Citytb>>(){};
        gzones = new GenericType<Collection<Zonetb>>(){};
        gwards = new GenericType<Collection<Wardtb>>(){};
        gquestions = new GenericType<Collection<Questiontb>>(){};
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public Questiontb getCurrent() {
        return current;
    }

    public void setCurrent(Questiontb current) {
        this.current = current;
    }

    
    
    public AdminLocal getAdmin() {
        return admin;
    }

    public void setAdmin(AdminLocal admin) {
        this.admin = admin;
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

    public Collection<Integer> getStateids() {
        return stateids;
    }

    public void setStateids(Collection<Integer> stateids) {
        this.stateids = stateids;
    }

    public Collection<Integer> getDistrictids() {
        return districtids;
    }

    public void setDistrictids(Collection<Integer> districtids) {
        this.districtids = districtids;
    }

    public Collection<Integer> getCityids() {
        return cityids;
    }

    public void setCityids(Collection<Integer> cityids) {
        this.cityids = cityids;
    }

    public Collection<Integer> getZoneids() {
        return zoneids;
    }

    public void setZoneids(Collection<Integer> zoneids) {
        this.zoneids = zoneids;
    }

    public Collection<Integer> getWardids() {
        return wardids;
    }

    public void setWardids(Collection<Integer> wardids) {
        this.wardids = wardids;
    }

    public Collection<Integer> getTalukaids() {
        return talukaids;
    }

    public void setTalukaids(Collection<Integer> talukaids) {
        this.talukaids = talukaids;
    }

    public Collection<Integer> getVillageids() {
        return villageids;
    }

    public void setVillageids(Collection<Integer> villageids) {
        this.villageids = villageids;
    }

    public Collection<Statetb> getStates() {
        rs = ac.getAllStates(Response.class);
        states = rs.readEntity(gstates);
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }
    
    public void populateDistricts()
    {
        if(stateids != null)
        {
            districts.clear();
            for(Integer stateid : stateids)
            {
                System.out.println("state id - " + stateid);
                if(stateid != 0)
                {
                    districts.addAll(ac.getDistrictByState(Response.class, String.valueOf(stateid)).readEntity(gdistricts));
                }
            }
        }
    }

    public Collection<Districttb> getDistricts() {
       
        return districts;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public void populateTaluka()
    {
        if(districtids != null)
        {
            talukas.clear();
            for(Integer districtid : districtids)
            {
                if(districtid != 0)
                {
                    talukas.addAll(ac.getTalukaByDistrict(Response.class, String.valueOf(districtid)).readEntity(gtalukas));
                }
            }
        }
    }
    
    public Collection<Talukatb> getTalukas() {
       
        return talukas;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }
    
    public void populateVillages()
    {
        if(talukaids != null)
        {
            villages.clear();
            for(Integer talukaid : talukaids)
            {
                if(talukaid != 0)
                {
                    villages.addAll(ac.getVillagesByTaluka(Response.class, String.valueOf(talukaid)).readEntity(gvillages));
                }
            }
        }
    }

    public Collection<Villagetb> getVillages() {
       
        return villages;
    }

    public void setVillages(Collection<Villagetb> villages) {
        this.villages = villages;
    }

    public Collection<Citytb> getCities() {
       
        return cities;
    }

    
    public void populateCities()
    {
        if(districtids != null)
        {
            cities.clear();
            for(Integer districtid: districtids)
            {
                if(districtid != 0)
                {
                    cities.addAll(ac.getCitiesByDistrict(Response.class, String.valueOf(districtid)).readEntity(gcities));
                }
            }
        }
    }
    
    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        return zones;
    }
    
    public void populateZones()
    {
        if(cities != null)
        {
            zones.clear();
            for(Integer cityid : cityids)
            {if(cityid != 0)
            {
                zones.addAll(ac.getZonesByCity(Response.class, String.valueOf(cityid)).readEntity(gzones));
            }
                }
        }
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards() {
       return wards;
    }
    
    public void populateWards()
    {
        if(zones != null)
        {
            zones.clear();
            for(Integer zoneid : zoneids)
            {
                if(zoneid != 0)
                {
                    wards.addAll(ac.getWardsByZone(Response.class, String.valueOf(zoneid)).readEntity(gwards));
                }
            }
        }
    }

    
    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Collection<Category> getCategories() {
        categories = admin.getAllCategories();
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Questiontb> getQuestions() {
        if(level.equals("state"))
        {
            System.out.println("level="+level + " stateid = " + stateid);
            return ac.getQuestionsByState(Response.class, String.valueOf(stateid)).readEntity(gquestions);
        }
        else if(level.equals("district"))
        {
            return ac.getQuestionsByDistrict(Response.class, String.valueOf(districtid)).readEntity(gquestions);
        }
        else if(level.equals("city"))
        {
            return ac.getQuestionsByCity(Response.class, String.valueOf(cityid)).readEntity(gquestions);
        }
        else if(level.equals("zone"))
        {
            return ac.getQuestionsByZone(Response.class, String.valueOf(zoneid)).readEntity(gquestions);
        }
        else if(level.equals("ward"))
        {
            return ac.getQuestionsByWard(Response.class, String.valueOf(wardid)).readEntity(gquestions);
        }
        else if(level.equals("taluka"))
        {
            return ac.getQuestionsByTaluka(Response.class, String.valueOf(talukaid)).readEntity(gquestions);
        }
        else if(level.equals("village"))
        {
            return ac.getQuestionsByVillage(Response.class, String.valueOf(villageid)).readEntity(gquestions);
        }
        return questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }
    
    
    
    
    public String addQuestion()
    {
        PackedObjects p = new PackedObjects();
        p.setState_ids(stateids);
        p.setDistrict_ids(districtids);
        p.setCity_ids(cityids);
        p.setZone_ids(zoneids);
        p.setWard_ids(wardids);
        p.setTaluka_ids(talukaids);
        p.setVillage_ids(villageids);
        
        ac.addQuestion(p, String.valueOf(categoryid), question, level, option1, option2, option3, option4);
        
        return "addQuestion.jsf";
    }
    
    public String deleteQuestion(Questiontb q){
        current = q;
        qid = current.getQid();
        ac.deleteQuestion(String.valueOf(qid));
        return "QuestionOperation.jsf";
    }
    
    public String redirectToEdit()
    {
        qid = current.getQid();
        categoryid = current.getCategoryid().getCategoryid();
        level = current.getLevel();
        question = current.getQuestion();
        option1 = current.getOption1();
        option2 = current.getOption2();
        option3 = current.getOption3();
        option4 = current.getOption4();
        System.out.println("question = " + question);
        return "updateQuestion.jsf";
    }
    
    public String updateQuestion()
    {
        qid = current.getQid();
        categoryid = current.getCategoryid().getCategoryid();
        level = current.getLevel();
        question = current.getQuestion();
        option1 = current.getOption1();
        option2 = current.getOption2();
        option3 = current.getOption3();
        option4 = current.getOption4();
        ac.updateQuestion(String.valueOf(qid), String.valueOf(categoryid), question, level, option1, option2, option3, option4);
        return "QuestionOperation.jsf";
    }
}
