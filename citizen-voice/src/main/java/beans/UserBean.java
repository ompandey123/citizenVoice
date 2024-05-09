/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.UserLocal;
import entities.Questiontb;
import entities.UserAnswer;
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
        System.out.println("uderid "+ ul.getIdByUsername(KeepRecord.getPrincipal().getName()));
        questions = ul.getQuestionByUserId(ul.getIdByUsername(KeepRecord.getPrincipal().getName()));
        return questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }
    
    
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
      
    }
    
}
