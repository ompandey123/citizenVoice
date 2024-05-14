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
@Named(value = "searchByCategoryBean")
@SessionScoped
public class SearchByCategoryBean implements Serializable {
    @EJB AdminLocal adl;
    int categoryid;
    Collection<Questiontb> questions;
    Collection<Category> categories;

    public AdminLocal getAdl() {
        return adl;
    }

    public void setAdl(AdminLocal adl) {
        this.adl = adl;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Collection<Questiontb> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Questiontb> questions) {
        this.questions = questions;
    }

    public Collection<Category> getCategories() {
        return adl.getAllCategories();
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
    
    public String getQuestionsByCat()
    {
        if(categoryid != 0)
        {
            questions = adl.getQuestionByCategories(categoryid);
        }
        return "searchByCategory.jsf";
    }
    

    /**
     * Creates a new instance of SearchByCategoryBean
     */
    public SearchByCategoryBean() {
    }
    
}
