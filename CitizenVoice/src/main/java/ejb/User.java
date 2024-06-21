/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Category;
import entities.Citytb;
import entities.Districttb;
import entities.Forgotpassword;
import entities.Groups;
import entities.Questiontb;
import entities.Statetb;
import entities.Talukatb;
import entities.UserAnswer;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
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
    String msg;
    
    @RolesAllowed({"admin","citizen"})
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
        
        Groups g = new Groups();
            g.setGroupname("citizen");
            g.setUsername(username);
            em.persist(g);
            
            Forgotpassword f = new Forgotpassword();
            f.setEmail(email);
            f.setPassword(password);
            em.persist(f);
        
        }catch(Exception e)
        {
            System.out.println("Error in Inserting");
            e.printStackTrace();
        }
    }

    @RolesAllowed("citizen")
    @Override
    public void giveAnswer(int qid, int user_id,  String option1, String option2, String option3, String option4 , int state_id, int district_id, int city_id, int ward_id, int zone_id, int taluka_id, int village_id) {
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
        
        Category cat = q.getCategoryid();
        Collection<UserAnswer> canswers = cat.getUserAnswerCollection();
        
        UserAnswer ua = new UserAnswer();
        
        ua.setOption1(option1);
        ua.setOption2(option2);
        ua.setOption3(option3);
        ua.setOption4(option4);
        ua.setLevel(q.getLevel());
        
        ua.setQid(q);
        
        ua.setCategoryid(cat);
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
        
        qanswers.add(ua);
        q.setUserAnswerCollection(uanswers);
        
        uanswers.add(ua);
        u.setUserAnswerCollection(uanswers);
        
        canswers.add(ua);
        cat.setUserAnswerCollection(uanswers);
        
         em.merge(v);
        em.merge(t);
        em.merge(z);
        em.merge(c);
        em.merge(d);
        em.merge(s);
        em.merge(w);
        em.merge(q);
        em.merge(u);
        em.merge(cat);
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
         //System.out.println("uderid in method "+ user_id);
        Usertb u = (Usertb) em.find(Usertb.class, user_id);
         Collection<UserAnswer> uans = u.getUserAnswerCollection();
         
        Statetb sid = u.getStateId();
        Collection<Questiontb> statequestions =  sid.getQuestiontbCollection();
        userquestionCollection.addAll(statequestions);
        
        Districttb did = u.getDistrictId();
        Collection<Questiontb> distquestions =  did.getQuestiontbCollection();
        userquestionCollection.addAll(distquestions);
        
        Citytb cid = u.getCityId();
        if(cid!=null)
        {
        Collection<Questiontb> cityQuestion =  cid.getQuestiontbCollection();
        userquestionCollection.addAll(cityQuestion);
        }
        
        Wardtb wid = u.getWardId();
        if(wid!=null){
        Collection<Questiontb> wardQuestion =  wid.getQuestiontbCollection();
        userquestionCollection.addAll(wardQuestion);
        }
        
        Zonetb zid = u.getZoneId();
        if(zid!=null)
        {
        Collection<Questiontb> zoneQuestion =  zid.getQuestiontbCollection();
        userquestionCollection.addAll(zoneQuestion);
        }
        
        Talukatb tid = u.getTalukaId();
        if(tid!=null)
        {
        Collection<Questiontb> talukaQuestion =  tid.getQuestiontbCollection();
        userquestionCollection.addAll(talukaQuestion);
        }
        
        Villagetb vid = u.getVillageId();
        if(vid!=null)
        {
        Collection<Questiontb> villageQuestion =  vid.getQuestiontbCollection();
        userquestionCollection.addAll(villageQuestion);
        }
        
        Collection<Questiontb> finalQuestionCollection = new ArrayList<>();
        
       
        for(UserAnswer ua : uans)
        {
              System.out.println("in ua");
           if(userquestionCollection.contains(ua.getQid())) 
           {
                 System.out.println("in condition");
               userquestionCollection.remove(ua.getQid());
           }
            
            
        }
        
        
       return userquestionCollection; 
    }

    @RolesAllowed("citizen")
    @Override
    public int getIdByUsername(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
       
        Usertb user = (Usertb) em.createNamedQuery("Usertb.findByUsername").setParameter("username", username).getSingleResult();
        
        return user.getUserId();
    }

    @RolesAllowed("citizen")
    @Override
    public Usertb getUserById(int userid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Usertb user = (Usertb) em.find(Usertb.class, userid);
        return user;
    }

    @RolesAllowed("citizen")
    @Override
    public boolean checkUsername(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Usertb user =null;
        {
        try{
            user = (Usertb) em.createNamedQuery("Usertb.findByUsername").setParameter("username", username).getSingleResult();
            if(user != null)
            {
               return true;
            }
            else
            {
               return false;
            }
        }catch(Exception e)
        {
            return false;
         //  e.printStackTrace();
        }
    //return true;
    }
    }

    @RolesAllowed("citizen")
    @Override
    public boolean checkEmail(String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          Usertb user =null;
        {
        try{
            user = (Usertb) em.createNamedQuery("Usertb.findByEmail").setParameter("email", email).getSingleResult();
            if(user != null)
            {
               return true;
            }
            else
            {
               return false;
            }
        }catch(Exception e)
        {
            return false;
         //  e.printStackTrace();
        }
    //return true;
    }
    }
    

    @RolesAllowed("citizen")
    @Override
    public boolean checkPhone(String contact)
    {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Usertb user =null;
        {
        try{
            user = (Usertb) em.createNamedQuery("Usertb.findByContact").setParameter("contact", contact).getSingleResult();
            if(user != null)
            {
               return true;
            }
            else
            {
               return false;
            }
        }catch(Exception e)
        {
            return false;
         //  e.printStackTrace();
        }
    //return true;
    }
    }

    @RolesAllowed("citizen")
    @Override
    public String getPasswordByEmail(String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Forgotpassword fp = (Forgotpassword) em.createNamedQuery("Forgotpassword.findByEmail").setParameter("email", email)
                .getSingleResult();
        return fp.getPassword();
    }
    
    @RolesAllowed("citizen")
    @Override
    public void updateUser(int user_id, String email, String contact, String gender, String address, Date dob, String zip_code) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Usertb u = (Usertb) em.find(Usertb.class, user_id);

        u.setEmail(email);
        
        u.setContact(contact);
        u.setGender(gender);
        u.setAddress(address);
        u.setDob(dob);
        u.setZipCode(zip_code);
        em.merge(u);
    }
    
