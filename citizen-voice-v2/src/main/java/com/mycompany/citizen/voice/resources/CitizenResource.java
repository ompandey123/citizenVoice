/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.citizen.voice.resources;

import beans.StatsData;
import ejb.UserLocal;
import entities.Questiontb;
import entities.Usertb;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import stats.AnswerStats;

/**
 * REST Web Service
 *
 * @author ompan
 */
@Path("citizen")
@RequestScoped
public class CitizenResource {
    @EJB UserLocal ul;
    @EJB AnswerStats as;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CitizenResource
     */
    public CitizenResource() {
    }

    @PermitAll
    @POST
    @Path("RegisterUser/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ul.RegisterUser(username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id);
    }

    @RolesAllowed("citizen")
    @POST
    @Path("giveAnswer/{qid}/{user_id}/{option1}/{option2}/{option3}/{option4}/{state_id}/{district_id}/{city_id}/{ward_id}/{zone_id}/{taluka_id}/{village_id}")
    public void giveAnswer(@PathParam("qid") int qid, @PathParam("user_id") int user_id, @PathParam("option1") String option1, @PathParam("option2") String option2, @PathParam("option3") String option3, @PathParam("option4") String option4 , @PathParam("state_id") int state_id, @PathParam("district_id") int district_id, @PathParam("city_id") int city_id, @PathParam("ward_id") int ward_id, @PathParam("zone_id") int zone_id, @PathParam("taluka_id") int taluka_id, @PathParam("village_id") int village_id) {
        ul.giveAnswer(qid, user_id, option1, option2, option3, option4, state_id, district_id, city_id, ward_id, zone_id, taluka_id, village_id);
          
    }

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("getQuestionByUserId/{user_id}")
    public Collection<Questiontb> getQuestionByUserId(@PathParam("user_id") int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      return ul.getQuestionByUserId(user_id);
    }

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("getIdByUsername/{username}")
    public int getIdByUsername(@PathParam("username") String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return ul.getIdByUsername(username);
       
    }

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("getUserById/{userid}")
    public Usertb getUserById(@PathParam("userid") int userid) {
        return ul.getUserById(userid);
    }

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("checkUsername/{username}")
    public boolean checkUsername(@PathParam("username") String username) {
        return ul.checkUsername(username);
    }

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("checkEmail/{email}")
    public boolean checkEmail(@PathParam("email") String email) {
        return ul.checkEmail(email);
    }
    

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("checkPhone/{contact}")
    public boolean checkPhone(@PathParam("contact") String contact)
    {
        return ul.checkPhone(contact);
    }

    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("getPasswordByEmail/{email}")
    public String getPasswordByEmail(@PathParam("email") String email) {
       return ul.getPasswordByEmail(email);
    }
    
    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionById/{id}")
    public Questiontb getQuestionById(@PathParam("id") int id) {
        return as.getQuestionById(id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getStats/{qid}/{level}/{pid}")
    public Collection<StatsData> getStats(@PathParam("qid") int qid, @PathParam("level") String level, @PathParam("pid") Integer pid) {
        return as.getStats(qid, level, pid);
    }
    
    @RolesAllowed("citizen")
    @POST
    @Path("updateUser/{user_id}/{email}/{contact}/{contact}/{gender}/{address}/{dob}/{zip_code}")
    public void updateUser(@PathParam("user_id") int user_id, @PathParam("email") String email, @PathParam("contact") String contact, @PathParam("gender") String gender, @PathParam("address") String address, @PathParam("dob") Date dob, @PathParam("zip_code") String zip_code) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ul.updateUser(user_id, email, contact, gender, address, dob, zip_code);
    }
}
