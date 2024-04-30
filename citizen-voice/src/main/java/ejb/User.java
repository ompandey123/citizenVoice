/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Citytb;
import entities.Districttb;
import entities.Statetb;
import entities.Talukatb;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
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
@Stateless
public class User implements UserLocal {
    @PersistenceContext(unitName = "citizenpu")
    EntityManager em;
    
    
    @Override
    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        em.persist(u);
    }

    @Override
    public void giveAnswer(int qid, int user_id, int option_id, int state_id, int district_id, int city_id, int ward_id, int zone_id, int taluka_id, int village_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
