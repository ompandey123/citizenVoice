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
import javax.validation.constraints.NotNull;

/**
 *
 * @author ompan
 */
@Entity
@Table(name = "question_ward")
@NamedQueries({
    @NamedQuery(name = "QuestionWard.findAll", query = "SELECT q FROM QuestionWard q"),
    @NamedQuery(name = "QuestionWard.findByQuestionWardId", query = "SELECT q FROM QuestionWard q WHERE q.questionWardId = :questionWardId"),
    @NamedQuery(name = "QuestionWard.findByStateId", query = "SELECT q FROM QuestionWard q WHERE q.stateId = :stateId")})
public class QuestionWard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_ward_id")
    private Integer questionWardId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state_id")
    private int stateId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private Citytb cityId;
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    @ManyToOne(optional = false)
    private Wardtb wardId;

    public QuestionWard() {
    }

    public QuestionWard(Integer questionWardId) {
        this.questionWardId = questionWardId;
    }

    public QuestionWard(Integer questionWardId, int stateId) {
        this.questionWardId = questionWardId;
        this.stateId = stateId;
    }

    public Integer getQuestionWardId() {
        return questionWardId;
    }

    public void setQuestionWardId(Integer questionWardId) {
        this.questionWardId = questionWardId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
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

    public Wardtb getWardId() {
        return wardId;
    }

    public void setWardId(Wardtb wardId) {
        this.wardId = wardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionWardId != null ? questionWardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionWard)) {
            return false;
        }
        QuestionWard other = (QuestionWard) object;
        if ((this.questionWardId == null && other.questionWardId != null) || (this.questionWardId != null && !this.questionWardId.equals(other.questionWardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionWard[ questionWardId=" + questionWardId + " ]";
    }
    
}
