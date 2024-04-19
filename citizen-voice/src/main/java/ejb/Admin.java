/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Citytb;
import entities.Districttb;
import entities.Questiontb;
import entities.Statetb;
import entities.Talukatb;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ompan
 */
@Stateless
public class Admin implements AdminLocal {
    
    @PersistenceContext(unitName = "citizenpu")
    EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    // USER OPERATIONS

    @Override
    public void addUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateUser(int user_id, String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUser(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Usertb> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Usertb> getUsersByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Usertb> getUsersById(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Usertb> getUsersByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Usertb> getUsersByContact(String contact) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // STATE OPERATIONS
    
    @Override
    public void addStates(String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb state = new Statetb();
        state.setStateName(state_name);
        em.persist(state);
    }

    @Override
    public void updateState(int state_id, String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb state = (Statetb) em.find(Statetb.class, state_id);
        if(state != null)
        {
            state.setStateName(state_name);
            em.merge(state);
            System.out.println("State Inserted!!");
        }
        else
        {
            System.out.println("State with id " + state_id + " Not Found!!");
        }
    }

    @Override
    public void deleteState(int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        em.remove(s);
    }

    @Override
    public Collection<Statetb> getAllStates() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Statetb.findAll").getResultList();
    }

    @Override
    public Collection<Statetb> getStatesByName(String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Statetb.findByStateName")
                .setParameter("state_name", state_name)
                .getResultList();
    }

    // DISTRICT OPERATIONS
    
    @Override
    public void addDistricts(int state_id, String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        Collection<Districttb> districts = s.getDistricttbCollection();
        
        Districttb d = new Districttb();
        d.setDistrictName(district_name);
        d.setStateId(s);
        districts.add(d);
        
        s.setDistricttbCollection(districts);
        
        em.persist(d);
        em.merge(s);
    }

    @Override
    public void updateDistrict(int district_id, int state_id, String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        Collection<Districttb> districts = s.getDistricttbCollection();
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        if(districts.contains(d))
        {
            districts.remove(d);
        }
        d.setDistrictName(district_name);
        d.setStateId(s);
        districts.add(d);
        
        s.setDistricttbCollection(districts);
        
        em.merge (d);
        em.merge(s);
    }

    @Override
    public void deleteDistrict(int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        em.remove(d);
    }

    @Override
    public Collection<Districttb> getAllDistricts() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Districttb.findAll").getResultList();
    }

    @Override
    public Collection<Districttb> getDistrictsByName(String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Districttb.findByDistrictName")
                .setParameter("district_name", district_name)
                .getResultList();
    }

    // CITY OPERATIONS
    
    @Override
    public void addCity(int district_id, String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<Citytb> cities = d.getCitytbCollection();
        Citytb c = new Citytb();
        c.setCityName(city_name);
        c.setDistrictId(d);
        
        cities.add(c);
        
        d.setCitytbCollection(cities);
        
        em.persist(c);
        em.merge(d);
        
    }

    @Override
    public void updateCity(int city_id, int district_id, String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<Citytb> cities = d.getCitytbCollection();
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        
        if(cities.contains(c))
        {
            cities.remove(c);
        }
        
        c.setCityName(city_name);
        c.setDistrictId(d);
        
        cities.add(c);
        
        d.setCitytbCollection(cities);
        
        em.merge(c);
        em.merge(d);
    }

    @Override
    public void deleteCity(int city_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        em.remove(c);
    }

    @Override
    public Collection<Citytb> getAllCities() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Citytb.findAll").getResultList();
    }

    @Override
    public Collection<Citytb> getCitiesByName(String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Citytb.findByCityName")
                .setParameter("city_name", city_name)
                .getResultList();
    }

    // ZONE OPERATIONS
    
    @Override
    public void addZone(int city_id, String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        Collection<Zonetb> zones = c.getZonetbCollection();
        Zonetb z = new Zonetb();
        
        z.setZoneName(zone_name);
        z.setCityId(c);
        
        zones.add(z);
        
        c.setZonetbCollection(zones);
        
        em.persist(z);
        em.merge(c);
    }

    @Override
    public void updateZone(int zone_id, int city_id, String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        Collection<Zonetb> zones = c.getZonetbCollection();
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        
        if(zones.contains(z))
        {
            zones.remove(z);
        }
        
        z.setZoneName(zone_name);
        z.setCityId(c);
        
        zones.add(z);
        
        c.setZonetbCollection(zones);
        
        em.merge(z);
        em.merge(c);
    }

    @Override
    public void deleteZone(int zone_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        em.remove(z);
    }

