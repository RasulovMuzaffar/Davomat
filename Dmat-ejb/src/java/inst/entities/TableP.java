/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inst.entities;

import java.io.Serializable;

/**
 *
 * @author Muzaffar
 */
public class TableP implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fio;
    private String grName;
    private String nedelya;
    private String propusk;
    private String uvProp;

    public TableP() {
    }

    public TableP(Integer id, String fio, String grName, String nedelya, String propusk, String uvProp) {
        this.id = id;
        this.fio = fio;
        this.grName = grName;
        this.nedelya = nedelya;
        this.propusk = propusk;
        this.uvProp = uvProp;
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

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }

    public String getNedelya() {
        return nedelya;
    }

    public void setNedelya(String nedelya) {
        this.nedelya = nedelya;
    }

    public String getPropusk() {
        return propusk;
    }

    public void setPropusk(String propusk) {
        this.propusk = propusk;
    }

    public String getUvProp() {
        return uvProp;
    }

    public void setUvProp(String uvProp) {
        this.uvProp = uvProp;
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
        if (!(object instanceof TableP)) {
            return false;
        }
        TableP other = (TableP) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inst.entities.TableP[ id=" + id + " ]";
    }

}
