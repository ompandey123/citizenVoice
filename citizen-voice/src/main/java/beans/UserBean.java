/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.UserLocal;
import entities.Questiontb;
import entities.UserAnswer;
import entities.Usertb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import record.KeepRecord;

/**
 *
 * @author ompan
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    @EJB UserLocal ul;
    
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
    
    

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    Collection<Questiontb> questions;
//    Collection<UserAnswer> userAnswers;

    public String getUsername() {
        username = KeepRecord.getPrincipal().getName();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
         userid = ul.getIdByUsername(KeepRecord.getPrincipal().getName());
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Collection<Questiontb> getQuestions() {
        questions = ul.getQuestionByUserId(ul.getIdByUsername(KeepRecord.getPrincipal().getName()));
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
        Usertb user = ul.getUserById(userid);
        stateid = user.getStateId().getStateId();
        return stateid;
    }
    
    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public int getDistrictid() {
        Usertb user = ul.getUserById(userid);
        districtid = user.getDistrictId().getDistrictId();
        return districtid;
    }

    public void setDistrictid(int districtid) {
        this.districtid = districtid;
    }

    public int getCityid() {
         Usertb user = ul.getUserById(userid);
         cityid = user.getCityId().getCityId();
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getWardid() {
         Usertb user = ul.getUserById(userid);
         wardid = user.getWardId().getWardId();
        return wardid;
    }

    public void setWardid(int wardid) {
        this.wardid = wardid;
    }

    public int getZoneid() {
         Usertb user = ul.getUserById(userid);
         zoneid = user.getZoneId().getZoneId();
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getTalukaid() {
         Usertb user = ul.getUserById(userid);
         talukaid = user.getTalukaId().getTalukaId();
        return talukaid;
    }

    public void setTalukaid(int talukaid) {
        this.talukaid = talukaid;
    }

    public int getVillageid() {
         Usertb user = ul.getUserById(userid);
         villageid = user.getVillageId().getVillageId();
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
    
    
    
//    public String giveAnswer()
//    {
////        ul.giveAnswer(qid, userid, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
////        return "User.jsf";
//        
//    }
    public void ans(int qid)
    {
        option1="";
        option2="";
        option3="";
        option4="";
        
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
           cityid=getCityid();
           wardid=getWardid();
           zoneid=getZoneid();
           talukaid=getTalukaid();
           villageid=getVillageid();
           System.out.println(qid + " " + userid + " " + option4 + " " + stateid + " " + level + " " + categoryid);
//           ul.giveAnswer(qid, userid, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
           //ul.giveAnswer(qid, categoryid, userid, level, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
             ul.giveAnswer(qid,  userid, option1, option2, option3, option4, stateid, districtid, cityid, wardid, zoneid, talukaid, villageid);
    }
    
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
      
    }
    
}
