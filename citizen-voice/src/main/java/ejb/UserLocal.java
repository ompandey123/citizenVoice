/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author ompan
 */
@Local
public interface UserLocal {
    void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id);
    void giveAnswer(int qid, int user_id, int option_id, int state_id, int district_id, int city_id, int ward_id, int zone_id, int taluka_id, int village_id);
}
