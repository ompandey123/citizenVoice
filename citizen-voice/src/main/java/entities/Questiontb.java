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
@Table(name = "questiontb")
@NamedQueries({
    @NamedQuery(name = "Questiontb.findAll", query = "SELECT q FROM Questiontb q"),
    @NamedQuery(name = "Questiontb.findByQid", query = "SELECT q FROM Questiontb q WHERE q.qid = :qid"),
    @NamedQuery(name = "Questiontb.findByQuestion", query = "SELECT q FROM Questiontb q WHERE q.question = :question"),
    @NamedQuery(name = "Questiontb.findByState", query = "SELECT q FROM Questiontb q WHERE q.state = :state"),
    @NamedQuery(name = "Questiontb.findByDistrict", query = "SELECT q FROM Questiontb q WHERE q.district = :district"),
    @NamedQuery(name = "Questiontb.findByCity", query = "SELECT q FROM Questiontb q WHERE q.city = :city"),
    @NamedQuery(name = "Questiontb.findByZone", query = "SELECT q FROM Questiontb q WHERE q.zone = :zone"),
    @NamedQuery(name = "Questiontb.findByWard", query = "SELECT q FROM Questiontb q WHERE q.ward = :ward"),
    @NamedQuery(name = "Questiontb.findByTaluka", query = "SELECT q FROM Questiontb q WHERE q.taluka = :taluka"),
    @NamedQuery(name = "Questiontb.findByVillage", query = "SELECT q FROM Questiontb q WHERE q.village = :village")})
public class Questiontb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "qid")
    private Integer qid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "zone")
    private String zone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ward")
    private String ward;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "taluka")
    private String taluka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "village")
    private String village;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionVillage> questionVillageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionWard> questionWardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionCity> questionCityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionTaluka> questionTalukaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionDistrict> questionDistrictCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionState> questionStateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<Optionstb> optionstbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<QuestionZone> questionZoneCollection;

    public Questiontb() {
    }

    public Questiontb(Integer qid) {
        this.qid = qid;
    }

    public Questiontb(Integer qid, String question, String state, String district, String city, String zone, String ward, String taluka, String village) {
        this.qid = qid;
        this.question = question;
        this.state = state;
        this.district = district;
        this.city = city;
        this.zone = zone;
        this.ward = ward;
        this.taluka = taluka;
        this.village = village;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Collection<QuestionVillage> getQuestionVillageCollection() {
        return questionVillageCollection;
    }

    public void setQuestionVillageCollection(Collection<QuestionVillage> questionVillageCollection) {
        this.questionVillageCollection = questionVillageCollection;
    }

    public Collection<QuestionWard> getQuestionWardCollection() {
        return questionWardCollection;
    }

    public void setQuestionWardCollection(Collection<QuestionWard> questionWardCollection) {
        this.questionWardCollection = questionWardCollection;
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

    public Collection<QuestionState> getQuestionStateCollection() {
        return questionStateCollection;
    }

    public void setQuestionStateCollection(Collection<QuestionState> questionStateCollection) {
        this.questionStateCollection = questionStateCollection;
    }

    public Collection<Optionstb> getOptionstbCollection() {
        return optionstbCollection;
    }

    public void setOptionstbCollection(Collection<Optionstb> optionstbCollection) {
        this.optionstbCollection = optionstbCollection;
    }

    public Collection<QuestionZone> getQuestionZoneCollection() {
        return questionZoneCollection;
    }

    public void setQuestionZoneCollection(Collection<QuestionZone> questionZoneCollection) {
        this.questionZoneCollection = questionZoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questiontb)) {
            return false;
        }
        Questiontb other = (Questiontb) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Questiontb[ qid=" + qid + " ]";
    }
    
}
