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
import entities.UserAnswer;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import java.util.ArrayList;
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
public class User implements UserLocal {
    @PersistenceContext(unitName = "citizenpu")
    EntityManager em;
    
    
    @RolesAllowed("citizen")
    @Override
    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
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
        
         em.persist(u);
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
        
        }catch(Exception e)
        {
            System.out.println("Error in Inserting");
            e.printStackTrace();
        }
    }

    @RolesAllowed("citizen")
    @Override
    public void giveAnswer(int qid, int user_id, String option1, String option2, String option3, String option4 , int state_id, int district_id, int city_id, int ward_id, int zone_id, int taluka_id, int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try{
        Villagetb v = (Villagetb) em.find(Villagetb.class, village_id);
        Collection<UserAnswer> vausers = v.getUserAnswerCollection();
        
        Talukatb t = (Talukatb) em.find(Talukatb.class, taluka_id);
        Collection<UserAnswer> tausers = t.getUserAnswerCollection();
        
        Zonetb z = (Zonetb) em.find(Zonetb.class, zone_id);
        Collection<UserAnswer> zausers = z.getUserAnswerCollection();
        
        Citytb c = (Citytb) em.find(Citytb.class, city_id);
        Collection<UserAnswer> causers = c.getUserAnswerCollection();
        
        Districttb d = (Districttb) em.find(Districttb.class, district_id);
        Collection<UserAnswer> dausers = d.getUserAnswerCollection();
        
        Statetb s = (Statetb) em.find(Statetb.class, state_id);
        Collection<UserAnswer> sausers = s.getUserAnswerCollection();
        
        Wardtb w = (Wardtb) em.find(Wardtb.class, ward_id);
        Collection<UserAnswer> wausers = w.getUserAnswerCollection();
        
        Questiontb q = (Questiontb) em.find(Questiontb.class, qid);
        Collection<UserAnswer> qanswers = q.getUserAnswerCollection();
        
        Usertb u = (Usertb) em.find(Usertb.class, user_id);
        Collection<UserAnswer> uanswers = u.getUserAnswerCollection();
        
        UserAnswer ua = new UserAnswer();
        
        ua.setOption1(option1);
        ua.setOption2(option2);
        ua.setOption3(option3);
        ua.setOption4(option4);
        
        ua.setQid(q);
        ua.setUserId(u);
        ua.setStateId(s);
        ua.setDistrictId(d);
        ua.setCityId(c);
        ua.setWardId(w);
        ua.setZoneId(z);
        ua.setTalukaId(t);
        ua.setVillageId(v);
        
        vausers.add(ua);
        v.setUserAnswerCollection(vausers);
        
        tausers.add(ua);
        t.setUserAnswerCollection(tausers);
        
        zausers.add(ua);
        z.setUserAnswerCollection(zausers);
        
        causers.add(ua);
        c.setUserAnswerCollection(causers);
        
        dausers.add(ua);
        d.setUserAnswerCollection(dausers);
        
        sausers.add(ua);
        s.setUserAnswerCollection(sausers);
        
        wausers.add(ua);
        w.setUserAnswerCollection(wausers);
        
         em.merge(v);
        em.merge(t);
        em.merge(z);
        em.merge(c);
        em.merge(d);
        em.merge(s);
        em.merge(w);
        em.persist(ua);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
          
    }

    @RolesAllowed("citizen")
    @Override
    public Collection<Questiontb> getQuestionByUserId(int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Collection<Questiontb> userquestionCollection  = new ArrayList<>();
        
        Usertb u = (Usertb) em.find(Usertb.class, user_id);
        
        Statetb sid = u.getStateId();
        Collection<Questiontb> statequestions =  sid.getQuestiontbCollection();
        userquestionCollection.addAll(statequestions);
        
        Districttb did = u.getDistrictId();
        Collection<Questiontb> distquestions =  did.getQuestiontbCollection();
        userquestionCollection.addAll(distquestions);
        
        Citytb cid = u.getCityId();
        Collection<Questiontb> cityQuestion =  cid.getQuestiontbCollection();
        userquestionCollection.addAll(cityQuestion);
        
        Wardtb wid = u.getWardId();
        Collection<Questiontb> wardQuestion =  wid.getQuestiontbCollection();
        userquestionCollection.addAll(wardQuestion);
        
        Zonetb zid = u.getZoneId();
        Collection<Questiontb> zoneQuestion =  zid.getQuestiontbCollection();
        userquestionCollection.addAll(zoneQuestion);
        
        Talukatb tid = u.getTalukaId();
        Collection<Questiontb> talukaQuestion =  tid.getQuestiontbCollection();
        userquestionCollection.addAll(talukaQuestion);
        
        Villagetb vid = u.getVillageId();
        Collection<Questiontb> villageQuestion =  vid.getQuestiontbCollection();
        userquestionCollection.addAll(villageQuestion);
        
        
       return userquestionCollection; 
    }
    
}
