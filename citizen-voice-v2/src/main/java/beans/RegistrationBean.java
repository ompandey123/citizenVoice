/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.mycompany.citizen.voice.resources.JakartaEE8Resource;
import ejb.AdminLocal;
import ejb.UserLocal;
import entities.Citytb;
import entities.Districttb;
import entities.Statetb;
import entities.Talukatb;
import entities.Usertb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ompan
 */
@Named(value = "registrationBean")
@SessionScoped
public class RegistrationBean implements Serializable {
    @EJB AdminLocal admin;
    @EJB UserLocal ul;
    String username;
    String password;
    String email;
    String adhaar_card_no;
    String contact;
    String gender;
    String address;
    Date dob;
    String zip_code;
    
    int userid;
    int state;
    int district;
    int city;
    int taluka;
    int village;
    int zone;
    int ward;
    String myDate;
    
    Statetb stateid;
    Districttb districtid;
    Citytb cityid;
    Zonetb zoneid;
    Wardtb wardid;
    Talukatb talukaid;
    Villagetb villageid;
    
    OTP otp;
    String otpsend;
    String otpentered;
    String message; 
    String otpmsg;
    boolean userok=false;
    boolean emailok=false;
    boolean phoneok=false;
//    String msg;
    
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Citytb> cities;
    Collection<Talukatb> talukas;
    Collection<Villagetb> villages;
    Collection<Zonetb> zones;
    Collection<Wardtb> wards;
    Collection<Usertb> users;
    Usertb current;
    

    /**
     * Creates a new instance of RegistrationBean
     */
    
    
    public RegistrationBean() {
    }


    

