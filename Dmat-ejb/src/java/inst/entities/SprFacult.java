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
@Table(name = "spr_facult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SprFacult.findAll", query = "SELECT s FROM SprFacult s")
    , @NamedQuery(name = "SprFacult.findById", query = "SELECT s FROM SprFacult s WHERE s.id = :id")
    , @NamedQuery(name = "SprFacult.findByName", query = "SELECT s FROM SprFacult s WHERE s.name = :name")})
public class SprFacult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idFac")
    private Collection<SprGruppa> sprGruppaCollection;
    @OneToMany(mappedBy = "idFacult")
    private Collection<Kurs> kursCollection;

    public SprFacult() {
    }

    public SprFacult(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<SprGruppa> getSprGruppaCollection() {
        return sprGruppaCollection;
    }

    public void setSprGruppaCollection(Collection<SprGruppa> sprGruppaCollection) {
        this.sprGruppaCollection = sprGruppaCollection;
    }

    @XmlTransient
    public Collection<Kurs> getKursCollection() {
        return kursCollection;
    }

    public void setKursCollection(Collection<Kurs> kursCollection) {
        this.kursCollection = kursCollection;
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
        if (!(object instanceof SprFacult)) {
            return false;
        }
        SprFacult other = (SprFacult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.SprFacult[ id=" + id + " ]";
    }
    
}
