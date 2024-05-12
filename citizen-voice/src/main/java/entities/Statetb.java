/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ompan
 */
@Entity
@Table(name = "statetb")
@NamedQueries({
    @NamedQuery(name = "Statetb.findAll", query = "SELECT s FROM Statetb s"),
    @NamedQuery(name = "Statetb.findByStateId", query = "SELECT s FROM Statetb s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "Statetb.findByStateName", query = "SELECT s FROM Statetb s WHERE s.stateName = :stateName")})
public class Statetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state_name")
    private String stateName;
    @ManyToMany(mappedBy = "statetbCollection")
    private Collection<Questiontb> questiontbCollection;
    @OneToMany(mappedBy = "stateId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(mappedBy = "stateId")
    private Collection<Usertb> usertbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Citytb> citytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Districttb> districttbCollection;

    public Statetb() {
    }

    public Statetb(Integer stateId) {
        this.stateId = stateId;
    }

    public Statetb(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Collection<Questiontb> getQuestiontbCollection() {
        return questiontbCollection;
    }

    public void setQuestiontbCollection(Collection<Questiontb> questiontbCollection) {
        this.questiontbCollection = questiontbCollection;
    }

    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
    }

    public Collection<Usertb> getUsertbCollection() {
        return usertbCollection;
    }

    public void setUsertbCollection(Collection<Usertb> usertbCollection) {
        this.usertbCollection = usertbCollection;
    }

    public Collection<Citytb> getCitytbCollection() {
        return citytbCollection;
    }

    public void setCitytbCollection(Collection<Citytb> citytbCollection) {
        this.citytbCollection = citytbCollection;
    }

    public Collection<Districttb> getDistricttbCollection() {
        return districttbCollection;
    }

    public void setDistricttbCollection(Collection<Districttb> districttbCollection) {
        this.districttbCollection = districttbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statetb)) {
            return false;
        }
        Statetb other = (Statetb) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statetb[ stateId=" + stateId + " ]";
    }
    
}
