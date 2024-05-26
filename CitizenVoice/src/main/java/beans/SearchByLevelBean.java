/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Category;
import entities.Questiontb;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author ompan
 */
@Named(value = "searchByLevelBean")
@SessionScoped
public class SearchByLevelBean implements Serializable {
    @EJB AdminLocal adl;
    String level;
    Collection<Questiontb> questions;

    public AdminLocal getAdl() {
        return adl;
    }

    public void setAdl(AdminLocal adl) {
        this.adl = adl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Collection<Questiontb> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }
    /**
     * Creates a new instance of SearchByLevelBean
     */
    public SearchByLevelBean() {
    }
    
    public String getQuestionsByLevel()
    {
        if (level != null) {
        questions = adl.getQuestionsByLevel(level);
    }
        return "searchByLevel.jsf";
    }
    
}