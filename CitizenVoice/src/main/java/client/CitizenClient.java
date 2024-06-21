/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:CitizenResource [citizen]<br>
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
    private static final String BASE_URI = "https://localhost:8181/CitizenVoice/resources";

    public CitizenClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new MyRestFilter());
        webTarget = client.target(BASE_URI).path("citizen");
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

    public <T> T getStats(Class<T> responseType, String qid, String level, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStats/{0}/{1}/{2}", new Object[]{qid, level, pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void giveAnswer(String qid, String user_id, String option1, String option2, String option3, String option4, String state_id, String district_id, String city_id, String ward_id, String zone_id, String taluka_id, String village_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("giveAnswer/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{qid, user_id, option1, option2, option3, option4, state_id, district_id, city_id, ward_id, zone_id, taluka_id, village_id})).request().post(null);
    }

    public <T> T getQuestionByUserId(Class<T> responseType, String user_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionByUserId/{0}", new Object[]{user_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserById(Class<T> responseType, String userid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserById/{0}", new Object[]{userid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePassword(String user_id, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePassword/{0}/{1}", new Object[]{user_id, password})).request().post(null);
    }

    public <T> T checkPhone(Class<T> responseType, String contact) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("checkPhone/{0}", new Object[]{contact}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getQuestionById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQuestionById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T checkUsername(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("checkUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser(String user_id, String email, String contact, String gender, String address, String dob, String zip_code) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{user_id, email, contact, gender, address, dob, zip_code})).request().post(null);
    }

    public String getPasswordByEmail(String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPasswordByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public <T> T getIdByUsername(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getIdByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public void RegisterUser(String username, String password, String email, String adhaar_card_no, String contact, String gender, String address, String dob, String zip_code, String village_id, String taluka_id, String zone_id, String city_id, String district_id, String state_id, String ward_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("RegisterUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}", new Object[]{username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village_id, taluka_id, zone_id, city_id, district_id, state_id, ward_id})).request().post(null);
    }

    public <T> T checkEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("checkEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
