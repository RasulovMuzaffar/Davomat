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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muzaffar
 */
@Entity
@Table(name = "kurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kurs.findAll", query = "SELECT k FROM Kurs k")
    , @NamedQuery(name = "Kurs.findById", query = "SELECT k FROM Kurs k WHERE k.id = :id")
    , @NamedQuery(name = "Kurs.findByNomer", query = "SELECT k FROM Kurs k WHERE k.nomer = :nomer")})
public class Kurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nomer")
    private Integer nomer;
    @OneToMany(mappedBy = "idKurs")
    private Collection<Semestr> semestrCollection;
    @OneToMany(mappedBy = "idKurs")
    private Collection<SprGruppa> sprGruppaCollection;
    @JoinColumn(name = "id_facult", referencedColumnName = "id")
    @ManyToOne
    private SprFacult idFacult;

    public Kurs() {
    }

    public Kurs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNomer() {
        return nomer;
    }

    public void setNomer(Integer nomer) {
        this.nomer = nomer;
    }

    @XmlTransient
    public Collection<Semestr> getSemestrCollection() {
        return semestrCollection;
    }

    public void setSemestrCollection(Collection<Semestr> semestrCollection) {
        this.semestrCollection = semestrCollection;
    }

    @XmlTransient
    public Collection<SprGruppa> getSprGruppaCollection() {
        return sprGruppaCollection;
    }

    public void setSprGruppaCollection(Collection<SprGruppa> sprGruppaCollection) {
        this.sprGruppaCollection = sprGruppaCollection;
    }

    public SprFacult getIdFacult() {
        return idFacult;
    }

    public void setIdFacult(SprFacult idFacult) {
        this.idFacult = idFacult;
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
        if (!(object instanceof Kurs)) {
            return false;
        }
        Kurs other = (Kurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.Kurs[ id=" + id + " ]";
    }
    
}
