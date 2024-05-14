package com.mycompany.citizen.voice.resources;

import ejb.AdminLocal;
import ejb.PackedObjects;
import ejb.UserLocal;
import entities.Citytb;
import entities.Districttb;
import entities.Questiontb;
import entities.Statetb;
import entities.Talukatb;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@DeclareRoles({"admin", "citizen"})
@Path("rest")
public class JakartaEE8Resource {
    
    @EJB AdminLocal adl;
    @EJB UserLocal usl;
    
    //User Operations
    
    @RolesAllowed("citizen")
    @POST
    @Path("registerUser/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void RegisterUser(@PathParam("username") String username,@PathParam("password") String password, @PathParam("email") String email, @PathParam("adhaar_card_no") String adhaar_card_no, @PathParam("contact") String contact, @PathParam("gender") String gender, @PathParam("address") String address, @PathParam("dob") String dob, @PathParam("zip_code") String zip_code, @PathParam("village_id") int village_id, @PathParam("taluka_id") int taluka_id, @PathParam("zone_id") int zone_id, @PathParam("city_id") int city_id, @PathParam("district_id") int district_id, @PathParam("state_id") int state_id, @PathParam("ward_id") int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = null;
        try {
            dt = sdt.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(JakartaEE8Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
        usl.RegisterUser(username, password, email, adhaar_card_no, contact, gender, address, dt, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id);
    }
    
    
    
    @RolesAllowed("citizen")
    @POST
    @Path("giveAnswer/{qid}/{user_id}/{option1}/{option2}/{option3}/{option4}/{state_id}/{district_id}/{city_id}/{ward_id}/{zone_id}/{taluka_id}/{village_id}")
    public void giveAnswer(@PathParam("qid") int qid ,@PathParam("user_id") int user_id,@PathParam("option1") String option1, @PathParam("option2") String option2, @PathParam("option3") String option3, @PathParam("option4") String option4, @PathParam("state_id") int state_id, @PathParam("district_id") int district_id, @PathParam("city_id") int city_id, @PathParam("ward_id") int ward_id, @PathParam("zone_id") int zone_id, @PathParam("taluka_id") int taluka_id, @PathParam("village_id") int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        usl.giveAnswer(qid,  user_id,  option1, option2, option3, option4, state_id, district_id, city_id, ward_id, zone_id, taluka_id, village_id);
    }
    
    @RolesAllowed("citizen")
    @GET
    @Produces("application/json")
    @Path("getQuestionByUserId/{user_id}")
    public Collection<Questiontb> getQuestionByUserId(@PathParam("user_id") int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         return usl.getQuestionByUserId(user_id);
    }
    
    //Admin Operations
    @RolesAllowed("admin")
    @POST
    @Path("addUser/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void addUser(@PathParam("username") String username,@PathParam("password") String password,@PathParam("email") String email,@PathParam("adhaar_card_no") String adhaar_card_no,@PathParam("contact") String contact,@PathParam("gender") String gender,@PathParam("address") String address,@PathParam("dob") Date dob,@PathParam("zip_code") String zip_code,@PathParam("village_id") int village_id,@PathParam("taluka_id") int taluka_id,@PathParam("zone_id") int zone_id,@PathParam("city_id") int city_id,@PathParam("district_id") int district_id,@PathParam("state_id") int state_id,@PathParam("ward_id") int ward_id) {
        adl.addUser(username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateUser/{user_id}/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void updateUser(@PathParam("user_id") int user_id,@PathParam("username") String username,@PathParam("password") String password,@PathParam("email") String email,@PathParam("adhaar_card_no") String adhaar_card_no,@PathParam("contact") String contact,@PathParam("gender") String gender,@PathParam("address") String address,@PathParam("dob") Date dob,@PathParam("zip_code") String zip_code,@PathParam("village_id") int village_id,@PathParam("taluka_id") int taluka_id,@PathParam("zone_id") int zone_id,@PathParam("city_id") int city_id,@PathParam("district_id") int district_id,@PathParam("state_id") int state_id,@PathParam("ward_id") int ward_id) {
        adl.updateUser(user_id, username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteUser/{user_id}")
    public void deleteUser(@PathParam("user_id")int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteUser(user_id);
    }

    @RolesAllowed("admin")
    @GET
    @Produces("application/json")
    public Collection<Usertb> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllUsers();
    }
    
    @RolesAllowed("admin")
    @GET
    @Path("getUserByUsername/{username}")
    @Produces("application/json")
    public Collection<Usertb> getUsersByUsername(@PathParam("username") String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersByUsername(username);
    }

    @RolesAllowed("admin")
    @GET
    @Path("getUserByUserId/{user_id}")
    @Produces("application/json")
    public Collection<Usertb> getUsersById(@PathParam("user_id") int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersById(user_id);
    }

    @RolesAllowed("admin")
    @GET
    @Path("getUserByEmail/{email}")
    @Produces("application/json")
    public Collection<Usertb> getUsersByEmail(@PathParam("email") String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersByEmail(email);
    }

    @RolesAllowed("admin")
    @GET
    @Path("getUserByContact/{contact}")
    @Produces("application/json")
    public Collection<Usertb> getUsersByContact(@PathParam("contact") String contact) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersByContact(contact);
    }
    
    
    // STATE OPERATIONS
    
    @RolesAllowed("admin")
    @POST
    @Path("addStates/{state_name}")
    public void addStates(@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.addStates(state_name);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateState/{state_id}/{state_name}")
    public void updateState(@PathParam("state_id") int state_id,@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateState(state_id, state_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteState/{state_id}")
    public void deleteState(int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.deleteState(state_id);
    }

    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getAllStates")
    @Produces("application/json")
    public Collection<Statetb> getAllStates() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllStates();
    }

    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getStateByName/{state_name}")
    @Produces("application/json")
    public Collection<Statetb> getStatesByName(@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getStatesByName(state_name);
    }
    
    // DISTRICT OPERATIONS

    @RolesAllowed("admin")
    @POST
    @Path("addDistrict/{state_id}/{district_name}")
    public void addDistricts(@PathParam("state_id") int state_id,@PathParam("district_name") String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.addDistricts(state_id, district_name);
    }

    
    @RolesAllowed("admin")
    @POST
    @Path("updateDistrict/{district_id}/{state_id}/{district_name}")
    public void updateDistrict(@PathParam("district_id")int district_id,@PathParam("state_id") int state_id,@PathParam("district_name") String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateDistrict(district_id, state_id, district_name);
    }

    
    @RolesAllowed("admin")
    @DELETE
    @Path("deleteDistrict/{district_id}")
    public void deleteDistrict(@PathParam("district_id") int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteDistrict(district_id);
    }

    
    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getAllDistricts")
    @Produces("application/json")
    public Collection<Districttb> getAllDistricts() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllDistricts();
    }


    @RolesAllowed("admin")
    @GET
    @Path("getDistrictByName/{district_name}")
    @Produces("application/json")
    public Collection<Districttb> getDistrictsByName(@PathParam("district_name") String district_name) {
        return adl.getDistrictsByName(district_name);
    }
    
    // CITY OPERATIONS
    
    @RolesAllowed("admin")
    @POST
    @Path("addCity/{district_id}/{state_id}/{city_name}")
    public void addCity(@PathParam("district_id")int district_id,  @PathParam("state_id")int state_id,  @PathParam("city_name") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.addCity(district_id, city_name, state_id);
        
    }

    @RolesAllowed("admin")
    @POST
    @Path("addCity/{city_id}/{district_id}/{state_id}/{city_name}")
    public void updateCity(@PathParam("city_id") int city_id, @PathParam("district_id")int district_id,  @PathParam("state_id")int state_id,  @PathParam("city_name") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateCity(city_id, district_id, state_id, city_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteCity/{district_id}")
    public void deleteCity(@PathParam("city_id") int city_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.deleteCity(city_id);
    }

    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getAllCities")
    @Produces("application/json")
    public Collection<Citytb> getAllCities() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllCities();
    }

    @RolesAllowed("admin")
    @GET
    @Path("getCityByName/{city_name}")
    @Produces("application/json")
    public Collection<Citytb> getCitiesByName(@PathParam("city_name") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getCitiesByName(city_name);
    }
    
    // ZONE OPERATIONS
    
    @RolesAllowed("admin")
    @POST
    @Path("addZone/{city_id}/{zone_name}")
    public void addZone(@PathParam("city_id")int city_id,@PathParam("zone_name") String zone_name) {
        adl.addZone(city_id, zone_name);
    }
    
   
    @RolesAllowed("admin")
    @POST
    @Path("updateZone/{zone_id}/{city_id}/{zone_name}")
    public void updateZone(@PathParam("zone_id") int zone_id, @PathParam("city_id")int city_id,@PathParam("zone_name") String zone_name) {
       adl.updateZone(zone_id, city_id, zone_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteZone/{zone_id}")
    public void deleteZone(@PathParam("zone_id") int zone_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteZone(zone_id);
    }

    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getAllZones")
    @Produces("application/json")
    public Collection<Zonetb> getAllZones() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllZones();
    }

    @RolesAllowed("admin")
    @GET
    @Path("getZoneByName/{zone_name}")
    @Produces("application/json")
    public Collection<Zonetb> getZoneByName(@PathParam("zone_name") String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      return adl.getZoneByName(zone_name);
    }
    
    //WARD OPEARTIONS
    
    @RolesAllowed("admin")
    @POST
    @Path("addWard/{zone_id}/{ward_name}")
    public void addWard(@PathParam("zone_id") int zone_id,@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        adl.addWard(zone_id, ward_name);
   }


    @RolesAllowed("admin")
    @POST
    @Path("updateWard/{ward_id}/{zone_id}/{ward_name}")
    public void updateWard(@PathParam("ward_id") int ward_id, @PathParam("zone_id") int zone_id,@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateWard(ward_id, zone_id, ward_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteWard/{ward_id}") 
    public void deleteWard(@PathParam("ward_id") int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteWard(ward_id);
    }

 
    @RolesAllowed({"admin","citizen"})
    @GET
    @Produces("application/json")
    @Path("getAllWards")
    public Collection<Wardtb> getAllWards() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllWards();
    }

    @RolesAllowed("admin")
    @GET
    @Produces("application/json")
    @Path("getAllWardsByName/{ward_name}")
    public Collection<Wardtb> getWardByName(@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         return adl.getWardByName(ward_name);
    }
    
    // TALUKA OPERATIONS
    
    @RolesAllowed("admin")
    @POST
    @Path("addTaluka/{district_id}/{taluka_name}")
    public void addTaluka(@PathParam("district_id") int district_id, @PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.addTaluka(district_id, taluka_name);
    }

    @RolesAllowed("admin")
    @POST
    @Path("updateTaluka/{taluka_id}/{district_id}/{taluka_name}")
    public void updateTaluka(@PathParam("taluka_id") int taluka_id, @PathParam("district_id") int district_id, @PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateTaluka(taluka_id, district_id, taluka_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteTaluka/{taluka_id}")
    public void deleteTaluka(@PathParam("taluka_id") int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteTaluka(taluka_id);
    }
    
    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getAllTaluka")
    @Produces("application/json")
    public Collection<Talukatb> getAllTaluka() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllTaluka();
    }
    
    @RolesAllowed("admin")
    @GET
    @Path("getAllTalukaByName/{taluka_name}")
    @Produces("application/json")
    public Collection<Talukatb> getTalukaByName(@PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return adl.getTalukaByName(taluka_name);
    }

    //VILLAGE OOPERATION
    
    @RolesAllowed("admin")
    @POST
    @Path("addvillage/{taluka_id}/{village_name}")
    public void addVillage(@PathParam("taluka_id") int taluka_id,@PathParam("village_name") String village_name) {
        adl.addVillage(taluka_id, village_name);
    }
    
    
    @RolesAllowed("admin")
    @POST
    @Path("updateVillage/{village_id}/{taluka_id}/{village_name}")
    public void updateVillage(@PathParam("village_id") int village_id, @PathParam("taluka_id") int taluka_id,@PathParam("village_name") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            adl.updateVillage(village_id, taluka_id, village_name);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteVillage/{village_id}")
    public void deleteVillage(@PathParam("village_id") int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         adl.deleteVillage(village_id);
    }

    @RolesAllowed({"admin","citizen"})
    @GET
    @Path("getAllVillages")
    @Produces("application/json")
    public Collection<Villagetb> getAllVillages() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllVillages();
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllVillageByName/{village_name}")
    @Produces("application/json")
    public Collection<Villagetb> getVillageByName(@PathParam("village_id") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getVillageByName(village_name);
    }
    
    //QUESTION OPERATION
    
    @RolesAllowed("admin")
    @POST
    @Consumes("application/json")
    @Path("addQuestion/{categoryid}/{question}/{level}/{option1}/{option2}/{option3}/{option4}")
    public void addQuestion(@PathParam("categoryid") int categoryid, @PathParam("question") String question,@PathParam("level") String level,@PathParam("option1") String option1,@PathParam("option2") String option2,@PathParam("option3") String option3,@PathParam("option4") String option4, PackedObjects p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.addQuestion(categoryid, question, level, option1, option2, option3, option4, p);
    }
    
    @RolesAllowed("admin")
    @POST
    @Consumes("application/json")
    @Path("updateQuestion/{qid}/{categoryid}/{question}/{level}/{option1}/{option2}/{option3}/{option4}")
    public void updateQuestion(@PathParam("qid") int qid, @PathParam("categoryid") int categoryid, @PathParam("question") String question,@PathParam("level") String level,@PathParam("option1") String option1,@PathParam("option2") String option2,@PathParam("option3") String option3,@PathParam("option4") String option4, PackedObjects p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateQuestion(qid, categoryid, question, level, option1, option2, option3, option4, p);
    }

    @RolesAllowed("admin")
    @DELETE
    @Path("deleteQuestion/{qid}")
    public void deleteQuestion(int qid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteQuestion(qid);
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllQuestions")
    @Produces("application/json")
    public Collection<Questiontb> getAllQuestions() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllQuestions();
    }
}
