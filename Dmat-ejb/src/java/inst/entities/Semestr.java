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
@Table(name = "semestr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestr.findAll", query = "SELECT s FROM Semestr s")
    , @NamedQuery(name = "Semestr.findById", query = "SELECT s FROM Semestr s WHERE s.id = :id")
    , @NamedQuery(name = "Semestr.findByNomer", query = "SELECT s FROM Semestr s WHERE s.nomer = :nomer")})
public class Semestr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nomer")
    private Integer nomer;
    @JoinColumn(name = "id_kurs", referencedColumnName = "id")
    @ManyToOne
    private Kurs idKurs;

    public Semestr() {
    }

    public Semestr(Integer id) {
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

    public Kurs getIdKurs() {
        return idKurs;
    }

    public void setIdKurs(Kurs idKurs) {
        this.idKurs = idKurs;
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
        if (!(object instanceof Semestr)) {
            return false;
        }
        Semestr other = (Semestr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.Semestr[ id=" + id + " ]";
    }
    
}