    @Override
    public Collection<Zonetb> getAllZones() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Zonetb.findAll").getResultList();
    }

    @Override
    public Collection<Zonetb> getZoneByName(String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Zonetb.findByZoneName")
                .setParameter("zone_name", zone_name)
                .getResultList();
    }

    //WARD OPEARTIONS
    
    @Override
    public void addWard(int zone_id, String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        Collection<Wardtb> wards = z.getWardtbCollection();
        Wardtb w = new Wardtb();
        w.setWardName(ward_name);
        w.setZoneId(z);
        wards.add(w);
        
        z.setWardtbCollection(wards);
        
        em.persist(w);
        em.merge(z);
        
   }

    @Override
    public void updateWard(int ward_id, int zone_id, String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        Collection<Wardtb> wards = z.getWardtbCollection();
        Wardtb w = (Wardtb) em.find(Wardtb.class, ward_id);
        
        if(wards.contains(w))
        {
            wards.remove(w);
        }
        
        w.setWardName(ward_name);
        w.setZoneId(z);
        wards.add(w);
        
        z.setWardtbCollection(wards);
        
        em.merge(w);
        em.merge(z);
    }

    @Override
    public void deleteWard(int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Wardtb w = (Wardtb) em.find(Wardtb.class, ward_id);
         em.remove(w);
    }

    @Override
    public Collection<Wardtb> getAllWards() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Wardtb.findAll").getResultList();
    }

    @Override
    public Collection<Wardtb> getWardByName(String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         return em.createNamedQuery("Wardtb.findByWardName")
                 .setParameter("ward_name", ward_name)
                 .getResultList();
    }

    // TALUKA OPERATIONS
    
    @Override
    public void addTaluka(int district_id, String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<Talukatb> talukas = d.getTalukatbCollection();
        Talukatb t = new Talukatb();
        t.setTalukaName(taluka_name);
        t.setDistrictId(d);
        talukas.add(t);
        
        d.setTalukatbCollection(talukas);
        
        em.persist(t);
        em.merge(d);
    }

    @Override
    public void updateTaluka(int taluka_id, int district_id, String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<Talukatb> talukas = d.getTalukatbCollection();
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        
        if(talukas.contains(t))
        {
            talukas.remove(t);
        }
        
        t.setTalukaName(taluka_name);
        t.setDistrictId(d);
        talukas.add(t);
        
        d.setTalukatbCollection(talukas);
        
        em.merge(t);
        em.merge(d);
    }

    @Override
    public void deleteTaluka(int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        em.remove(t);
    }

    // VILLAGE OPERATIONS
    
    @Override
    public Collection<Talukatb> getAllTaluka() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Talukatb.findAll").getResultList();
    }

    @Override
    public Collection<Talukatb> getTalukaByName(String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Talukatb.findByTalukaName")
                .setParameter("taluka_name", taluka_name)
                .getResultList();
    }

    @Override
    public void addVillage(int taluka_id, String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        Collection<Villagetb> villages = t.getVillagetbCollection();
        Villagetb v = new Villagetb();
        
        v.setVillageName(village_name);
        v.setTalukaId(t);
        
        villages.add(v);
        t.setVillagetbCollection(villages);
        
        em.persist(v);
        em.merge(t);
    }

    @Override
    public void updateVillage(int village_id, int taluka_id, String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        Collection<Villagetb> villages = t.getVillagetbCollection();
        Villagetb v = (Villagetb) em.find(Villagetb.class, village_id);
        
        if(villages.contains(v))
        {
            villages.remove(v);
        }
        
        v.setVillageName(village_name);
        v.setTalukaId(t);
        
        villages.add(v);
        t.setVillagetbCollection(villages);
        
        em.merge(v);
        em.merge(t);
    }

    @Override
    public void deleteVillage(int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Villagetb v = (Villagetb) em.find(Villagetb.class, village_id);
         em.remove(v);
    }

    @Override
    public Collection<Villagetb> getAllVillages() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Villagetb.findAll").getResultList();
    }

    @Override
    public Collection<Villagetb> getVillageByName(String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Villagetb.findByVillageName")
                .setParameter("village_name", village_name)
                .getResultList();
    }

    //QUESTIONS OPERATIONS
    
    @Override
    public void addQuestion(String question, String level) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateQuestion(int qid, String level) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteQuestion(int qid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Questiontb> getAllQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // QUESTION STATE
    
    @Override
    public void addQuestionState(int qid, int state_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateStateQuestion(int question_state_id, int qid, int state_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteStateQuestion(int question_state_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    //QUESTION DISTRICT
    
    @Override
    public void addQuestionDistrict(int qid, int state_id, int district_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateDistrictQuestion(int question_district_id, int qid, int state_id, int district_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteDistrictQuestion(int question_district_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //QUESTION CITY
    
    @Override
    public void addQuestionCity(int qid, int state_id, int district_id, int city_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCityQuestion(int question_city_id, int qid, int state_id, int district_id, int city_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCityQuestion(int question_city_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //QUESTION WARD
    
    @Override
    public void addQuestionWard(int qid, int state_id, int district_id, int city_id, int ward_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateWardQuestion(int question_ward_id, int qid, int state_id, int district_id, int city_id, int ward_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteWardQuestion(int question_ward_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    //QUESTION ZONE
    
    @Override
    public void addQuestionZone(int qid, int state_id, int district_id, int city_id, int zone_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateZoneQuestion(int question_zone_id, int qid, int state_id, int district_id, int city_id, int ward_id, int zone_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteZoneQuestion(int question_zone_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    //QUESTION TALUKA
    
    @Override
    public void addQuestionTaluka(int qid, int state_id, int district_id, int taluka_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateTalukaQuestion(int question_taluka_id, int qid, int state_id, int district_id, int taluka_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTalukaQuestion(int question_taluka_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // QUESTION VILLAGE
    
    @Override
    public void addQuestionVillage(int qid, int state_id, int district_id, int village_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateVillageQuestion(int question_village_id, int qid, int state_id, int district_id, int village_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteVillageQuestion(int question_village_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
