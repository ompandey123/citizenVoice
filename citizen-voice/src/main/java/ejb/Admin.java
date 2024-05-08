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
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author ompan
 */
@DeclareRoles({"admin", "citizen"})
@Stateless
public class Admin implements AdminLocal {
    
    @PersistenceContext(unitName = "citizenpu")
    EntityManager em;
    
    // USER OPERATIONS

    @PermitAll
    @Override
    public void addUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try{
            Pbkdf2PasswordHashImpl pb;
        PasswordHashCompare phc;
         pb = new Pbkdf2PasswordHashImpl();
       Villagetb v = (Villagetb) em.find(Villagetb.class, village_id);
        Collection<Usertb> vusers = v.getUsertbCollection();
        
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        Collection<Usertb> tusers = t.getUsertbCollection();
        
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        Collection<Usertb> zusers = z.getUsertbCollection();
        
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        Collection<Usertb> cusers = c.getUsertbCollection();
        
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<Usertb> dusers = d.getUsertbCollection();
        
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        Collection<Usertb> susers = s.getUsertbCollection();
        
        Wardtb w = (Wardtb) em.find(Wardtb.class, ward_id);
        Collection<Usertb> wusers = w.getUsertbCollection();
        
        
        Usertb u = new Usertb();
        u.setUsername(username);
        String encpass = pb.generate(password.toCharArray());
        u.setPassword(encpass);
        u.setEmail(email);
        u.setAdhaarCardNo(adhaar_card_no);
        u.setContact(contact);
        u.setGender(gender);
        u.setAddress(address);
        u.setDob(dob);
        u.setZipCode(zip_code);
        
        
        
        u.setVillageId(v);
        u.setTalukaId(t);
        u.setZoneId(z);
        u.setCityId(c);
        u.setDistrictId(d);
        u.setWardId(w);
        u.setStateId(s);
        
        vusers.add(u);
        v.setUsertbCollection(vusers);
        
        tusers.add(u);
        t.setUsertbCollection(tusers);
        
        zusers.add(u);
        z.setUsertbCollection(zusers);
        
        cusers.add(u);
        c.setUsertbCollection(cusers);
        
        dusers.add(u);
        d.setUsertbCollection(dusers);
        
        susers.add(u);
        s.setUsertbCollection(susers);
        
        wusers.add(u);
        w.setUsertbCollection(wusers);
        
        
        em.persist(u);
        em.merge(v);
        em.merge(t);
        em.merge(z);
        em.merge(c);
        em.merge(d);
        em.merge(s);
        em.merge(w);       
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    @RolesAllowed("admin")
    @Override
    public void updateUser(int user_id, String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Villagetb v = (Villagetb) em.find(Villagetb.class, village_id);
        Collection<Usertb> vusers = v.getUsertbCollection();
        
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        Collection<Usertb> tusers = t.getUsertbCollection();
        
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        Collection<Usertb> zusers = z.getUsertbCollection();
        
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        Collection<Usertb> cusers = c.getUsertbCollection();
        
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<Usertb> dusers = d.getUsertbCollection();
        
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        Collection<Usertb> susers = s.getUsertbCollection();
        
        Wardtb w = (Wardtb) em.find(Wardtb.class, ward_id);
        Collection<Usertb> wusers = w.getUsertbCollection();
        
        Usertb u = (Usertb) em.find(Usertb.class, user_id);
        
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setAdhaarCardNo(adhaar_card_no);
        u.setContact(contact);
        u.setGender(gender);
        u.setAddress(address);
        u.setDob(dob);
        u.setZipCode(zip_code);
        
        
        
        u.setVillageId(v);
        u.setTalukaId(t);
        u.setZoneId(z);
        u.setCityId(c);
        u.setDistrictId(d);
        u.setWardId(w);
        u.setStateId(s);
        
        vusers.add(u);
        v.setUsertbCollection(vusers);
        
        tusers.add(u);
        t.setUsertbCollection(tusers);
        
        zusers.add(u);
        z.setUsertbCollection(zusers);
        
        cusers.add(u);
        c.setUsertbCollection(cusers);
        
        dusers.add(u);
        d.setUsertbCollection(dusers);
        
        susers.add(u);
        s.setUsertbCollection(susers);
        
        wusers.add(u);
        w.setUsertbCollection(wusers);
        
        
        
        em.merge(v);
        em.merge(t);
        em.merge(z);
        em.merge(c);
        em.merge(d);
        em.merge(s);
        em.merge(w);
        em.merge(u);
    }

    @RolesAllowed("admin")
    @Override
    public void deleteUser(int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Usertb u = (Usertb) em.find(Usertb.class, user_id);
        em.remove(u);
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Usertb> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Usertb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Usertb> getUsersByUsername(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Usertb.findByUsername").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Usertb> getUsersById(int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Usertb.findByUserId").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Usertb> getUsersByEmail(String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Usertb.findByEmail").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Usertb> getUsersByContact(String contact) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Usertb.findByContact").getResultList();
    }
    
    
    // STATE OPERATIONS
    
    @RolesAllowed("admin")
    @Override
    public void addStates(String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb state = new Statetb();
        state.setStateName(state_name);
        em.persist(state);
    }

    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
    @Override
    public void deleteState(int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        em.remove(s);
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Statetb> getAllStates() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Statetb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Statetb> getStatesByName(String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Statetb.findByStateName")
                .setParameter("state_name", state_name)
                .getResultList();
    }

    // DISTRICT OPERATIONS
    
    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
    @Override
    public void deleteDistrict(int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        em.remove(d);
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Districttb> getAllDistricts() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Districttb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Districttb> getDistrictsByName(String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Districttb.findByDistrictName").getResultList();
    }

    @PermitAll
    @Override
    public Collection<Districttb> getDistrictByState(int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        return s.getDistricttbCollection();
    }

    
    // CITY OPERATIONS
    
    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
    @Override
    public void deleteCity(int city_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        em.remove(c);
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Citytb> getAllCities() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Citytb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Citytb> getCitiesByName(String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Citytb.findByCityName")
                .setParameter("city_name", city_name)
                .getResultList();
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Citytb> getCitiesByDistrict(int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        return d.getCitytbCollection();
    }

    // ZONE OPERATIONS
    
    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
    @Override
    public void deleteZone(int zone_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        em.remove(z);
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Zonetb> getAllZones() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Zonetb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Zonetb> getZoneByName(String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Zonetb.findByZoneName")
                .setParameter("zone_name", zone_name)
                .getResultList();
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Zonetb> getZonesByCity(int city_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        return c.getZonetbCollection();
    }
    
    

    //WARD OPEARTIONS
    
    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
    @Override
    public void deleteWard(int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Wardtb w = (Wardtb) em.find(Wardtb.class, ward_id);
         em.remove(w);
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Wardtb> getAllWards() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Wardtb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Wardtb> getWardByName(String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         return em.createNamedQuery("Wardtb.findByWardName")
                 .setParameter("ward_name", ward_name)
                 .getResultList();
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Wardtb> getWardsByZone(int zone_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        return z.getWardtbCollection();
    }

    
    
    // TALUKA OPERATIONS
    
    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
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

    @RolesAllowed("admin")
    @Override
    public void deleteTaluka(int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        em.remove(t);
    }

    @PermitAll
    @Override
    public Collection<Talukatb> getTalukaByDistrict(int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        return d.getTalukatbCollection();
    }    
    
    
    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Talukatb> getAllTaluka() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Talukatb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Talukatb> getTalukaByName(String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Talukatb.findByTalukaName")
                .setParameter("taluka_name", taluka_name)
                .getResultList();
    }

    @RolesAllowed("admin")
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
    
    @RolesAllowed("admin")
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
    
    @RolesAllowed("admin")
    @Override
    public void deleteVillage(int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Villagetb v = (Villagetb) em.find(Villagetb.class, village_id);
         em.remove(v);
    }

    @RolesAllowed({"admin","citizen"})
    @Override
    public Collection<Villagetb> getAllVillages() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Villagetb.findAll").getResultList();
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Villagetb> getVillageByName(String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Villagetb.findByVillageName")
                .setParameter("village_name", village_name)
                .getResultList();
    }

    @PermitAll
    @Override
    public Collection<Villagetb> getVillagesByTaluka(int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        return t.getVillagetbCollection();
    }
    
    

    //QUESTIONS OPERATIONS
    
    @RolesAllowed("admin")
    @Override
    public void addQuestion(String question, String level, String option1, String option2, String option3, String option4, PackedObjects p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = new Questiontb();
        q.setQuestion(question);
        q.setLevel(level);
        q.setOption1(option1);
        q.setOption2(option2);
        q.setOption3(option3);
        q.setOption4(option4);

       // em.getTransaction().begin();
        em.persist(q);
        //em.getTransaction().commit();
      
Questiontb q1 = (Questiontb) em.createNamedQuery("Questiontb.findByQuestion").setParameter("question", question).getSingleResult();

//  em.refresh(q);
System.out.println("qid="+q1.getQid());
        if(level.equals("state"))
        {
            addQuestionState(q1.getQid(), p.getState_ids());
        }
        else if(level.equals("district"))
        {
           // addQuestionState(q1.getQid(), p.getState_ids());
            addQuestionDistrict(q1.getQid(), p.getDistrict_ids());
        }
        else if(level.equals("city"))
        {
            addQuestionCity(q1.getQid(), p.getCity_ids());
        }
        else if(level.equals("ward"))
        {
            addQuestionWard(q1.getQid(), p.getWard_ids());
        }
        else if(level.equals("zone"))
        {
            addQuestionZone(q1.getQid(), p.getZone_ids());
        }
        else if(level.equals("taluka"))
        {
            addQuestionTaluka(q1.getQid(), p.getTaluka_ids());
        }
        else if(level.equals("village"))
        {
            addQuestionVillage(q1.getQid(), p.getVillage_ids());
        }
        else
        {
            System.out.println("Level Invalid or Level unavailable");
        }
    }

    @RolesAllowed("admin")
    @Override
    public void updateQuestion(int qid, String question, String level, String option1, String option2, String option3, String option4, PackedObjects p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        if(q != null)
        {
            q.setQuestion(question);
        q.setLevel(level);
        q.setOption1(option1);
        q.setOption2(option2);
        q.setOption3(option3);
        q.setOption4(option4);
        
        em.merge(q);
        em.refresh(q);
        
        if(level.equals("state"))
        {
            addQuestionState(q.getQid(), p.getState_ids());
        }
        else if(level.equals("district"))
        {
            addQuestionDistrict(q.getQid(), p.getDistrict_ids());
        }
        else if(level.equals("city"))
        {
            addQuestionCity(q.getQid(), p.getCity_ids());
        }
        else if(level.equals("ward"))
        {
            addQuestionWard(q.getQid(), p.getWard_ids());
        }
        else if(level.equals("zone"))
        {
            addQuestionZone(q.getQid(), p.getZone_ids());
        }
        else if(level.equals("taluka"))
        {
            addQuestionTaluka(q.getQid(), p.getTaluka_ids());
        }
        else if(level.equals("village"))
        {
            addQuestionVillage(q.getQid(), p.getVillage_ids());
        }
        else
        {
            System.out.println("Level Invalid or Level unavailable");
        }
        
        
        }else
        {
            System.out.println("Question not found so cannot be updated");
        }
    }

    @RolesAllowed("admin")
    @Override
    public void deleteQuestion(int qid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        em.remove(q);
    }

    @RolesAllowed("admin")
    @Override
    public Collection<Questiontb> getAllQuestions() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Questiontb.findAll").getResultList();
    }

    // QUESTION STATE
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionState(int qid, Collection<Integer> state_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = em.find(Questiontb.class, qid);
        Collection<Statetb> states = q.getStatetbCollection();
        
        for(Integer sid: state_ids)
        {
            Statetb s = (Statetb) em.find(Statetb.class, sid);
            if(!states.contains(s))
            {
                Collection<Questiontb> questions = s.getQuestiontbCollection();
                states.add(s);
                questions.add(q);
                
                q.setStatetbCollection(states);
                s.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    @RolesAllowed("admin")
    @Override
    public void deleteStateQuestion(int qid, Collection<Integer> state_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = em.find(Questiontb.class, qid);
        Collection<Statetb> states = q.getStatetbCollection();
        
        for(Integer sid: state_ids)
        {
            Statetb s = (Statetb) em.find(Statetb.class, sid);
            if(states.contains(s))
            {
                Collection<Questiontb> questions = s.getQuestiontbCollection();
                states.remove(s);
                questions.remove(q);
                
                q.setStatetbCollection(states);
                s.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    
    //QUESTION DISTRICT
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionDistrict(int qid, Collection<Integer> district_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = em.find(Questiontb.class, qid);
        Collection<Districttb> districts = q.getDistricttbCollection();
        
        for(Integer did: district_ids)
        {
            Districttb d = (Districttb) em.find(Districttb.class, did);
            
            if(!districts.contains(d))
            {
                Collection<Questiontb> questions = d.getQuestiontbCollection();
                districts.add(d);
                questions.add(q);
                
                d.setQuestiontbCollection(questions);
                q.setDistricttbCollection(districts);
                
                em.merge(q);
            }
        }
    }

    @RolesAllowed("admin")
    @Override
    public void deleteDistrictQuestion(int qid, Collection<Integer> district_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = em.find(Questiontb.class, qid);
        Collection<Districttb> districts = q.getDistricttbCollection();
        
        for(Integer did: district_ids)
        {
            Districttb d = (Districttb) em.find(Districttb.class, did);
            
            if(districts.contains(d))
            {
                Collection<Questiontb> questions = d.getQuestiontbCollection();
                districts.remove(d);
                questions.remove(q);
                
                d.setQuestiontbCollection(questions);
                q.setDistricttbCollection(districts);
                
                em.merge(q);
            }
        }
    }

    //QUESTION CITY
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionCity(int qid,Collection<Integer> city_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Citytb> cities = q.getCitytbCollection();
        
        for(Integer cid : city_ids)
        {
            Citytb c = (Citytb) em.find(Citytb.class, cid);
           if(!cities.contains(c))
            {
                Collection<Questiontb> questions = c.getQuestiontbCollection();
                cities.add(c);
                questions.add(q);
                
                q.setCitytbCollection(cities);
                c.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    @RolesAllowed("admin")
    @Override
    public void deleteCityQuestion(int qid,Collection<Integer> city_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Citytb> cities = q.getCitytbCollection();
        
        for(Integer cid : city_ids)
        {
            Citytb c = (Citytb) em.find(Citytb.class, cid);
           if(cities.contains(c))
            {
                Collection<Questiontb> questions = c.getQuestiontbCollection();
                cities.remove(c);
                questions.remove(q);
                
                q.setCitytbCollection(cities);
                c.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }
    
   //QUESTION WARD
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionWard(int qid, Collection<Integer> ward_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Wardtb> wards = q.getWardtbCollection();
        
        for(Integer wid : ward_ids)
        {
            Wardtb w = (Wardtb) em.find(Wardtb.class, wid);
           if(!wards.contains(w))
            {
                Collection<Questiontb> questions = w.getQuestiontbCollection();
                wards.add(w);
                questions.add(q);
                
                q.setWardtbCollection(wards);
                w.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }
    
    @RolesAllowed("admin")
    @Override
    public void deleteWardQuestion(int qid, Collection<Integer> ward_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Wardtb> wards = q.getWardtbCollection();
        
        for(Integer wid : ward_ids)
        {
            Wardtb w = (Wardtb) em.find(Wardtb.class, wid);
           if(wards.contains(w))
            {
                Collection<Questiontb> questions = w.getQuestiontbCollection();
                wards.remove(w);
                questions.remove(q);
                
                q.setWardtbCollection(wards);
                w.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    //QUESTION ZONE
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionZone(int qid, Collection<Integer> zone_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Zonetb> zones = q.getZonetbCollection();
        
        for(Integer zid : zone_ids)
        {
            Zonetb z = (Zonetb) em.find(Zonetb.class, zid);
           if(!zones.contains(z))
            {
                Collection<Questiontb> questions = z.getQuestiontbCollection();
                zones.add(z);
                questions.add(q);
                
                q.setZonetbCollection(zones);
                z.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    @RolesAllowed("admin")
    @Override
    public void deleteZoneQuestion(int qid, Collection<Integer> zone_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Zonetb> zones = q.getZonetbCollection();
        
        for(Integer zid : zone_ids)
        {
            Zonetb z = (Zonetb) em.find(Zonetb.class, zid);
           if(zones.contains(z))
            {
                Collection<Questiontb> questions = z.getQuestiontbCollection();
                zones.remove(z);
                questions.remove(q);
                
                q.setZonetbCollection(zones);
                z.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    //QUESTION TALUKA
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionTaluka(int qid, Collection<Integer> taluka_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Talukatb> talukas = q.getTalukatbCollection();
        
        for(Integer tid : taluka_ids)
        {
            Talukatb t = (Talukatb) em.find(Talukatb.class, tid);
           if(!talukas.contains(t))
            {
                Collection<Questiontb> questions = t.getQuestiontbCollection();
                talukas.add(t);
                questions.add(q);
                
                q.setTalukatbCollection(talukas);
                t.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }
    
    @RolesAllowed("admin")
    @Override
    public void deleteTalukaQuestion(int qid, Collection<Integer> taluka_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Talukatb> talukas = q.getTalukatbCollection();
        
        for(Integer tid : taluka_ids)
        {
            Talukatb t = (Talukatb) em.find(Talukatb.class, tid);
           if(talukas.contains(t))
            {
                Collection<Questiontb> questions = t.getQuestiontbCollection();
                talukas.remove(t);
                questions.remove(q);
                
                q.setTalukatbCollection(talukas);
                t.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }


// QUESTION VILLAGE
    
    @RolesAllowed("admin")
    @Override
    public void addQuestionVillage(int qid, Collection<Integer> village_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Villagetb> villages = q.getVillagetbCollection();
        
        for(Integer vid : village_ids)
        {
            Villagetb v = (Villagetb) em.find(Villagetb.class, vid);
           if(!villages.contains(v))
            {
                Collection<Questiontb> questions = v.getQuestiontbCollection();
                villages.add(v);
                questions.add(q);
                
                q.setVillagetbCollection(villages);
                v.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }

    @RolesAllowed("admin")
    @Override
    public void deleteVillageQuestion(int qid, Collection<Integer> village_ids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<Villagetb> villages = q.getVillagetbCollection();
        
        for(Integer vid : village_ids)
        {
            Villagetb v = (Villagetb) em.find(Villagetb.class, vid);
           if(villages.contains(v))
            {
                Collection<Questiontb> questions = v.getQuestiontbCollection();
                villages.remove(v);
                questions.remove(q);
                
                q.setVillagetbCollection(villages);
                v.setQuestiontbCollection(questions);
                
                em.merge(q);
            }
        }
    }
}