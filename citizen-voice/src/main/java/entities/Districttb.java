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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "districttb")
@NamedQueries({
    @NamedQuery(name = "Districttb.findAll", query = "SELECT d FROM Districttb d"),
    @NamedQuery(name = "Districttb.findByDistrictId", query = "SELECT d FROM Districttb d WHERE d.districtId = :districtId"),
    @NamedQuery(name = "Districttb.findByDistrictName", query = "SELECT d FROM Districttb d WHERE d.districtName = :districtName")})
public class Districttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "district_id")
    private Integer districtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "district_name")
    private String districtName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<QuestionVillage> questionVillageCollection;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Talukatb> talukatbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<QuestionCity> questionCityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<QuestionTaluka> questionTalukaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<QuestionDistrict> questionDistrictCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Usertb> usertbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<Citytb> citytbCollection;

    public Districttb() {
    }

    public Districttb(Integer districtId) {
        this.districtId = districtId;
    }

    public Districttb(Integer districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Collection<QuestionVillage> getQuestionVillageCollection() {
        return questionVillageCollection;
    }

    public void setQuestionVillageCollection(Collection<QuestionVillage> questionVillageCollection) {
        this.questionVillageCollection = questionVillageCollection;
    }

    public Statetb getStateId() {
        return stateId;
    }

    public void setStateId(Statetb stateId) {
        this.stateId = stateId;
    }

    public Collection<Talukatb> getTalukatbCollection() {
        return talukatbCollection;
    }

    public void setTalukatbCollection(Collection<Talukatb> talukatbCollection) {
        this.talukatbCollection = talukatbCollection;
    }

    public Collection<QuestionCity> getQuestionCityCollection() {
        return questionCityCollection;
    }

    public void setQuestionCityCollection(Collection<QuestionCity> questionCityCollection) {
        this.questionCityCollection = questionCityCollection;
    }

    public Collection<QuestionTaluka> getQuestionTalukaCollection() {
        return questionTalukaCollection;
    }

    public void setQuestionTalukaCollection(Collection<QuestionTaluka> questionTalukaCollection) {
        this.questionTalukaCollection = questionTalukaCollection;
    }

    public Collection<QuestionDistrict> getQuestionDistrictCollection() {
        return questionDistrictCollection;
    }

    public void setQuestionDistrictCollection(Collection<QuestionDistrict> questionDistrictCollection) {
        this.questionDistrictCollection = questionDistrictCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Districttb)) {
            return false;
        }
        Districttb other = (Districttb) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Districttb[ districtId=" + districtId + " ]";
    }
    
}
