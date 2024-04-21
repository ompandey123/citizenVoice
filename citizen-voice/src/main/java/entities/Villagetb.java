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
@Table(name = "villagetb")
@NamedQueries({
    @NamedQuery(name = "Villagetb.findAll", query = "SELECT v FROM Villagetb v"),
    @NamedQuery(name = "Villagetb.findByVillageId", query = "SELECT v FROM Villagetb v WHERE v.villageId = :villageId"),
    @NamedQuery(name = "Villagetb.findByVillageName", query = "SELECT v FROM Villagetb v WHERE v.villageName = :villageName")})
public class Villagetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "village_id")
    private Integer villageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "village_name")
    private String villageName;
    @ManyToMany(mappedBy = "villagetbCollection")
    private Collection<Questiontb> questiontbCollection;
    @JoinColumn(name = "taluka_id", referencedColumnName = "taluka_id")
    @ManyToOne(optional = false)
    private Talukatb talukaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villageId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villageId")
    private Collection<Usertb> usertbCollection;

    public Villagetb() {
    }

    public Villagetb(Integer villageId) {
        this.villageId = villageId;
    }

    public Villagetb(Integer villageId, String villageName) {
        this.villageId = villageId;
        this.villageName = villageName;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public Collection<Questiontb> getQuestiontbCollection() {
        return questiontbCollection;
    }

    public void setQuestiontbCollection(Collection<Questiontb> questiontbCollection) {
        this.questiontbCollection = questiontbCollection;
    }

    public Talukatb getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(Talukatb talukaId) {
        this.talukaId = talukaId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villageId != null ? villageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Villagetb)) {
            return false;
        }
        Villagetb other = (Villagetb) object;
        if ((this.villageId == null && other.villageId != null) || (this.villageId != null && !this.villageId.equals(other.villageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Villagetb[ villageId=" + villageId + " ]";
    }
    
}
