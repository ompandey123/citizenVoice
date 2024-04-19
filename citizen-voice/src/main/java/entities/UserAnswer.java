/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "user_answer")
@NamedQueries({
    @NamedQuery(name = "UserAnswer.findAll", query = "SELECT u FROM UserAnswer u"),
    @NamedQuery(name = "UserAnswer.findByAnswerId", query = "SELECT u FROM UserAnswer u WHERE u.answerId = :answerId"),
    @NamedQuery(name = "UserAnswer.findByOption1", query = "SELECT u FROM UserAnswer u WHERE u.option1 = :option1"),
    @NamedQuery(name = "UserAnswer.findByOption2", query = "SELECT u FROM UserAnswer u WHERE u.option2 = :option2"),
    @NamedQuery(name = "UserAnswer.findByOption3", query = "SELECT u FROM UserAnswer u WHERE u.option3 = :option3"),
    @NamedQuery(name = "UserAnswer.findByOption4", query = "SELECT u FROM UserAnswer u WHERE u.option4 = :option4"),
    @NamedQuery(name = "UserAnswer.findBySubTime", query = "SELECT u FROM UserAnswer u WHERE u.subTime = :subTime")})
public class UserAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "answer_id")
    private Integer answerId;
    @Size(max = 2000)
    @Column(name = "option1")
    private String option1;
    @Size(max = 2000)
    @Column(name = "option2")
    private String option2;
    @Size(max = 2000)
    @Column(name = "option3")
    private String option3;
    @Size(max = 2000)
    @Column(name = "option4")
    private String option4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SubTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subTime;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
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
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Usertb userId;
    @JoinColumn(name = "village_id", referencedColumnName = "village_id")
    @ManyToOne(optional = false)
    private Villagetb villageId;
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    @ManyToOne(optional = false)
    private Wardtb wardId;
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private Zonetb zoneId;

    public UserAnswer() {
    }

    public UserAnswer(Integer answerId) {
        this.answerId = answerId;
    }

    public UserAnswer(Integer answerId, Date subTime) {
        this.answerId = answerId;
        this.subTime = subTime;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public Questiontb getQid() {
        return qid;
    }

    public void setQid(Questiontb qid) {
        this.qid = qid;
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

    public Usertb getUserId() {
        return userId;
    }

    public void setUserId(Usertb userId) {
        this.userId = userId;
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
        hash += (answerId != null ? answerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAnswer)) {
            return false;
        }
        UserAnswer other = (UserAnswer) object;
        if ((this.answerId == null && other.answerId != null) || (this.answerId != null && !this.answerId.equals(other.answerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserAnswer[ answerId=" + answerId + " ]";
    }
    
}
