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
@Table(name = "optionstb")
@NamedQueries({
    @NamedQuery(name = "Optionstb.findAll", query = "SELECT o FROM Optionstb o"),
    @NamedQuery(name = "Optionstb.findByOptionId", query = "SELECT o FROM Optionstb o WHERE o.optionId = :optionId"),
    @NamedQuery(name = "Optionstb.findByOptionAnswer", query = "SELECT o FROM Optionstb o WHERE o.optionAnswer = :optionAnswer"),
    @NamedQuery(name = "Optionstb.findByDateOfSubmission", query = "SELECT o FROM Optionstb o WHERE o.dateOfSubmission = :dateOfSubmission")})
public class Optionstb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "option_id")
    private Integer optionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "option_answer")
    private String optionAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfSubmission")
    @Temporal(TemporalType.DATE)
    private Date dateOfSubmission;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "optionId")
    private Collection<UserAnswer> userAnswerCollection;
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    @ManyToOne(optional = false)
    private Questiontb qid;

    public Optionstb() {
    }

    public Optionstb(Integer optionId) {
        this.optionId = optionId;
    }

    public Optionstb(Integer optionId, String optionAnswer, Date dateOfSubmission) {
        this.optionId = optionId;
        this.optionAnswer = optionAnswer;
        this.dateOfSubmission = dateOfSubmission;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionAnswer() {
        return optionAnswer;
    }

    public void setOptionAnswer(String optionAnswer) {
        this.optionAnswer = optionAnswer;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
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
        hash += (optionId != null ? optionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Optionstb)) {
            return false;
        }
        Optionstb other = (Optionstb) object;
        if ((this.optionId == null && other.optionId != null) || (this.optionId != null && !this.optionId.equals(other.optionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Optionstb[ optionId=" + optionId + " ]";
    }
    
}