//    @RolesAllowed({"admin","citizen"})
//    @Override
//    public void updatePassword(int user_id, String password) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//         Pbkdf2PasswordHashImpl pb;
//        PasswordHashCompare phc;
//         pb = new Pbkdf2PasswordHashImpl();
//         Usertb u = (Usertb) em.find(Usertb.class, user_id);
//         String encpass = pb.generate(password.toCharArray());
//          u.setPassword(encpass);
//          em.merge(u);
//    }

    @RolesAllowed("citizen")
    @Override
    public void updatePassword(int user_id, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Pbkdf2PasswordHashImpl pb;
        PasswordHashCompare phc;
         pb = new Pbkdf2PasswordHashImpl();
         Usertb u = (Usertb) em.find(Usertb.class, user_id);
         String encpass = pb.generate(password.toCharArray());
          u.setPassword(encpass);
          em.merge(u);
          
          String email = u.getEmail();
          Forgotpassword f = new Forgotpassword();
          f.setEmail(email);
          f.setPassword(password);
          em.merge(f);
    }
    
    @RolesAllowed("citizen")

    @Override
    public Collection<UserAnswer> getAnswersByUserId(int userid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Usertb u = (Usertb) em.find(Usertb.class, userid);
        Collection<UserAnswer> uans = u.getUserAnswerCollection();
        return uans;
    }
    
    
    
}