/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.citizen.voice.resources;

import beans.StatsData;
import ejb.AdminLocal;
import ejb.PackedObjects;
import entities.Category;
import entities.Citytb;
import entities.Districttb;
import entities.Questiontb;
import entities.Statetb;
import entities.Talukatb;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@DeclareRoles({"admin", "citizen"})
@Path("admin")
public class AdminResource {
    @EJB AdminLocal al;
    @EJB AnswerStats as;
    @Context
    private UriInfo context;
    
    public AdminResource() {
    }
    
   
    @PermitAll
    @POST
    @Path("addUser/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void addUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, @PathParam("adhaar_card_no") String adhaar_card_no, @PathParam("contact") String contact, @PathParam("gender") String gender, @PathParam("address") String address, @PathParam("dob") Date dob, @PathParam("zip_code") String zip_code, @PathParam("village_id") int village_id, @PathParam("taluka_id") int taluka_id, @PathParam("zone_id") int zone_id, @PathParam("city_id") int city_id, @PathParam("district_id") int district_id, @PathParam("state_id") int state_id, @PathParam("ward_id") int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.addUser(username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id); 
    }
    
    @PermitAll
    @POST
    @Path("updateUser/{user_id}/{email}/{contact}/{contact}/{gender}/{address}/{dob}/{zip_code}")
    public void updateUser(@PathParam("user_id") int user_id, @PathParam("email") String email, @PathParam("contact") String contact, @PathParam("gender") String gender, @PathParam("address") String address, @PathParam("dob") Date dob, @PathParam("zip_code") String zip_code) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.updateUser(user_id, email, contact, gender, address, dob, zip_code);
    }
    
    @RolesAllowed("admin")
    @GET
    @Produces("application/json")
    @Path("getAllUsers")
    public Collection<Usertb> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllUsers();
    }
    
    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getUsersByUsername/{username}")
    public Collection<Usertb> getUsersByUsername(@PathParam("username") String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            return al.getUsersByUsername(username);
        }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getUsersById/{user_id}")
    public Collection<Usertb> getUsersById(@PathParam("user_id") int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getUsersById(user_id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getUserByEmail/{email}")
    public Collection<Usertb> getUsersByEmail(@PathParam("email") String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getUsersByEmail(email);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getUsersByContact/{contact}")
    public Collection<Usertb> getUsersByContact(@PathParam("contact") String contact) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getUsersByContact(contact);
    }
    
    //state
    @RolesAllowed("admin")
    @POST
    @Path("addStates/{state_name}")
    public void addStates(@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.addStates(state_name);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateState/{state_id}/{state_name}")
    public void updateState(@PathParam("state_id") int state_id, @PathParam("state_name") String state_name) {
        al.updateState(state_id, state_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteState/{state_id}")
    public void deleteState(@PathParam("state_id") int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       al.deleteState(state_id);
    }
    
    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllStates")
    public Collection<Statetb> getAllStates() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllStates();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getStatesByName/{state_name}")
    public Collection<Statetb> getStatesByName(@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getStatesByName(state_name);
    }
    
    //district
    
    @RolesAllowed("admin")
    @POST
    @Path("addDistrict/{state_id}/{district_name}")
    public void addDistricts(@PathParam("state_id") int state_id, @PathParam("district_name") String district_name) {
        al.addDistricts(state_id, district_name);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateDistrict/{district_id}/{state_id}/{district_name}")
    public void updateDistrict(@PathParam("district_id") int district_id, @PathParam("state_id") int state_id, @PathParam("district_name") String district_name) {
            al.updateDistrict(district_id, state_id, district_name);
    }

    @RolesAllowed("admin") 
    @DELETE
    @Path("deleteDistrict/{district_id}")
    public void deleteDistrict(@PathParam("district_id") int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       al.deleteDistrict(district_id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllDistricts")
    public Collection<Districttb> getAllDistricts() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllDistricts();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getDistrictByName/{district_name}")
    public Collection<Districttb> getDistrictsByName(@PathParam("district_name") String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getDistrictsByName(district_name);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getDistrictByState/{state_id}")
    public Collection<Districttb> getDistrictByState(@PathParam("state_id") int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getDistrictByState(state_id);
    }
    
    //City
    
    @RolesAllowed("admin")
    @POST
    @Path("addCity/{district_id}/{city_name}/{state_id}")
    public void addCity(@PathParam("district_id") int district_id, @PathParam("city_name") String city_name, @PathParam("state_id") int state_id) {
        al.addCity(district_id, city_name, state_id);
        
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateCity/{city_id}/{district_id}/{state_id}/{city_name}")
    public void updateCity(@PathParam("city_id") int city_id, @PathParam("district_id") int district_id, @PathParam("state_id") int state_id, @PathParam("city_name") String city_name) {
        al.updateCity(city_id, district_id, state_id, city_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteCity/{city_id}")
    public void deleteCity(@PathParam("city_id") int city_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.deleteCity(city_id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllCities")
    public Collection<Citytb> getAllCities() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllCities();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getCitiesName/{city_name}")
    public Collection<Citytb> getCitiesByName(@PathParam("city_name") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getCitiesByName(city_name);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getCitiesByDistrict/{district_id}")
    public Collection<Citytb> getCitiesByDistrict(@PathParam("district_id") int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getCitiesByDistrict(district_id);
    }
    
    //Zone
    
    @RolesAllowed("admin")
    @POST
    @Path("addZone/{city_id}/{zone_name}")
    public void addZone(@PathParam("city_id") int city_id, @PathParam("zone_name") String zone_name) {
        al.addZone(city_id, zone_name);
    }

    @RolesAllowed("admin") 
    @POST
    @Path("updateZone/{zone_id}/{city_id}/{zone_name}")
    public void updateZone(@PathParam("zone_id") int zone_id, @PathParam("city_id") int city_id, @PathParam("zone_name") String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.updateZone(zone_id, city_id, zone_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteZone/{zone_id}")
    public void deleteZone(@PathParam("zone_id") int zone_id) {
       al.deleteZone(zone_id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllZones")
    public Collection<Zonetb> getAllZones() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllZones();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getZoneByName/{zone_name}")
    public Collection<Zonetb> getZoneByName(@PathParam("zone_name") String zone_name) {
        return al.getZoneByName(zone_name);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getZonesByCity/{city_id}")
    public Collection<Zonetb> getZonesByCity(@PathParam("city_id") int city_id) {
        return al.getZonesByCity(city_id);
    }
    
    //Ward
    
    @RolesAllowed("admin")
    @POST
    @Path("addWard/{zone_id}/{ward_name}")
    public void addWard(@PathParam("zone_id") int zone_id, @PathParam("ward_name") String ward_name) {
        al.addWard(zone_id, ward_name);
        
   }

    @RolesAllowed("admin")
    @POST
    @Path("updateWard/{ward_id}/{zone_id}/{ward_name}")
    public void updateWard(@PathParam("ward_id") int ward_id, @PathParam("zone_id") int zone_id, @PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.updateWard(ward_id, zone_id, ward_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteWard/{ward_id}")
    public void deleteWard(@PathParam("ward_id") int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         al.deleteWard(ward_id);
    }

    @PermitAll 
    @GET
    @Produces("application/json")
    @Path("getAllWards")
    public Collection<Wardtb> getAllWards() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllWards();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getWardByName/{ward_name}")
    public Collection<Wardtb> getWardByName(@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         return al.getWardByName(ward_name);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getWardsByZone/{zone_id}")
    public Collection<Wardtb> getWardsByZone(@PathParam("zone_id") int zone_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getWardsByZone(zone_id);
    }
    
    //Taluka
    
    @RolesAllowed("admin")
    @POST
    @Path("addTaluka/{district_id}/{taluka_name}")
    public void addTaluka(@PathParam("district_id") int district_id, @PathParam("taluka_name") String taluka_name) {
        al.addTaluka(district_id, taluka_name);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateTaluka/{taluka_id}/{district_id}/{taluka_name}")
    public void updateTaluka(@PathParam("taluka_id") int taluka_id, @PathParam("district_id") int district_id, @PathParam("taluka_name") String taluka_name) {
        al.updateTaluka(taluka_id, district_id, taluka_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteTaluka/{taluka_id}")
    public void deleteTaluka(@PathParam("taluka_id") int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.deleteTaluka(taluka_id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getTalukaByDistrict/{district_id}")
    public Collection<Talukatb> getTalukaByDistrict(@PathParam("district_id") int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getTalukaByDistrict(district_id);
    }    
    
    
    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllTaluka")
    public Collection<Talukatb> getAllTaluka() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllTaluka();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getTalukaByName/{taluka_name}")
    public Collection<Talukatb> getTalukaByName(@PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getTalukaByName(taluka_name);
    }

    @RolesAllowed("admin")
    @POST
    @Path("addVillage/{taluka_id}/{village_name}")
    public void addVillage(@PathParam("taluka_id") int taluka_id, @PathParam("village_name") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.addVillage(taluka_id, village_name);
    }
    
    @RolesAllowed("admin")
    @POST
    @Path("updateVillage/{village_id}/{taluka_id}/{village_name}")
    public void updateVillage(@PathParam("village_id") int village_id, @PathParam("taluka_id") int taluka_id, @PathParam("village_name") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.updateVillage(village_id, taluka_id, village_name);
    }
    
    @RolesAllowed("admin")
    @DELETE
    @Path("deleteVillage/{village_id}")
    public void deleteVillage(@PathParam("village_id") int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         al.deleteVillage(village_id);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllVillages")
    public Collection<Villagetb> getAllVillages() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getAllVillages();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getVillageByName/{village_name}")
    public Collection<Villagetb> getVillageByName(@PathParam("village_name") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getVillageByName(village_name);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getVillagesByTaluka/{taluka_id}")
    public Collection<Villagetb> getVillagesByTaluka(@PathParam("taluka_id") int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getVillagesByTaluka(taluka_id);
    }
    
    //Questions
    @RolesAllowed("admin")
    @POST
    @Consumes("application/json")
    @Path("addQuestion/{category_id}/{question}/{level}/{option1}/{option2}/{option3}/{option4}/{p}")
    public void addQuestion(@PathParam("category_id") int categoryid, @PathParam("question") String question, @PathParam("level") String level, @PathParam("option1") String option1, @PathParam("option2") String option2,@PathParam("option3") String option3, @PathParam("option4") String option4, @PathParam("p") PackedObjects p) {
        al.addQuestion(categoryid, question, level, option1, option2, option3, option4, p);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateQuestion/{qid}/{category_id}/{question}/{level}/{option1}/{option2}/{option3}/{option4}/{p}")
    public void updateQuestion(@PathParam("qid") int qid, @PathParam("category_id") int categoryid, @PathParam("question") String question, @PathParam("level") String level, @PathParam("option1") String option1, @PathParam("option2") String option2,@PathParam("option3") String option3, @PathParam("option4") String option4) {
        al.updateQuestion(qid, categoryid, question, level, option1, option2, option3, option4);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteQuestion/{qid}")
    public void deleteQuestion(@PathParam("qid") int qid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        al.deleteQuestion(qid);
    }
    
    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllQuestions")
    public Collection<Questiontb> getAllQuestions() {
        return al.getAllQuestions();
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByState/{stateid}")
    public Collection<Questiontb> getQuestionsByState(@PathParam("stateid") int stateid) {
        return al.getQuestionsByState(stateid);
    }

    @PermitAll 
    @GET
    @Produces("application/json")
    @Path("getQuestionsByDistrict/{districtid}")
    public Collection<Questiontb> getQuestionsByDistrict(@PathParam("districtid") int districtid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return al.getQuestionsByDistrict(districtid);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByCity/{cityid}")
    public Collection<Questiontb> getQuestionsByCity(@PathParam("cityid") int cityid) {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getQuestionsByCity(cityid);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByZone/{zoneid}")
    public Collection<Questiontb> getQuestionsByZone(@PathParam("zoneid") int zoneid) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          return al.getQuestionsByZone(zoneid);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByWard/{wardid}")
    public Collection<Questiontb> getQuestionsByWard(@PathParam("wardid") int wardid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getQuestionsByWard(wardid);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByTaluka/{talukaid}")
    public Collection<Questiontb> getQuestionsByTaluka(@PathParam("talukaid") int talukaid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getQuestionsByTaluka(talukaid);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByVillage/{village}")
    public Collection<Questiontb> getQuestionsByVillage(@PathParam("villageid") int villageid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getQuestionsByVillage(villageid);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByLevel/{level}")
    public Collection<Questiontb> getQuestionsByLevel(@PathParam("level") String level) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getQuestionsByLevel(level);
    }

    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getQuestionsByCategory/{catid}")
    public Collection<Questiontb> getQuestionByCategories(@PathParam("catid") int catid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return al.getQuestionByCategories(catid);
    }

 
    @PermitAll
    @GET
    @Produces("application/json")
    @Path("getAllCategories")
    public Collection<Category> getAllCategories()
    {
        return al.getAllCategories();
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
}
