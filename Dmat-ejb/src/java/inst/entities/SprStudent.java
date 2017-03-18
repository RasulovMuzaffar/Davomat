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
@Table(name = "spr_student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SprStudent.findAll", query = "SELECT s FROM SprStudent s")
    , @NamedQuery(name = "SprStudent.findById", query = "SELECT s FROM SprStudent s WHERE s.id = :id")
    , @NamedQuery(name = "SprStudent.findByFio", query = "SELECT s FROM SprStudent s WHERE s.fio = :fio")})
public class SprStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "FIO")
    private String fio;
    @JoinColumn(name = "id_tip", referencedColumnName = "id")
    @ManyToOne
    private SprTipUch idTip;
    @JoinColumn(name = "id_gr", referencedColumnName = "id")
    @ManyToOne
    private SprGruppa idGr;
    @OneToMany(mappedBy = "idSt")
    private Collection<Posesh> poseshCollection;

    public SprStudent() {
    }

    public SprStudent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public SprTipUch getIdTip() {
        return idTip;
    }

    public void setIdTip(SprTipUch idTip) {
        this.idTip = idTip;
    }

    public SprGruppa getIdGr() {
        return idGr;
    }

    public void setIdGr(SprGruppa idGr) {
        this.idGr = idGr;
    }

    @XmlTransient
    public Collection<Posesh> getPoseshCollection() {
        return poseshCollection;
    }

    public void setPoseshCollection(Collection<Posesh> poseshCollection) {
        this.poseshCollection = poseshCollection;
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
        if (!(object instanceof SprStudent)) {
            return false;
        }
        SprStudent other = (SprStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.SprStudent[ id=" + id + " ]";
    }
    
}
