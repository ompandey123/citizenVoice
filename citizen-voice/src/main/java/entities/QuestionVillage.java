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
@Table(name = "question_village")
@NamedQueries({
    @NamedQuery(name = "QuestionVillage.findAll", query = "SELECT q FROM QuestionVillage q"),
    @NamedQuery(name = "QuestionVillage.findByQuestionVillageId", query = "SELECT q FROM QuestionVillage q WHERE q.questionVillageId = :questionVillageId")})
public class QuestionVillage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_village_id")
    private Integer questionVillageId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;
    @JoinColumn(name = "village_id", referencedColumnName = "village_id")
    @ManyToOne(optional = false)
    private Villagetb villageId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;

    public QuestionVillage() {
    }

    public QuestionVillage(Integer questionVillageId) {
        this.questionVillageId = questionVillageId;
    }

    public Integer getQuestionVillageId() {
        return questionVillageId;
    }

    public void setQuestionVillageId(Integer questionVillageId) {
        this.questionVillageId = questionVillageId;
    }

    public Questiontb getQid() {
        return qid;
    }

    public void setQid(Questiontb qid) {
        this.qid = qid;
    }

    public Districttb getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districttb districtId) {
        this.districtId = districtId;
    }

    public Villagetb getVillageId() {
        return villageId;
    }

    public void setVillageId(Villagetb villageId) {
        this.villageId = villageId;
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
        hash += (questionVillageId != null ? questionVillageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionVillage)) {
            return false;
        }
        QuestionVillage other = (QuestionVillage) object;
        if ((this.questionVillageId == null && other.questionVillageId != null) || (this.questionVillageId != null && !this.questionVillageId.equals(other.questionVillageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionVillage[ questionVillageId=" + questionVillageId + " ]";
    }
    
}
