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
@Table(name = "citytb")
@NamedQueries({
    @NamedQuery(name = "Citytb.findAll", query = "SELECT c FROM Citytb c"),
    @NamedQuery(name = "Citytb.findByCityId", query = "SELECT c FROM Citytb c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "Citytb.findByCityName", query = "SELECT c FROM Citytb c WHERE c.cityName = :cityName")})
public class Citytb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "city_name")
    private String cityName;
    @ManyToMany(mappedBy = "citytbCollection")
    private Collection<Questiontb> questiontbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<Zonetb> zonetbCollection;
    @OneToMany(mappedBy = "cityId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(mappedBy = "cityId")
    private Collection<Usertb> usertbCollection;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private Statetb stateId;

    public Citytb() {
    }

    public Citytb(Integer cityId) {
        this.cityId = cityId;
    }

    public Citytb(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonbTransient
    public Collection<Questiontb> getQuestiontbCollection() {
        return questiontbCollection;
    }

    public void setQuestiontbCollection(Collection<Questiontb> questiontbCollection) {
        this.questiontbCollection = questiontbCollection;
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

    @JsonbTransient
    public Collection<Usertb> getUsertbCollection() {
        return usertbCollection;
    }

    public void setUsertbCollection(Collection<Usertb> usertbCollection) {
        this.usertbCollection = usertbCollection;
    }

    public Districttb getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districttb districtId) {
        this.districtId = districtId;
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
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citytb)) {
            return false;
        }
        Citytb other = (Citytb) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Citytb[ cityId=" + cityId + " ]";
    }
    
}
