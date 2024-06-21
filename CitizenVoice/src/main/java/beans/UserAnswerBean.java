/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.UserLocal;
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
@Named(value = "userAnswerBean")
@SessionScoped
public class UserAnswerBean implements Serializable {

    @EJB UserLocal ul;
    int userid;
    Collection<UserAnswer> answers;
    
    public UserAnswerBean() {
    }

    public int getUserid() {
        userid = ul.getIdByUsername(KeepRecord.getPrincipal().getName());
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Collection<UserAnswer> getAnswers() {
        answers = ul.getAnswersByUserId(ul.getIdByUsername(KeepRecord.getPrincipal().getName()));
        return answers;
    }

    public void setAnswers(Collection<UserAnswer> answers) {
        this.answers = answers;
    }
    
    
    
}
