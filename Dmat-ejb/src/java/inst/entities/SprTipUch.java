/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inst.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muzaffar
 */
@Entity
@Table(name = "spr_tip_uch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SprTipUch.findAll", query = "SELECT s FROM SprTipUch s")
    , @NamedQuery(name = "SprTipUch.findById", query = "SELECT s FROM SprTipUch s WHERE s.id = :id")
    , @NamedQuery(name = "SprTipUch.findByTip", query = "SELECT s FROM SprTipUch s WHERE s.tip = :tip")})
public class SprTipUch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "tip")
    private String tip;
    @OneToMany(mappedBy = "idTip")
    private Collection<SprStudent> sprStudentCollection;

    public SprTipUch() {
    }

    public SprTipUch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @XmlTransient
    public Collection<SprStudent> getSprStudentCollection() {
        return sprStudentCollection;
    }

    public void setSprStudentCollection(Collection<SprStudent> sprStudentCollection) {
        this.sprStudentCollection = sprStudentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprTipUch)) {
            return false;
        }
        SprTipUch other = (SprTipUch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.SprTipUch[ id=" + id + " ]";
    }
    
}
