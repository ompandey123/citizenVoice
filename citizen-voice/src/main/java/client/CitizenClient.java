/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:JakartaEE8Resource [rest]<br>
 * USAGE:
 * <pre>
 *        CitizenClient client = new CitizenClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author ompan
 */
public class CitizenClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/citizen-voice/resources";

    public CitizenClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public void updateCity(String city_id, String district_id, String state_id, String city_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCity/{0}/{1}/{2}/{3}", new Object[]{city_id, district_id, state_id, city_name})).request().post(null);
    }

    public void deleteDistrict(String district_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteDistrict/{0}", new Object[]{district_id})).request().delete();
    }

    public <T> T getAllVillages(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllVillages");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, String village_id, String taluka_id, String zone_id, String city_id, String district_id, String state_id, String ward_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id})).request().post(null);
    }

    public void addStates(String state_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addStates/{0}", new Object[]{state_name})).request().post(null);
    }

    public <T> T getTalukaByName(Class<T> responseType, String taluka_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllTalukaByName/{0}", new Object[]{taluka_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTaluka(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllTaluka");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateQuestion(Object requestEntity, String qid, String categoryid, String question, String level, String option1, String option2, String option3, String option4) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateQuestion/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{qid, categoryid, question, level, option1, option2, option3, option4})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deleteCity(String district_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCity/{0}", new Object[]{district_id})).request().delete();
    }

    public void deleteQuestion(String qid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteQuestion/{0}", new Object[]{qid})).request().delete();
    }

    public <T> T getUsersByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsersByUsername(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getQuestionByUserId(Class<T> responseType, String user_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionByUserId/{0}", new Object[]{user_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsersByContact(Class<T> responseType, String contact) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByContact/{0}", new Object[]{contact}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCity(String district_id, String state_id, String city_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCity/{0}/{1}/{2}", new Object[]{district_id, state_id, city_name})).request().post(null);
    }

    public void updateTaluka(String taluka_id, String district_id, String taluka_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTaluka/{0}/{1}/{2}", new Object[]{taluka_id, district_id, taluka_name})).request().post(null);
    }

    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, String village_id, String taluka_id, String zone_id, String city_id, String district_id, String state_id, String ward_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("registerUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id})).request().post(null);
    }

    public void addDistricts(String state_id, String district_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addDistrict/{0}/{1}", new Object[]{state_id, district_name})).request().post(null);
    }

    public <T> T getZoneByName(Class<T> responseType, String zone_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getZoneByName/{0}", new Object[]{zone_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addWard(String zone_id, String ward_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addWard/{0}/{1}", new Object[]{zone_id, ward_name})).request().post(null);
    }

    public void deleteUser(String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{user_id})).request().delete();
    }

    public void updateWard(String ward_id, String zone_id, String ward_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateWard/{0}/{1}/{2}", new Object[]{ward_id, zone_id, ward_name})).request().post(null);
    }

    public void deleteVillage(String village_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteVillage/{0}", new Object[]{village_id})).request().delete();
    }

    public void addTaluka(String district_id, String taluka_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTaluka/{0}/{1}", new Object[]{district_id, taluka_name})).request().post(null);
    }

    public void giveAnswer(String qid, String user_id, String option1, String option2, String option3, String option4, String state_id, String district_id, String city_id, String ward_id, String zone_id, String taluka_id, String village_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("giveAnswer/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{qid, user_id, option1, option2, option3, option4, state_id, district_id, city_id, ward_id, zone_id, taluka_id, village_id})).request().post(null);
    }

    public void deleteZone(String zone_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteZone/{0}", new Object[]{zone_id})).request().delete();
    }

    public void addQuestion(Object requestEntity, String categoryid, String question, String level, String option1, String option2, String option3, String option4) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addQuestion/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{categoryid, question, level, option1, option2, option3, option4})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateZone(String zone_id, String city_id, String zone_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateZone/{0}/{1}/{2}", new Object[]{zone_id, city_id, zone_name})).request().post(null);
    }

    public void deleteTaluka(String taluka_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTaluka/{0}", new Object[]{taluka_id})).request().delete();
    }

    public <T> T getAllQuestions(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllQuestions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCities(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCities");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllWards(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllWards");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCitiesByName(Class<T> responseType, String city_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCityByName/{0}", new Object[]{city_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllZones(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllZones");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteState(String state_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteState/{0}", new Object[]{state_id})).request().delete();
    }

    public void updateState(String state_id, String state_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateState/{0}/{1}", new Object[]{state_id, state_name})).request().post(null);
    }

    public void updateDistrict(String district_id, String state_id, String district_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDistrict/{0}/{1}/{2}", new Object[]{district_id, state_id, district_name})).request().post(null);
    }

    public void addZone(String city_id, String zone_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addZone/{0}/{1}", new Object[]{city_id, zone_name})).request().post(null);
    }

    public <T> T getWardByName(Class<T> responseType, String ward_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllWardsByName/{0}", new Object[]{ward_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllDistricts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllDistricts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllStates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllStates");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateVillage(String village_id, String taluka_id, String village_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateVillage/{0}/{1}/{2}", new Object[]{village_id, taluka_id, village_name})).request().post(null);
    }

    public void addVillage(String taluka_id, String village_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addvillage/{0}/{1}", new Object[]{taluka_id, village_name})).request().post(null);
    }

    public void updateUser(String user_id, String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, String village_id, String taluka_id, String zone_id, String city_id, String district_id, String state_id, String ward_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}", new Object[]{user_id, username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id})).request().post(null);
    }

    public <T> T getUsersById(Class<T> responseType, String user_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByUserId/{0}", new Object[]{user_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteWard(String ward_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteWard/{0}", new Object[]{ward_id})).request().delete();
    }

    public <T> T getDistrictsByName(Class<T> responseType, String district_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getDistrictByName/{0}", new Object[]{district_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStatesByName(Class<T> responseType, String state_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStateByName/{0}", new Object[]{state_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getVillageByName(Class<T> responseType, String village_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllVillageByName/{0}", new Object[]{village_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
