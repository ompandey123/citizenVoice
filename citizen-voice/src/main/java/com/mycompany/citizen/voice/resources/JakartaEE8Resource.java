package com.mycompany.citizen.voice.resources;

import ejb.AdminLocal;
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
}
