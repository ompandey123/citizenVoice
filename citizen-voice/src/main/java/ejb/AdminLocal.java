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
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author ompan
 */
@Local
public interface AdminLocal {
    //User related operations
    void addUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id);
    void updateUser(int user_id ,String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, Date dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id);
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
    Collection<Zonetb> getZoneByName(String zone_name);
    
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
    void addQuestion(String question, String level, String option1, String option2, String option3, String option4, PackedObjects p);
    void updateQuestion(int qid,String question, String level,String option1, String option2, String option3, String option4, PackedObjects p);
    void deleteQuestion(int qid);
    Collection<Questiontb> getAllQuestions();
  
    
    
    //Question State
    void addQuestionState(int qid, Collection<Integer> state_ids);
    void deleteStateQuestion(int qid, Collection<Integer> state_ids);
  
    
    //Question District
    void addQuestionDistrict(int qid, Collection<Integer> district_ids);
    void deleteDistrictQuestion(int qid, Collection<Integer> district_ids);
    
    
    //Question City
    void addQuestionCity(int qid, Collection<Integer> city_ids);
    void deleteCityQuestion(int qid, Collection<Integer> city_ids);
    
    //Question Ward
    void addQuestionWard(int qid, Collection<Integer> ward_ids);
    void deleteWardQuestion(int qid, Collection<Integer> ward_ids);
    
    //Question Zone
    void addQuestionZone(int qid, Collection<Integer> zone_ids);
    void deleteZoneQuestion(int qid, Collection<Integer> zone_ids);
    
    //Question Taluka
    void addQuestionTaluka(int qid, Collection<Integer> zone_ids);
    void deleteTalukaQuestion(int qid, Collection<Integer> zone_ids);
    
    
    //Question Village
    void addQuestionVillage(int qid, Collection<Integer> village_ids);
    void deleteVillageQuestion(int qid, Collection<Integer> village_ids);
}
