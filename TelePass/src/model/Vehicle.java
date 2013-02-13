/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aggelos
 */
@Entity
@Table(name = "VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByRegNumber", query = "SELECT v FROM Vehicle v WHERE v.regNumber = :regNumber"),
    @NamedQuery(name = "Vehicle.findByColour", query = "SELECT v FROM Vehicle v WHERE v.colour = :colour"),
    @NamedQuery(name = "Vehicle.findByFactoryName", query = "SELECT v FROM Vehicle v WHERE v.factoryName = :factoryName"),
    @NamedQuery(name = "Vehicle.findByModelType", query = "SELECT v FROM Vehicle v WHERE v.modelType = :modelType")})
public class Vehicle implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "REG_NUMBER")
    private String regNumber;
    @Column(name = "COLOUR")
    private String colour;
    @Column(name = "FACTORY_NAME")
    private String factoryName;
    @Column(name = "MODEL_TYPE")
    private String modelType;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne
    private VehicleCategory categoryId;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "ID")
    @ManyToOne
    private Customer custId;
    @JoinColumn(name = "CARD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Card cardId;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        String oldRegNumber = this.regNumber;
        this.regNumber = regNumber;
        changeSupport.firePropertyChange("regNumber", oldRegNumber, regNumber);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        String oldColour = this.colour;
        this.colour = colour;
        changeSupport.firePropertyChange("colour", oldColour, colour);
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        String oldFactoryName = this.factoryName;
        this.factoryName = factoryName;
        changeSupport.firePropertyChange("factoryName", oldFactoryName, factoryName);
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        String oldModelType = this.modelType;
        this.modelType = modelType;
        changeSupport.firePropertyChange("modelType", oldModelType, modelType);
    }

    public VehicleCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(VehicleCategory categoryId) {
        VehicleCategory oldCategoryId = this.categoryId;
        this.categoryId = categoryId;
        changeSupport.firePropertyChange("categoryId", oldCategoryId, categoryId);
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        Customer oldCustId = this.custId;
        this.custId = custId;
        changeSupport.firePropertyChange("custId", oldCustId, custId);
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        Card oldCardId = this.cardId;
        this.cardId = cardId;
        changeSupport.firePropertyChange("cardId", oldCardId, cardId);
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vehicle[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
