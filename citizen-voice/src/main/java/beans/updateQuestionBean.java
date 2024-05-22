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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author ompan
 */
@Named(value = "updateQuestionBean")
@SessionScoped
public class updateQuestionBean implements Serializable {
    
     @EJB AdminLocal admin;
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
    Questiontb current;

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
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
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public Collection<Districttb> getDistricts() {
        return districts;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public Collection<Talukatb> getTalukas() {
        return talukas;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
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

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        return zones;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards() {
        return wards;
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
        return questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }

    public Questiontb getCurrent() {
        return current;
    }

    public void setCurrent(Questiontb current) {
        this.current = current;
    }
    
    

    public updateQuestionBean() {
    }
    
}
