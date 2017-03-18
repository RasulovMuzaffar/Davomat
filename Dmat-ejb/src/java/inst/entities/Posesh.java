/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inst.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muzaffar
 */
@Entity
@Table(name = "posesh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posesh.findAll", query = "SELECT p FROM Posesh p")
    , @NamedQuery(name = "Posesh.findById", query = "SELECT p FROM Posesh p WHERE p.id = :id")
    , @NamedQuery(name = "Posesh.findByNedelya", query = "SELECT p FROM Posesh p WHERE p.nedelya = :nedelya")
    , @NamedQuery(name = "Posesh.findByPropusk", query = "SELECT p FROM Posesh p WHERE p.propusk = :propusk")
    , @NamedQuery(name = "Posesh.findByUvProp", query = "SELECT p FROM Posesh p WHERE p.uvProp = :uvProp")})
public class Posesh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nedelya")
    private Integer nedelya;
    @Column(name = "propusk")
    private Integer propusk;
    @Column(name = "uv_prop")
    private Integer uvProp;
    @JoinColumn(name = "id_st", referencedColumnName = "id")
    @ManyToOne
    private SprStudent idSt;

    public Posesh() {
    }

    public Posesh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNedelya() {
        return nedelya;
    }

    public void setNedelya(Integer nedelya) {
        this.nedelya = nedelya;
    }

    public Integer getPropusk() {
        return propusk;
    }

    public void setPropusk(Integer propusk) {
        this.propusk = propusk;
    }

    public Integer getUvProp() {
        return uvProp;
    }

    public void setUvProp(Integer uvProp) {
        this.uvProp = uvProp;
    }

    public SprStudent getIdSt() {
        return idSt;
    }

    public void setIdSt(SprStudent idSt) {
        this.idSt = idSt;
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
        if (!(object instanceof Posesh)) {
            return false;
        }
        Posesh other = (Posesh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.Posesh[ id=" + id + " ]";
    }
    
}
