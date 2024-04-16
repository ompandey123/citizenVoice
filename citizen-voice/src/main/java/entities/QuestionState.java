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
@Table(name = "question_state")
@NamedQueries({
    @NamedQuery(name = "QuestionState.findAll", query = "SELECT q FROM QuestionState q"),
    @NamedQuery(name = "QuestionState.findByQuestionStateId", query = "SELECT q FROM QuestionState q WHERE q.questionStateId = :questionStateId")})
public class QuestionState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_state_id")
    private Integer questionStateId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;

    public QuestionState() {
    }

    public QuestionState(Integer questionStateId) {
        this.questionStateId = questionStateId;
    }

    public Integer getQuestionStateId() {
        return questionStateId;
    }

    public void setQuestionStateId(Integer questionStateId) {
        this.questionStateId = questionStateId;
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
        hash += (questionStateId != null ? questionStateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionState)) {
            return false;
        }
        QuestionState other = (QuestionState) object;
        if ((this.questionStateId == null && other.questionStateId != null) || (this.questionStateId != null && !this.questionStateId.equals(other.questionStateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionState[ questionStateId=" + questionStateId + " ]";
    }
    
}
