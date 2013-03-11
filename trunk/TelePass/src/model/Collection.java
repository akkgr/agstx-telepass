/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author admin
 */
@Entity
@Table(name = "COLLECTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collection.findAll", query = "SELECT c FROM Collection c"),
    @NamedQuery(name = "Collection.findById", query = "SELECT c FROM Collection c WHERE c.id = :id"),
    @NamedQuery(name = "Collection.findByPassTimestamp", query = "SELECT c FROM Collection c WHERE c.passTimestamp = :passTimestamp"),
    @NamedQuery(name = "Collection.findByTollCollected", query = "SELECT c FROM Collection c WHERE c.tollCollected = :tollCollected")})
public class Collection implements Serializable {
    @JoinColumn(name = "STATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Station stationId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PASS_TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date passTimestamp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOLL_COLLECTED")
    private BigDecimal tollCollected;
    @JoinColumn(name = "CARD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Card cardId;

    public Collection() {
    }

    public Collection(Integer id) {
        this.id = id;
    }

    public Collection(Integer id, Date passTimestamp) {
        this.id = id;
        this.passTimestamp = passTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPassTimestamp() {
        return passTimestamp;
    }

    public void setPassTimestamp(Date passTimestamp) {
        this.passTimestamp = passTimestamp;
    }

    public BigDecimal getTollCollected() {
        return tollCollected;
    }

    public void setTollCollected(BigDecimal tollCollected) {
        this.tollCollected = tollCollected;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
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
        if (!(object instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Collection[ id=" + id + " ]";
    }

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
    }
    
}
