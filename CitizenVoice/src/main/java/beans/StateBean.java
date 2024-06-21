/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.AdminClient;
import ejb.AdminLocal;
import entities.Statetb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ompan
 */
@Named(value = "stateBean")
@SessionScoped
public class StateBean implements Serializable{
    @EJB AdminLocal admin;
    
    AdminClient ac;
    Response rs;
    
    String statename;
    int stateid;
    Collection<Statetb> states;
    GenericType<Collection<Statetb>> gstates;
    Statetb current;

    public Collection<Statetb> getStates() {
        rs = ac.getAllStates(Response.class);
        states = rs.readEntity(gstates);
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
        ac.addStates(statename);
        return "StateOperation.jsf";
    }
    
    public String deleteState() {
    stateid = current.getStateId();
        System.out.println("stateid - " + stateid);
        ac.deleteState(String.valueOf(stateid));
        return "StateOperation.jsf";
}
    
    
   
    public String updateState()
    {
        statename = current.getStateName();
        stateid = current.getStateId();
        ac.updateState(String.valueOf(stateid), statename);
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
        ac = new AdminClient();
        states = new ArrayList<>();
        gstates = new GenericType<Collection<Statetb>>(){};
    }
    
}
