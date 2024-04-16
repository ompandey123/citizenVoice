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
@Table(name = "question_taluka")
@NamedQueries({
    @NamedQuery(name = "QuestionTaluka.findAll", query = "SELECT q FROM QuestionTaluka q"),
    @NamedQuery(name = "QuestionTaluka.findByQuestionTalukaId", query = "SELECT q FROM QuestionTaluka q WHERE q.questionTalukaId = :questionTalukaId")})
public class QuestionTaluka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_taluka_id")
    private Integer questionTalukaId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;
    @JoinColumn(name = "taluka_id", referencedColumnName = "taluka_id")
    @ManyToOne(optional = false)
    private Talukatb talukaId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;

    public QuestionTaluka() {
    }

    public QuestionTaluka(Integer questionTalukaId) {
        this.questionTalukaId = questionTalukaId;
    }

    public Integer getQuestionTalukaId() {
        return questionTalukaId;
    }

    public void setQuestionTalukaId(Integer questionTalukaId) {
        this.questionTalukaId = questionTalukaId;
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

    public Talukatb getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(Talukatb talukaId) {
        this.talukaId = talukaId;
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
        hash += (questionTalukaId != null ? questionTalukaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionTaluka)) {
            return false;
        }
        QuestionTaluka other = (QuestionTaluka) object;
        if ((this.questionTalukaId == null && other.questionTalukaId != null) || (this.questionTalukaId != null && !this.questionTalukaId.equals(other.questionTalukaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionTaluka[ questionTalukaId=" + questionTalukaId + " ]";
    }
    
}