    public void checkUname(FacesContext ctx, UIComponent cmp, Object obj)
    {
        username = (String) obj;
        if(ul.checkUsername(username))
        {
            FacesMessage msg = new FacesMessage("Username already exists");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    public void checkEmail(FacesContext ctx, UIComponent cmp, Object obj)
    {
        email = (String) obj;
        if(ul.checkEmail(email))
        {
            FacesMessage msg = new FacesMessage("Email already exists");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    public void checkContact(FacesContext ctx, UIComponent cmp, Object obj)
    {
        contact = (String) obj;
        if(ul.checkPhone(contact))
        {
            FacesMessage msg = new FacesMessage("Contact already exists");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    
    public OTP getOtp() {
        return otp;
    }

    public void setOtp(OTP otp) {
        this.otp = otp;
    }

    public String getOtpsend() {
        return otpsend;
    }

    public void setOtpsend(String otpsend) {
        this.otpsend = otpsend;
    }

    public String getOtpentered() {
        return otpentered;
    }

    public void setOtpentered(String otpentered) {
        this.otpentered = otpentered;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOtpmsg() {
        return otpmsg;
    }

    public void setOtpmsg(String otpmsg) {
        this.otpmsg = otpmsg;
    }

    public void sendOtp()
    {
        otp = new OTP();
        otpsend = otp.generateOTP(4);
        otpmsg = "This OTP is for your verification " + otpsend + ". This OTP is valid only for 30 minutes";
        sendMail(otpmsg);
    }
    
    public void compareOTP()
    {
        System.out.println(otpentered + "---" + otpsend);
        if(!otpentered.equals(otpsend))
        {
            message = "OTP dosen't match, Please try again or request new OTP";
        }
        
        else
        {
            message = "User Verified Succesfully";
        }
    }
    
    public void sendMail(String msg)
   {
       
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "ompandey037@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "ypetldqyixnrfetu");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("OTP Sent from citizen voice");

            // Now set the actual message
            message.setText(msg);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

}
    
    public Statetb getStateid() {
        return stateid;
    }

    public void setStateid(Statetb stateid) {
        this.stateid = stateid;
    }

    public Districttb getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Districttb districtid) {
        this.districtid = districtid;
    }

    public Citytb getCityid() {
        return cityid;
    }

    public void setCityid(Citytb cityid) {
        this.cityid = cityid;
    }

    public Zonetb getZoneid() {
        return zoneid;
    }

    public void setZoneid(Zonetb zoneid) {
        this.zoneid = zoneid;
    }

    public Wardtb getWardid() {
        return wardid;
    }

    public void setWardid(Wardtb wardid) {
        this.wardid = wardid;
    }

    public Talukatb getTalukaid() {
        return talukaid;
    }

    public void setTalukaid(Talukatb talukaid) {
        this.talukaid = talukaid;
    }

    public Villagetb getVillageid() {
        return villageid;
    }

    public void setVillageid(Villagetb villageid) {
        this.villageid = villageid;
    }

    
    
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Usertb getCurrent() {
        return current;
    }

    public void setCurrent(Usertb current) {
        this.current = current;
    }
    
    

    public Collection<Usertb> getUsers() {
        users = admin.getAllUsers();
        return users;
    }

    public void setUsers(Collection<Usertb> users) {
        this.users = users;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminLocal getAdmin() {
        return admin;
    }

    public void setAdmin(AdminLocal admin) {
        this.admin = admin;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getTaluka() {
        return taluka;
    }

    public void setTaluka(int taluka) {
        this.taluka = taluka;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    
    
    public Collection<Statetb> getStates() {
        return admin.getAllStates();
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public Collection<Districttb> getDistricts() {
        if(state != 0){
      return admin.getDistrictByState(state);
        }
        return null;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public Collection<Citytb> getCities() {
        if(district != 0){
        return admin.getCitiesByDistrict(district);
        }
        return null;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Talukatb> getTalukas() {
        
        if(district != 0){
        return admin.getTalukaByDistrict(district);
        }
        return null;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }

    public Collection<Villagetb> getVillages() {
        if(taluka != 0){
        return admin.getVillagesByTaluka(taluka);
        }
        return null;
    }

    public void setVillages(Collection<Villagetb> villages) {
        
        this.villages = villages;
    }
    
    public Collection<Zonetb> getZones() {
        if(city != 0){
        return admin.getZonesByCity(city);
        }
        return null;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards() {
        if(zone != 0)
        {
        return admin.getWardsByZone(zone);
        }
        return null;
    }

    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhaar_card_no() {
        return adhaar_card_no;
    }

    public void setAdhaar_card_no(String adhaar_card_no) {
        this.adhaar_card_no = adhaar_card_no;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getMyDate() {
        return myDate;
    }

    public void setMyDate(String myDate) {
        this.myDate = myDate;
    }
    
    
    
    public String registerUser()
    {
//    {
//        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
//              Date dt = null;
//        try {
//            dob = sdt.parse(myDate);
//        } catch (ParseException ex) {
//            Logger.getLogger(JakartaEE8Resource.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
                System.out.println(username + " " + password + " " + email + " " + adhaar_card_no + " " + contact + " " + gender + " " + address + " " + dob + " " + zip_code + " " + village + " " + taluka + " " + zone + " " + city + " " + district + " " + state + " " + ward);
        admin.addUser(username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village, taluka, zone, city, district, state, ward);
       
        return "Admin.jsf";
    }
    
    public String addUser()
    {
//    {
//        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
//              Date dt = null;
//        try {
//            dob = sdt.parse(myDate);
//        } catch (ParseException ex) {
//            Logger.getLogger(JakartaEE8Resource.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //System.out.println(otpentered + "---" + otpsend);
        
        
        if(!otpentered.equals(otpsend))
        {
            message = "OTP dosen't match, Please try again or request new OTP";
        }
        
        else
        {
            System.out.println(username + " " + password + " " + email + " " + adhaar_card_no + " " + contact + " " + gender + " " + address + " " + dob + " " + zip_code + " " + village + " " + taluka + " " + zone + " " + city + " " + district + " " + state + " " + ward);
       
            
        admin.addUser(username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village, taluka, zone, city, district, state, ward);
       
        return "/MyHome.jsf";
        }
                return "/MyHome.jsf";
    }
    
    
//    public String updateUser()
//    {
//        userid = current.getUserId();
//        username = current.getUsername();
//        password = current.getPassword();
//        email = current.getEmail();
//        adhaar_card_no = current.getAdhaarCardNo();
//        contact = current.getContact();
//        gender = current.getGender();
//        address = current.getAddress();
//        dob = current.getDob();
//        zip_code = current.getZipCode();
//        state = current.getStateId().getStateId();
//        district = current.getDistrictId().getDistrictId();
//        taluka = current.getTalukaId().getTalukaId();
//        village = current.getVillageId().getVillageId();
//        city = current.getCityId().getCityId();
//        zone = current.getZoneId().getZoneId();
//        ward = current.getWardId().getWardId();
//        admin.updateUser(userid, username, password, email, adhaar_card_no, contact, gender, address, dob, zip_code, village, taluka, zone, city, district, state, ward);
//        return "UserOperation.jsf";
//    }
    
    
}
