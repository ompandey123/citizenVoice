/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminLocal;
import entities.Statetb;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ompan
 */
@Named(value = "stateBean")
@SessionScoped
public class StateBean implements Serializable{
    @EJB AdminLocal admin;
    String statename;
    int stateid;
    Collection<Statetb> states;
    Statetb current;

    public Collection<Statetb> getStates() {
        states = admin.getAllStates();
        return states;
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public Statetb getCurrent() {
        return current;
    }

    public void setCurrent(Statetb current) {
        this.current = current;
    }
    
    
    
    public String addStates()
    {
        System.out.println("state=" + statename);
        admin.addStates(statename);
        return "StateOperation.jsf";
    }
    
    public String deleteState(Statetb state) {
    current = state;
    stateid = current.getStateId();
        System.out.println("stateid - " + stateid);
     admin.deleteState(stateid); // Uncomment when ready to perform deletion
    return "StateOperation.jsf";
}
    
    
   
    public String updateState()
    {
        statename = current.getStateName();
        stateid = current.getStateId();
        admin.updateState(stateid, statename);
        return "StateOperation.jsf";
    }
    
     public String redirectToEdit()
    {
        System.out.println("selected = " + current.getStateName());
        return "updateState.jsf";
    }

    /**
     * Creates a new instance of StateBean
     */
    public StateBean() {
    }
    
}
