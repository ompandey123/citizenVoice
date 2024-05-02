/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ompan
 */
@Entity
@Table(name = "usertb")
@NamedQueries({
    @NamedQuery(name = "Usertb.findAll", query = "SELECT u FROM Usertb u"),
    @NamedQuery(name = "Usertb.findByUserId", query = "SELECT u FROM Usertb u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usertb.findByUsername", query = "SELECT u FROM Usertb u WHERE u.username = :username"),
    @NamedQuery(name = "Usertb.findByPassword", query = "SELECT u FROM Usertb u WHERE u.password = :password"),
    @NamedQuery(name = "Usertb.findByEmail", query = "SELECT u FROM Usertb u WHERE u.email = :email"),
    @NamedQuery(name = "Usertb.findByAdhaarCardNo", query = "SELECT u FROM Usertb u WHERE u.adhaarCardNo = :adhaarCardNo"),
    @NamedQuery(name = "Usertb.findByContact", query = "SELECT u FROM Usertb u WHERE u.contact = :contact"),
    @NamedQuery(name = "Usertb.findByGender", query = "SELECT u FROM Usertb u WHERE u.gender = :gender"),
    @NamedQuery(name = "Usertb.findByAddress", query = "SELECT u FROM Usertb u WHERE u.address = :address"),
    @NamedQuery(name = "Usertb.findByDob", query = "SELECT u FROM Usertb u WHERE u.dob = :dob"),
    @NamedQuery(name = "Usertb.findByZipCode", query = "SELECT u FROM Usertb u WHERE u.zipCode = :zipCode")})
public class Usertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "adhaar_card_no")
    private String adhaarCardNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserGroup> userGroupCollection;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private Citytb cityId;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;
    @JoinColumn(name = "taluka_id", referencedColumnName = "taluka_id")
    @ManyToOne(optional = false)
    private Talukatb talukaId;
    @JoinColumn(name = "village_id", referencedColumnName = "village_id")
    @ManyToOne(optional = false)
    private Villagetb villageId;
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    @ManyToOne(optional = false)
    private Wardtb wardId;
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private Zonetb zoneId;

    public Usertb() {
    }

    public Usertb(Integer userId) {
        this.userId = userId;
    }

    public Usertb(Integer userId, String username, String password, String email, String adhaarCardNo, String contact, String gender, String address, Date dob, String zipCode) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.adhaarCardNo = adhaarCardNo;
        this.contact = contact;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.zipCode = zipCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhaarCardNo() {
        return adhaarCardNo;
    }

    public void setAdhaarCardNo(String adhaarCardNo) {
        this.adhaarCardNo = adhaarCardNo;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
    }

    public Collection<UserGroup> getUserGroupCollection() {
        return userGroupCollection;
    }

    public void setUserGroupCollection(Collection<UserGroup> userGroupCollection) {
        this.userGroupCollection = userGroupCollection;
    }

    public Citytb getCityId() {
        return cityId;
    }

    public void setCityId(Citytb cityId) {
        this.cityId = cityId;
    }

    public Districttb getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districttb districtId) {
        this.districtId = districtId;
    }

    public Statetb getStateId() {
        return stateId;
    }

    public void setStateId(Statetb stateId) {
        this.stateId = stateId;
    }

    public Talukatb getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(Talukatb talukaId) {
        this.talukaId = talukaId;
    }

    public Villagetb getVillageId() {
        return villageId;
    }

    public void setVillageId(Villagetb villageId) {
        this.villageId = villageId;
    }

    public Wardtb getWardId() {
        return wardId;
    }

    public void setWardId(Wardtb wardId) {
        this.wardId = wardId;
    }

    public Zonetb getZoneId() {
        return zoneId;
    }

    public void setZoneId(Zonetb zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertb)) {
            return false;
        }
        Usertb other = (Usertb) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usertb[ userId=" + userId + " ]";
    }
    
}
