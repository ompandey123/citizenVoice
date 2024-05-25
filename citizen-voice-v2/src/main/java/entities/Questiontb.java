/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "questiontb")
@NamedQueries({
    @NamedQuery(name = "Questiontb.findAll", query = "SELECT q FROM Questiontb q"),
    @NamedQuery(name = "Questiontb.findByQid", query = "SELECT q FROM Questiontb q WHERE q.qid = :qid"),
    @NamedQuery(name = "Questiontb.findByQuestion", query = "SELECT q FROM Questiontb q WHERE q.question = :question"),
    @NamedQuery(name = "Questiontb.findByLevel", query = "SELECT q FROM Questiontb q WHERE q.level = :level"),
    @NamedQuery(name = "Questiontb.findByOption1", query = "SELECT q FROM Questiontb q WHERE q.option1 = :option1"),
    @NamedQuery(name = "Questiontb.findByOption2", query = "SELECT q FROM Questiontb q WHERE q.option2 = :option2"),
    @NamedQuery(name = "Questiontb.findByOption3", query = "SELECT q FROM Questiontb q WHERE q.option3 = :option3"),
    @NamedQuery(name = "Questiontb.findByOption4", query = "SELECT q FROM Questiontb q WHERE q.option4 = :option4")})
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
    @Size(min = 1, max = 50)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "option1")
    private String option1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "option2")
    private String option2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "option3")
    private String option3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "option4")
    private String option4;
    @JoinTable(name = "question_village", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "village_id", referencedColumnName = "village_id")})
    @ManyToMany
    private Collection<Villagetb> villagetbCollection;
    @JoinTable(name = "question_ward", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")})
    @ManyToMany
    private Collection<Wardtb> wardtbCollection;
    @JoinTable(name = "question_city", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "city_id", referencedColumnName = "city_id")})
    @ManyToMany
    private Collection<Citytb> citytbCollection;
    @JoinTable(name = "question_taluka", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "taluka_id", referencedColumnName = "taluka_id")})
    @ManyToMany
    private Collection<Talukatb> talukatbCollection;
    @JoinTable(name = "question_district", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "district_id", referencedColumnName = "district_id")})
    @ManyToMany
    private Collection<Districttb> districttbCollection;
    @JoinTable(name = "question_state", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "state_id", referencedColumnName = "state_id")})
    @ManyToMany
    private Collection<Statetb> statetbCollection;
    @JoinTable(name = "question_zone", joinColumns = {
        @JoinColumn(name = "qid", referencedColumnName = "qid")}, inverseJoinColumns = {
        @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")})
    @ManyToMany
    private Collection<Zonetb> zonetbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<UserAnswer> userAnswerCollection;
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    @ManyToOne(optional = false)
    private Category categoryid;

    public Questiontb() {
    }

    public Questiontb(Integer qid) {
        this.qid = qid;
    }

    public Questiontb(Integer qid, String question, String level, String option1, String option2, String option3, String option4) {
        this.qid = qid;
        this.question = question;
        this.level = level;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    @JsonbTransient
    public Collection<Villagetb> getVillagetbCollection() {
        return villagetbCollection;
    }

    public void setVillagetbCollection(Collection<Villagetb> villagetbCollection) {
        this.villagetbCollection = villagetbCollection;
    }

    @JsonbTransient
    public Collection<Wardtb> getWardtbCollection() {
        return wardtbCollection;
    }

    public void setWardtbCollection(Collection<Wardtb> wardtbCollection) {
        this.wardtbCollection = wardtbCollection;
    }

    @JsonbTransient
    public Collection<Citytb> getCitytbCollection() {
        return citytbCollection;
    }

    public void setCitytbCollection(Collection<Citytb> citytbCollection) {
        this.citytbCollection = citytbCollection;
    }

    @JsonbTransient
    public Collection<Talukatb> getTalukatbCollection() {
        return talukatbCollection;
    }

    public void setTalukatbCollection(Collection<Talukatb> talukatbCollection) {
        this.talukatbCollection = talukatbCollection;
    }

    @JsonbTransient
    public Collection<Districttb> getDistricttbCollection() {
        return districttbCollection;
    }

    public void setDistricttbCollection(Collection<Districttb> districttbCollection) {
        this.districttbCollection = districttbCollection;
    }

    @JsonbTransient
    public Collection<Statetb> getStatetbCollection() {
        return statetbCollection;
    }

    public void setStatetbCollection(Collection<Statetb> statetbCollection) {
        this.statetbCollection = statetbCollection;
    }

    @JsonbTransient
    public Collection<Zonetb> getZonetbCollection() {
        return zonetbCollection;
    }

    public void setZonetbCollection(Collection<Zonetb> zonetbCollection) {
        this.zonetbCollection = zonetbCollection;
    }

    @JsonbTransient
    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
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
