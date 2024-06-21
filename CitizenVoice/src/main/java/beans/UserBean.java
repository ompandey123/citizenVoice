/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
import client.CitizenClient;
import ejb.AdminLocal;
import ejb.UserLocal;
import entities.Questiontb;
import entities.UserAnswer;
import entities.Usertb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import record.KeepRecord;

/**
 *
 * @author ompan
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    @EJB UserLocal ul;
    @EJB AdminLocal adl;
    
    CitizenClient cc;
    AdminClient ac;
    Response rs;
    
    String username;
    int userid;// = ul.getIdByUsername(KeepRecord.getPrincipal().getName());
    int qid;
    int categoryid;
    String answer;
    String level;
    String option1;
    String option2;
    String option3;
    String option4;
    int stateid;
    int districtid;
    int cityid;
    int wardid;
    int zoneid;
    int talukaid;
    int villageid;
    Usertb current;
    String password;
    String email;
    String adhaar_card_no;
    String contact;
    String gender;
    String address;
    Date dob;
    String zip_code;
    String pwd;
    String cpwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhaar_card_no() {
        return adhaar_card_no;
    }

    public void setAdhaar_card_no(String adhaar_card_no) {
        this.adhaar_card_no = adhaar_card_no;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    
    
    public Usertb getCurrent() {
        return current;
    }

    public void setCurrent(Usertb current) {
        this.current = current;
    }
    
    

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    Collection<Questiontb> questions;
    GenericType<Collection<Questiontb>> gquestions;
//    Collection<UserAnswer> userAnswers;

    public String getUsername() {
        username = KeepRecord.getPrincipal().getName();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
//         userid = ul.getIdByUsername(KeepRecord.getPrincipal().getName());
        userid = cc.getIdByUsername(Response.class, KeepRecord.getPrincipal().getName()).readEntity(Integer.class);
        
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Collection<Questiontb> getQuestions() {
//        questions = ul.getQuestionByUserId(ul.getIdByUsername(KeepRecord.getPrincipal().getName()));
        questions = cc.getQuestionByUserId(Response.class, String.valueOf(cc.getIdByUsername(Response.class, KeepRecord.getPrincipal().getName()).readEntity(Integer.class))).readEntity(gquestions);
        
        return questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }

    public UserLocal getUl() {
        return ul;
    }

    public void setUl(UserLocal ul) {
        this.ul = ul;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
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

    public int getStateid() {
//        userid = ul.getIdByUsername(username);
        Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
        stateid = user.getStateId().getStateId();
        return stateid;
    }
    
    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public int getDistrictid() {
        Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
        districtid = user.getDistrictId().getDistrictId();
        return districtid;
    }

    public void setDistrictid(int districtid) {
        this.districtid = districtid;
    }

    public int getCityid() {
         Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
         if(user.getCityId()!=null)
         {
         cityid = user.getCityId().getCityId();
         }
         else{
             cityid=0;
         }
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getWardid() {
         Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
         if(user.getWardId()!=null){
         wardid = user.getWardId().getWardId();
         }
         else
         {
             wardid = 0;
         }
        return wardid;
    }

    public void setWardid(int wardid) {
        this.wardid = wardid;
    }

    public int getZoneid() {
         Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
         if(user.getZoneId()!=null)
         {
         zoneid = user.getZoneId().getZoneId();
         }
         else
         {
             zoneid = 0;
         }
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getTalukaid() {
         Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
         if(user.getTalukaId()!=null){
         talukaid = user.getTalukaId().getTalukaId();
         }
         else{
             talukaid=0;
         }
         
        return talukaid;
    }

    public void setTalukaid(int talukaid) {
        this.talukaid = talukaid;
    }

    public int getVillageid() {
         Usertb user = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);
         if(user.getVillageId()!=null)
         {
         villageid = user.getVillageId().getVillageId();
         }
         else
         {
             villageid = 0;
         }
        return villageid;
    }

    public void setVillageid(int villageid) {
        this.villageid = villageid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

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
    
    
    
    
//    public String giveAnswer()
//    {
////        ul.giveAnswer(qid, userid, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
////        return "User.jsf";
//        
//    }
    public void ans(int qid)
    {
        option1="x";
        option2="x";
        option3="x";
        option4="x";
        
        System.out.println("answerr = " + answer);
        System.out.println("answerr = " + answer.substring(0,7));
        if(answer.substring(0,7).equals("option1"))
        {
            option1= answer.substring(8,answer.length());
            //System.out.println("option1 = " + option1);
        }
         if(answer.substring(0,7).equals("option2"))
        {
            option2= answer.substring(8,answer.length());
          //  System.out.println("option2 = " + option1);
        }
          if(answer.substring(0,7).equals("option3"))
        {
            option3= answer.substring(8,answer.length());
          //  System.out.println("option3 = " + option1);
        }
           if(answer.substring(0,7).equals("option4"))
        {
            option4= answer.substring(8,answer.length());
           // System.out.println("option4 = " + option1);
        }
           
           System.out.println("option1 = " + option1);
           System.out.println("option2 = " + option2);
           System.out.println("option3 = " + option3);
           System.out.println("option4 = " + option4);
           
           level = getLevel();
           userid=getUserid();
           categoryid = getCategoryid();
           stateid=getStateid();
           districtid=getDistrictid();
           cityid=(getCityid()>0)?getCityid():0;
           wardid=(getWardid()>0)?getWardid():0;
           zoneid=(getZoneid()>0)?getZoneid():0;
           talukaid=(getTalukaid()>0)?getTalukaid():0;
           villageid=(getVillageid()>0)?getVillageid():0;
           System.out.println(qid + " " + userid + " " + option4 + " " + stateid + " " + level + " " + categoryid);
//           ul.giveAnswer(qid, userid, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
           //ul.giveAnswer(qid, categoryid, userid, level, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
            // ul.giveAnswer(qid,  userid, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
            cc.giveAnswer(String.valueOf(qid), String.valueOf(userid), option1, option2, option3, option4, String.valueOf(stateid), String.valueOf(districtid), String.valueOf(cityid), String.valueOf(wardid), String.valueOf(zoneid), String.valueOf(talukaid), String.valueOf(villageid));
    }
    
    
    public String redirectToProfile()
    {
        userid = getUserid();
    current = ul.getUserById(userid);
    // Setting the current user's properties
    setEmail(current.getEmail());
    setContact(current.getContact());
    setGender(current.getGender());
    setAddress(current.getAddress());
    setDob(current.getDob());
    setZip_code(current.getZipCode());
        return "userProfile.jsf";
    }
    
    public String updateUser()
    {
        
         int userId = getUserid();
    
    // Retrieve the current user from the database using the user ID
    Usertb currentUser = ul.getUserById(userId);
    
    // Update the current user's details with the form field values
    currentUser.setEmail(email);
    currentUser.setContact(contact);
    currentUser.setGender(gender);
    currentUser.setAddress(address);
    currentUser.setDob(dob);
    currentUser.setZipCode(zip_code);
       adl.updateUser(userid, current.getEmail(), current.getContact(), current.getGender(), current.getAddress(), current.getDob(), current.getZipCode());
       // cc.updateUser(String.valueOf(userId), email, contact, gender, address, pwd, zip_code);
        return "userProfile.jsf";
    }
    
    public String redirectToChangePassword()
    {
        userid = getUserid();
    current = cc.getUserById(Response.class, String.valueOf(userid)).readEntity(Usertb.class);

    // Setting the current user's properties
    setPassword(current.getPassword());
        return "user/changePassword.jsf";
    }
    
    public String updatePassword() {
    // Get the current user ID
    int userId = getUserid();
    
    // Get the current user from the database using the user ID
    Usertb currentUser = ul.getUserById(userId);
    
    // Set the new password to the current user
    currentUser.setPassword(pwd); // Assuming pwd is the new password input
    
    // Call the method in your AdminLocal EJB to update the password
//    adl.updatePassword(userId, pwd); // Assuming adl.updatePassword(int userId, String newPassword) method exists
      cc.updatePassword(String.valueOf(userId), password);
    // Optionally, you might want to clear the password fields after the update
    ul.updatePassword(userId, pwd);
    pwd = "";
    cpwd = "";
    
    // Redirect to the user profile page after updating the password
    return "userProfile.jsf";
}
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
      cc = new CitizenClient();
      questions = new ArrayList<>();
      gquestions= new GenericType<Collection<Questiontb>>(){};
    }
    
}
