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
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @EJB AdminLocal adl;
//    @EJB UserLocal usl;
    
    //User Operations
    
//    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public void giveAnswer(int qid, int user_id, int option_id, int state_id, int district_id, int city_id, int ward_id, int zone_id, int taluka_id, int village_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    //Admin Operations
    @POST
    @Path("addUser/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void addUser(@PathParam("username") String username,@PathParam("password") String password,@PathParam("email") String email,@PathParam("adhaar_card_no") String adhaar_card_no,@PathParam("contact") String contact,@PathParam("gender") String gender,@PathParam("address") String address,@PathParam("dob") Date dob,@PathParam("zip_code") String zip_code,@PathParam("village_id") int village_id,@PathParam("taluka_id") int taluka_id,@PathParam("zone_id") int zone_id,@PathParam("city_id") int city_id,@PathParam("district_id") int district_id,@PathParam("state_id") int state_id,@PathParam("ward_id") int ward_id) {
        adl.addUser(username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id);
    }

    @POST
    @Path("updateUser/{user_id}/{username}/{password}/{email}/{adhaar_card_no}/{contact}/{gender}/{address}/{dob}/{zip_code}/{village_id}/{taluka_id}/{zone_id}/{city_id}/{district_id}/{state_id}/{ward_id}")
    public void updateUser(@PathParam("user_id") int user_id,@PathParam("username") String username,@PathParam("password") String password,@PathParam("email") String email,@PathParam("adhaar_card_no") String adhaar_card_no,@PathParam("contact") String contact,@PathParam("gender") String gender,@PathParam("address") String address,@PathParam("dob") Date dob,@PathParam("zip_code") String zip_code,@PathParam("village_id") int village_id,@PathParam("taluka_id") int taluka_id,@PathParam("zone_id") int zone_id,@PathParam("city_id") int city_id,@PathParam("district_id") int district_id,@PathParam("state_id") int state_id,@PathParam("ward_id") int ward_id) {
        adl.updateUser(user_id, username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id);
    }

    @DELETE
    @Path("deleteUser/{user_id}")
    public void deleteUser(@PathParam("user_id")int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteUser(user_id);
    }

    @GET
    @Produces("application/json")
    public Collection<Usertb> getAllUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllUsers();
    }
    
    @GET
    @Path("getUserByUsername/{username}")
    @Produces("application/json")
    public Collection<Usertb> getUsersByUsername(@PathParam("username") String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersByUsername(username);
    }

    @GET
    @Path("getUserByUserId/{user_id}")
    @Produces("application/json")
    public Collection<Usertb> getUsersById(@PathParam("user_id") int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersById(user_id);
    }

    @GET
    @Path("getUserByEmail/{email}")
    @Produces("application/json")
    public Collection<Usertb> getUsersByEmail(@PathParam("email") String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersByEmail(email);
    }

    @GET
    @Path("getUserByContact/{contact}")
    @Produces("application/json")
    public Collection<Usertb> getUsersByContact(@PathParam("contact") String contact) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getUsersByContact(contact);
    }
    
    
    // STATE OPERATIONS
    
    @POST
    @Path("addStates/{state_name}")
    public void addStates(@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.addStates(state_name);
    }

    @POST
    @Path("updateState/{state_id}/{state_name}")
    public void updateState(@PathParam("state_id") int state_id,@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateState(state_id, state_name);
    }

    @DELETE
    @Path("deleteState/{state_id}")
    public void deleteState(int state_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.deleteState(state_id);
    }

    @GET
    @Path("getAllStates")
    @Produces("application/json")
    public Collection<Statetb> getAllStates() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllStates();
    }

    @GET
    @Path("getStateByName/{state_name}")
    @Produces("application/json")
    public Collection<Statetb> getStatesByName(@PathParam("state_name") String state_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getStatesByName(state_name);
    }
    
    // DISTRICT OPERATIONS

    @POST
    @Path("addDistrict/{state_id}/{district_name}")
    public void addDistricts(@PathParam("state_id") int state_id,@PathParam("district_name") String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.addDistricts(state_id, district_name);
    }

    
    @POST
    @Path("updateDistrict/{district_id}/{state_id}/{district_name}")
    public void updateDistrict(@PathParam("district_id")int district_id,@PathParam("state_id") int state_id,@PathParam("district_name") String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateDistrict(district_id, state_id, district_name);
    }

    
    @DELETE
    @Path("deleteDistrict/{district_id}")
    public void deleteDistrict(@PathParam("district_id") int district_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteDistrict(district_id);
    }

    
    @GET
    @Path("getAllDistricts")
    @Produces("application/json")
    public Collection<Districttb> getAllDistricts() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllDistricts();
    }


    @GET
    @Path("getDistrictByName/{district_name}")
    public Collection<Districttb> getDistrictsByName(@PathParam("district_name") String district_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getDistrictsByName(district_name);
    }
    
    // CITY OPERATIONS
    
    @POST
    @Path("addCity/{district_id}/{city_name}")
    public void addCity(@PathParam("district_id")int district_id,@PathParam("") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.addCity(district_id, city_name);
        
    }

    @POST
    @Path("addCity/{city_id}/{district_id}/{city_name}")
    public void updateCity(@PathParam("city_id") int city_id, @PathParam("district_id")int district_id,@PathParam("") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateCity(city_id, district_id, city_name);
    }

    @DELETE
    @Path("deleteDistrict/{district_id}")
    public void deleteCity(@PathParam("city_id") int city_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       adl.deleteCity(city_id);
    }

    @GET
    @Path("getAllCities")
    @Produces("application/json")
    public Collection<Citytb> getAllCities() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllCities();
    }

    @GET
    @Path("getCityByName/{city_name}")
    @Produces("application/json")
    public Collection<Citytb> getCitiesByName(@PathParam("city_name") String city_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getCitiesByName(city_name);
    }
    
    // ZONE OPERATIONS
    
    @POST
    @Path("addZone/{city_id}/{zone_name}")
    public void addZone(@PathParam("city_id")int city_id,@PathParam("zone_name") String zone_name) {
        adl.addZone(city_id, zone_name);
    }
    
   
    @POST
    @Path("updateZone/{zone_id}/{city_id}/{zone_name}")
    public void updateZone(@PathParam("zone_id") int zone_id, @PathParam("city_id")int city_id,@PathParam("zone_name") String zone_name) {
       adl.updateZone(zone_id, city_id, zone_name);
    }

    @DELETE
    @Path("deleteZone/{zone_id}")
    public void deleteZone(@PathParam("zone_id") int zone_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteZone(zone_id);
    }

    @GET
    @Path("getAllZones")
    @Produces("application/json")
    public Collection<Zonetb> getAllZones() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllZones();
    }

    @GET
    @Path("getZoneByName/{zone_name}")
    @Produces("application/json")
    public Collection<Zonetb> getZoneByName(@PathParam("zone_name") String zone_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      return adl.getZoneByName(zone_name);
    }
    
    //WARD OPEARTIONS
    
    @POST
    @Path("addZone/{zone_id}/{ward_name}")
    public void addWard(@PathParam("zone_id") int zone_id,@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        adl.addWard(zone_id, ward_name);
   }


    @POST
    @Path("updateZone/{ward_id}/{zone_id}/{ward_name}")
    public void updateWard(@PathParam("ward_id") int ward_id, @PathParam("zone_id") int zone_id,@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateWard(ward_id, zone_id, ward_name);
    }

    @DELETE
    @Path("deleteWard/{ward_id}") 
    public void deleteWard(@PathParam("ward_id") int ward_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteWard(ward_id);
    }

 
    @GET
    @Produces("application/json")
    @Path("getAllWards")
    public Collection<Wardtb> getAllWards() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllWards();
    }

    @GET
    @Produces("application/json")
    @Path("getAllWardsByName/{ward_name}")
    public Collection<Wardtb> getWardByName(@PathParam("ward_name") String ward_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         return adl.getWardByName(ward_name);
    }
    
    // TALUKA OPERATIONS
    
    @POST
    @Path("addTaluka/{district_id/{taluka_name}}")
    public void addTaluka(@PathParam("district_id") int district_id,@PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.addTaluka(district_id, taluka_name);
    }

    @POST
    @Path("updateTaluka/{taluka_id}/{district_id/{taluka_name}}")
    public void updateTaluka(@PathParam("taluka_id") int taluka_id, @PathParam("district_id") int district_id,@PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateTaluka(taluka_id, district_id, taluka_name);
    }

    @DELETE
    @Path("deleteTaluka/{taluka_id}")
    public void deleteTaluka(@PathParam("taluka_id") int taluka_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteTaluka(taluka_id);
    }
    
    @GET
    @Path("getAllTaluka")
    @Produces("application/json")
    public Collection<Talukatb> getAllTaluka() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllTaluka();
    }
    
    @GET
    @Path("getAllTalukaByName/{taluka_name}")
    @Produces("application/json")
    public Collection<Talukatb> getTalukaByName(@PathParam("taluka_name") String taluka_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return adl.getTalukaByName(taluka_name);
    }

    //VILLAGE OOPERATION
    
    @POST
    @Path("addvillage/{taluka_id}/{village_name}")
    public void addVillage(@PathParam("taluka_id") int taluka_id,@PathParam("village_name") String village_name) {
        adl.addVillage(taluka_id, village_name);
    }
    
    
    @POST
    @Path("updateVillage/{village_id}/{taluka_id}/{village_name}")
    public void updateVillage(@PathParam("village_id") int village_id, @PathParam("taluka_id") int taluka_id,@PathParam("village_name") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateCity(taluka_id, village_id, village_name);
    }

    @DELETE
    @Path("deleteVillage/{village_id}")
    public void deleteVillage(@PathParam("village_id") int village_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         adl.deleteVillage(village_id);
    }

    @GET
    @Path("getAllVillages")
    @Produces("application/json")
    public Collection<Villagetb> getAllVillages() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllVillages();
    }

    @GET
    @Path("getAllVillageByName/{village_name}")
    @Produces("application/json")
    public Collection<Villagetb> getVillageByName(@PathParam("village_id") String village_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getVillageByName(village_name);
    }
    
    //QUESTION OPERATION
    
    @POST
    @Consumes("application/json")
    @Path("addQuestion/{question}/{level}/{option1}/{option2}/{option3}/{option4}")
    public void addQuestion(@PathParam("question") String question,@PathParam("level") String level,@PathParam("option1") String option1,@PathParam("option2") String option2,@PathParam("option3") String option3,@PathParam("option4") String option4, PackedObjects p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.addQuestion(question, level, option1, option2, option3, option4, p);
    }
    
    @POST
    @Consumes("application/json")
    @Path("updateQuestion/{qid}/{question}/{level}/{option1}/{option2}/{option3}/{option4}")
    public void updateQuestion(@PathParam("qid") int qid, @PathParam("question") String question,@PathParam("level") String level,@PathParam("option1") String option1,@PathParam("option2") String option2,@PathParam("option3") String option3,@PathParam("option4") String option4, PackedObjects p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.updateQuestion(qid, question, level, option1, option2, option3, option4, p);
    }

    @DELETE
    @Path("deleteQuestion/{qid}")
    public void deleteQuestion(int qid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        adl.deleteQuestion(qid);
    }

    @GET
    @Path("getAllQuestions")
    @Produces("app;ication/json")
    public Collection<Questiontb> getAllQuestions() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return adl.getAllQuestions();
    }
}
