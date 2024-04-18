/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

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
import javax.ejb.Local;

/**
 *
 * @author ompan
 */
@Local
public interface AdminLocal {
    //User related operations
    void addUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id);
    void updateUser(int user_id ,String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id);
    void deleteUser(int user_id);
    Collection<Usertb> getAllUsers();
    Collection<Usertb> getUsersByUsername(String username);
    Collection<Usertb> getUsersById(int user_id);
    Collection<Usertb> getUsersByEmail(String email);
    Collection<Usertb> getUsersByContact(String contact);
    
    //State related operations
    void addStates(String state_name);
    void updateState(int state_id, String state_name);
    void deleteState(int state_id);
    Collection<Statetb> getAllStates();
    Collection<Statetb> getStatesByName(String state_name);
    
    //district related operations
    void addDistricts(int state_id, String district_name);
    void updateDistrict(int district_id, int state_id, String district_name);
    void deleteDistrict(int district_id);
    Collection<Districttb> getAllDistricts();
    Collection<Districttb> getDistrictsByName(String district_name);
    
    //city related operations
    void addCity(int district_id, String city_name);
    void updateCity(int city_id, int district_id, String city_name);
    void deleteCity(int city_id);
    Collection<Citytb> getAllCities();
    Collection<Citytb> getCitiesByName(String city_name);
    
    //zone related operations
    void addZone(int city_id, String zone_name);
    void updateZone(int zone_id ,int city_id, String zone_name);
    void deleteZone(int zone_id);
    Collection<Zonetb> getAllZones();
    Collection<Zonetb> getZoneByName();
    
    //ward related operations
    void addWard(int zone_id, String ward_name);
    void updateWard(int ward_id, int zone_id, String ward_name);
    void deleteWard(int ward_id);
    Collection<Wardtb> getAllWards();
    Collection<Wardtb> getWardByName(String ward_name);
    
    //taluka related operations
    void addTaluka(int district_id, String taluka_name);
    void updateTaluka(int taluka_id, int district_id, String taluka_name);
    void deleteTaluka(int taluka_id);
    Collection<Talukatb> getAllTaluka();
    Collection<Talukatb> getTalukaByName(String taluka_name);
    
    //village related operation
    void addVillage(int taluka_id, String village_name);
    void updateVillage(int village_id, int taluka_id, String village_name);
    void deleteVillage(int village_id);
    Collection<Villagetb> getAllVillages();
    Collection<Villagetb> getVillageByName(String village_name);
    
    
    //QUESTION OPERATION
    void addQuestion(String question, String state, String district, String city, String zone, String ward, String taluka, String village);
    void updateQuestion(int qid, String question, String state, String district, String city, String zone, String ward, String taluka, String village);
    void deleteQuestion(int qid);
    Collection<Questiontb> getAllQuestions();
  
    
    
    //Question State
    void addQuestionState(int qid, int state_id);
    void updateStateQuestion(int question_state_id, int qid, int state_id);
    void deleteStateQuestion(int question_state_id);
  
    
    //Question District
    void addQuestionDistrict(int qid, int state_id, int district_id);
    void updateDistrictQuestion(int question_district_id, int qid, int state_id, int district_id);
    void deleteDistrictQuestion(int question_district_id);
    
    
    //Question City
    void addQuestionCity(int qid, int state_id, int district_id, int city_id);
    void updateCityQuestion(int question_city_id, int qid, int state_id, int district_id, int city_id);
    void deleteCityQuestion(int question_city_id);
    
    //Question Ward
    void addQuestionWard(int qid, int state_id, int district_id, int city_id, int ward_id);
    void updateWardQuestion(int question_ward_id, int qid, int state_id, int district_id, int city_id, int ward_id);
    void deleteWardQuestion(int question_ward_id);
    
    //Question Zone
    void addQuestionZone(int qid, int state_id, int district_id, int city_id, int zone_id);
    void updateZoneQuestion(int question_zone_id, int qid, int state_id, int district_id, int city_id, int ward_id, int zone_id);
    void deleteZoneQuestion(int question_zone_id);
    
    //Question Taluka
    void addQuestionTaluka(int qid, int state_id, int district_id, int taluka_id);
    void updateTalukaQuestion(int question_taluka_id, int qid, int state_id, int district_id, int taluka_id);
    void deleteTalukaQuestion(int question_taluka_id);
    
    
    //Question Village
    void addQuestionVillage(int qid, int state_id, int district_id, int village_id);
    void updateVillageQuestion(int question_village_id, int qid, int state_id, int district_id, int village_id);
    void deleteVillageQuestion(int question_village_id);
}
