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
@Table(name = "question_district")
@NamedQueries({
    @NamedQuery(name = "QuestionDistrict.findAll", query = "SELECT q FROM QuestionDistrict q"),
    @NamedQuery(name = "QuestionDistrict.findByQuestionDistrictId", query = "SELECT q FROM QuestionDistrict q WHERE q.questionDistrictId = :questionDistrictId")})
public class QuestionDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_district_id")
    private Integer questionDistrictId;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;

    public QuestionDistrict() {
    }

    public QuestionDistrict(Integer questionDistrictId) {
        this.questionDistrictId = questionDistrictId;
    }

    public Integer getQuestionDistrictId() {
        return questionDistrictId;
    }

    public void setQuestionDistrictId(Integer questionDistrictId) {
        this.questionDistrictId = questionDistrictId;
    }

    public Districttb getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districttb districtId) {
        this.districtId = districtId;
    }

    public Questiontb getQid() {
        return qid;
    }

    public void setQid(Questiontb qid) {
        this.qid = qid;
    }

    public Statetb getStateId() {
        return stateId;
    }

    public void setStateId(Statetb stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionDistrictId != null ? questionDistrictId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionDistrict)) {
            return false;
        }
        QuestionDistrict other = (QuestionDistrict) object;
        if ((this.questionDistrictId == null && other.questionDistrictId != null) || (this.questionDistrictId != null && !this.questionDistrictId.equals(other.questionDistrictId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionDistrict[ questionDistrictId=" + questionDistrictId + " ]";
    }
    
}
