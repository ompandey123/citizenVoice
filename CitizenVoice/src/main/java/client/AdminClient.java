/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AdminResource [admin]<br>
 * USAGE:
 * <pre>
 *        AdminClient client = new AdminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author ompan
 */
public class AdminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/CitizenVoice/resources";

    public AdminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new MyRestFilter());
        webTarget = client.target(BASE_URI).path("admin");
    }
    
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }

    public void updateCity(String city_id, String district_id, String state_id, String city_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCity/{0}/{1}/{2}/{3}", new Object[]{city_id, district_id, state_id, city_name})).request().post(null);
    }

    public void deleteDistrict(String district_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteDistrict/{0}", new Object[]{district_id})).request().delete();
    }

    public <T> T getAllVillages(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllVillages");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getQuestionsByTaluka(Class<T> responseType, String talukaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByTaluka/{0}", new Object[]{talukaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUser(String username, String password, String email, String adhaar_card_no, String contact, String contact1, String gender, String address, String dob, String zip_code, String village_id, String taluka_id, String zone_id, String city_id, String district_id, String state_id, String ward_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}", new Object[]{username, password, email, adhaar_card_no, contact, contact1, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id})).request().post(null);
    }

    public void addStates(String state_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addStates/{0}", new Object[]{state_name})).request().post(null);
    }

    public <T> T getTalukaByName(Class<T> responseType, String taluka_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getTalukaByName/{0}", new Object[]{taluka_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTaluka(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllTaluka");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getWardsByZone(Class<T> responseType, String zone_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getWardsByZone/{0}", new Object[]{zone_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCitiesByDistrict(Class<T> responseType, String district_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCitiesByDistrict/{0}", new Object[]{district_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateQuestion(String qid, String category_id, String question, String level, String option1, String option2, String option3, String option4) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateQuestion/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{qid, category_id, question, level, option1, option2, option3, option4})).request().post(null);
    }

    public <T> T getQuestionsByLevel(Class<T> responseType, String level) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByLevel/{0}", new Object[]{level}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCity(String city_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCity/{0}", new Object[]{city_id})).request().delete();
    }

    public void deleteQuestion(String qid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteQuestion/{0}", new Object[]{qid})).request().delete();
    }

    public <T> T getVillagesByTaluka(Class<T> responseType, String taluka_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getVillagesByTaluka/{0}", new Object[]{taluka_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsersByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsersByUsername(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsersByContact(Class<T> responseType, String contact) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByContact/{0}", new Object[]{contact}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getDistrictByState(Class<T> responseType, String state_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getDistrictByState/{0}", new Object[]{state_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCity(String district_id, String city_name, String state_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCity/{0}/{1}/{2}", new Object[]{district_id, city_name, state_id})).request().post(null);
    }

    public void updateTaluka(String taluka_id, String district_id, String taluka_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTaluka/{0}/{1}/{2}", new Object[]{taluka_id, district_id, taluka_name})).request().post(null);
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

    public void updateWard(String ward_id, String zone_id, String ward_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateWard/{0}/{1}/{2}", new Object[]{ward_id, zone_id, ward_name})).request().post(null);
    }

    public void deleteVillage(String village_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteVillage/{0}", new Object[]{village_id})).request().delete();
    }

    public <T> T getQuestionsByVillage(Class<T> responseType, String village) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByVillage/{0}", new Object[]{village}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addTaluka(String district_id, String taluka_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTaluka/{0}/{1}", new Object[]{district_id, taluka_name})).request().post(null);
    }

    public <T> T getQuestionsByZone(Class<T> responseType, String zoneid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByZone/{0}", new Object[]{zoneid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getQuestionsByDistrict(Class<T> responseType, String districtid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByDistrict/{0}", new Object[]{districtid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStats(Class<T> responseType, String qid, String level, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStats/{0}/{1}/{2}", new Object[]{qid, level, pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getQuestionsByCity(Class<T> responseType, String cityid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByCity/{0}", new Object[]{cityid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteZone(String zone_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteZone/{0}", new Object[]{zone_id})).request().delete();
    }

    public void addQuestion(Object requestEntity, String category_id, String question, String level, String option1, String option2, String option3, String option4) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addQuestion/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{category_id, question, level, option1, option2, option3, option4})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateZone(String zone_id, String city_id, String zone_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateZone/{0}/{1}/{2}", new Object[]{zone_id, city_id, zone_name})).request().post(null);
    }

    public <T> T getQuestionByCategories(Class<T> responseType, String catid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByCategory/{0}", new Object[]{catid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteTaluka(String taluka_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTaluka/{0}", new Object[]{taluka_id})).request().delete();
    }

    public <T> T getQuestionsByWard(Class<T> responseType, String wardid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByWard/{0}", new Object[]{wardid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllQuestions(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllQuestions");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getQuestionsByState(Class<T> responseType, String stateid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionsByState/{0}", new Object[]{stateid}));
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
        resource = resource.path(java.text.MessageFormat.format("getCitiesName/{0}", new Object[]{city_name}));
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
        resource = resource.path(java.text.MessageFormat.format("getWardByName/{0}", new Object[]{ward_name}));
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
        webTarget.path(java.text.MessageFormat.format("addVillage/{0}/{1}", new Object[]{taluka_id, village_name})).request().post(null);
    }

    public <T> T getQuestionById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser(String user_id, String email, String contact, String contact1, String gender, String address, String dob, String zip_code) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{user_id, email, contact, contact1, gender, address, dob, zip_code})).request().post(null);
    }

    public <T> T getUsersById(Class<T> responseType, String user_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersById/{0}", new Object[]{user_id}));
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

    public <T> T getZonesByCity(Class<T> responseType, String city_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getZonesByCity/{0}", new Object[]{city_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCategories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategories");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getTalukaByDistrict(Class<T> responseType, String district_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getTalukaByDistrict/{0}", new Object[]{district_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStatesByName(Class<T> responseType, String state_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStatesByName/{0}", new Object[]{state_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getVillageByName(Class<T> responseType, String village_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getVillageByName/{0}", new Object[]{village_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
