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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "spr_gruppa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SprGruppa.findAll", query = "SELECT s FROM SprGruppa s")
    , @NamedQuery(name = "SprGruppa.findById", query = "SELECT s FROM SprGruppa s WHERE s.id = :id")
    , @NamedQuery(name = "SprGruppa.findByName", query = "SELECT s FROM SprGruppa s WHERE s.name = :name")})
public class SprGruppa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idGr")
    private Collection<SprStudent> sprStudentCollection;
    @OneToMany(mappedBy = "idGr")
    private Collection<Grafik> grafikCollection;
    @JoinColumn(name = "id_kurs", referencedColumnName = "id")
    @ManyToOne
    private Kurs idKurs;
    @JoinColumn(name = "id_fac", referencedColumnName = "id")
    @ManyToOne
    private SprFacult idFac;

    public SprGruppa() {
    }

    public SprGruppa(Integer id) {
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
    public Collection<SprStudent> getSprStudentCollection() {
        return sprStudentCollection;
    }

    public void setSprStudentCollection(Collection<SprStudent> sprStudentCollection) {
        this.sprStudentCollection = sprStudentCollection;
    }

    @XmlTransient
    public Collection<Grafik> getGrafikCollection() {
        return grafikCollection;
    }

    public void setGrafikCollection(Collection<Grafik> grafikCollection) {
        this.grafikCollection = grafikCollection;
    }

    public Kurs getIdKurs() {
        return idKurs;
    }

    public void setIdKurs(Kurs idKurs) {
        this.idKurs = idKurs;
    }

    public SprFacult getIdFac() {
        return idFac;
    }

    public void setIdFac(SprFacult idFac) {
        this.idFac = idFac;
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
        if (!(object instanceof SprGruppa)) {
            return false;
        }
        SprGruppa other = (SprGruppa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.SprGruppa[ id=" + id + " ]";
    }
    
}
