/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inst.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muzaffar
 */
@Entity
@Table(name = "grafik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grafik.findAll", query = "SELECT g FROM Grafik g")
    , @NamedQuery(name = "Grafik.findById", query = "SELECT g FROM Grafik g WHERE g.id = :id")
    , @NamedQuery(name = "Grafik.findByPervayaNedel1Sem", query = "SELECT g FROM Grafik g WHERE g.pervayaNedel1Sem = :pervayaNedel1Sem")
    , @NamedQuery(name = "Grafik.findByPervayaNedel2Sem", query = "SELECT g FROM Grafik g WHERE g.pervayaNedel2Sem = :pervayaNedel2Sem")
    , @NamedQuery(name = "Grafik.findByGod", query = "SELECT g FROM Grafik g WHERE g.god = :god")})
public class Grafik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pervaya_nedel_1_sem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pervayaNedel1Sem;
    @Column(name = "pervaya_nedel_2_sem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pervayaNedel2Sem;
    @Column(name = "god")
    @Temporal(TemporalType.DATE)
    private Date god;
    @JoinColumn(name = "id_gr", referencedColumnName = "id")
    @ManyToOne
    private SprGruppa idGr;

    public Grafik() {
    }

    public Grafik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPervayaNedel1Sem() {
        return pervayaNedel1Sem;
    }

    public void setPervayaNedel1Sem(Date pervayaNedel1Sem) {
        this.pervayaNedel1Sem = pervayaNedel1Sem;
    }

    public Date getPervayaNedel2Sem() {
        return pervayaNedel2Sem;
    }

    public void setPervayaNedel2Sem(Date pervayaNedel2Sem) {
        this.pervayaNedel2Sem = pervayaNedel2Sem;
    }

    public Date getGod() {
        return god;
    }

    public void setGod(Date god) {
        this.god = god;
    }

    public SprGruppa getIdGr() {
        return idGr;
    }

    public void setIdGr(SprGruppa idGr) {
        this.idGr = idGr;
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
        if (!(object instanceof Grafik)) {
            return false;
        }
        Grafik other = (Grafik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.Grafik[ id=" + id + " ]";
    }
    
}
