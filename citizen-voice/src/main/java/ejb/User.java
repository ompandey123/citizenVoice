/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ompan
 */
@Stateless
public class User implements UserLocal {
    @PersistenceContext(unitName = "citizenpu")
    EntityManager em;
    
    
    @Override
    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, int village_id, int taluka_id, int zone_id, int city_id, int district_id, int state_id, int ward_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void giveAnswer(int qid, int user_id, int option_id, int state_id, int district_id, int city_id, int ward_id, int zone_id, int taluka_id, int village_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
