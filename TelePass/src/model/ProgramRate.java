/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author admin
 */
@Entity
@Table(name = "PROGRAM_RATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramRate.findAll", query = "SELECT p FROM ProgramRate p"),
    @NamedQuery(name = "ProgramRate.findById", query = "SELECT p FROM ProgramRate p WHERE p.id = :id"),
    @NamedQuery(name = "ProgramRate.findByRate", query = "SELECT p FROM ProgramRate p WHERE p.rate = :rate")})
public class ProgramRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RATE")
    private BigDecimal rate;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne
    private VehicleCategory categoryId;
    @JoinColumn(name = "STATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Station stationId;
    @JoinColumn(name = "PROGRAM_ID", referencedColumnName = "ID")
    @ManyToOne
    private Program programId;

    public ProgramRate() {
    }

    public ProgramRate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public VehicleCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(VehicleCategory categoryId) {
        this.categoryId = categoryId;
    }

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof ProgramRate)) {
            return false;
        }
        ProgramRate other = (ProgramRate) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
        if (this.programId == other.programId && this.stationId == other.stationId && this.categoryId == other.categoryId) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "model.ProgramRate[ id=" + id + " ]";
    }
    
}
