/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
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

/**
 *
 * @author ompan
 */
@Entity
@Table(name = "question_city")
@NamedQueries({
    @NamedQuery(name = "QuestionCity.findAll", query = "SELECT q FROM QuestionCity q"),
    @NamedQuery(name = "QuestionCity.findByQuestionCityId", query = "SELECT q FROM QuestionCity q WHERE q.questionCityId = :questionCityId")})
public class QuestionCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_city_id")
    private Integer questionCityId;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private Citytb cityId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;

    public QuestionCity() {
    }

    public QuestionCity(Integer questionCityId) {
        this.questionCityId = questionCityId;
    }

    public Integer getQuestionCityId() {
        return questionCityId;
    }

    public void setQuestionCityId(Integer questionCityId) {
        this.questionCityId = questionCityId;
    }

    public Districttb getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districttb districtId) {
        this.districtId = districtId;
    }

    public Citytb getCityId() {
        return cityId;
    }

    public void setCityId(Citytb cityId) {
        this.cityId = cityId;
    }

    public Statetb getStateId() {
        return stateId;
    }

    public void setStateId(Statetb stateId) {
        this.stateId = stateId;
    }

    public Questiontb getQid() {
        return qid;
    }

    public void setQid(Questiontb qid) {
        this.qid = qid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionCityId != null ? questionCityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionCity)) {
            return false;
        }
        QuestionCity other = (QuestionCity) object;
        if ((this.questionCityId == null && other.questionCityId != null) || (this.questionCityId != null && !this.questionCityId.equals(other.questionCityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionCity[ questionCityId=" + questionCityId + " ]";
    }
    
}
