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
@Table(name = "question_zone")
@NamedQueries({
    @NamedQuery(name = "QuestionZone.findAll", query = "SELECT q FROM QuestionZone q"),
    @NamedQuery(name = "QuestionZone.findByQuestionZoneId", query = "SELECT q FROM QuestionZone q WHERE q.questionZoneId = :questionZoneId")})
public class QuestionZone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_zone_id")
    private Integer questionZoneId;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private Citytb cityId;
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private Zonetb zoneId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;

    public QuestionZone() {
    }

    public QuestionZone(Integer questionZoneId) {
        this.questionZoneId = questionZoneId;
    }

    public Integer getQuestionZoneId() {
        return questionZoneId;
    }

    public void setQuestionZoneId(Integer questionZoneId) {
        this.questionZoneId = questionZoneId;
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

    public Zonetb getZoneId() {
        return zoneId;
    }

    public void setZoneId(Zonetb zoneId) {
        this.zoneId = zoneId;
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
        hash += (questionZoneId != null ? questionZoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionZone)) {
            return false;
        }
        QuestionZone other = (QuestionZone) object;
        if ((this.questionZoneId == null && other.questionZoneId != null) || (this.questionZoneId != null && !this.questionZoneId.equals(other.questionZoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionZone[ questionZoneId=" + questionZoneId + " ]";
    }
    
}
