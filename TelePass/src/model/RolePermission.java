/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author Aggelos
 */
@Entity
@Table(name = "ROLE_PERMISSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePermission.findAll", query = "SELECT r FROM RolePermission r"),
    @NamedQuery(name = "RolePermission.findById", query = "SELECT r FROM RolePermission r WHERE r.id = :id")})
public class RolePermission implements Serializable {
    @Column(name = "STATION_LEVEL_ACCESS")
    private Serializable stationLevelAccess;
    @Column(name = "CAN_CREATE")
    private Serializable canCreate;
    @Column(name = "CAN_RETRIEVE")
    private Serializable canRetrieve;
    @Column(name = "CAN_UPDATE")
    private Serializable canUpdate;
    @Column(name = "CAN_DELETE")
    private Serializable canDelete;
    @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Module moduleId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne
    private UserRole roleId;
    
    public RolePermission() {
    }

    public RolePermission(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserRole getRoleId() {
        return roleId;
    }

    public void setRoleId(UserRole roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof RolePermission)) {
            return false;
        }
        RolePermission other = (RolePermission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RolePermission[ id=" + id + " ]";
    }

    public Serializable getStationLevelAccess() {
        return stationLevelAccess;
    }

    public void setStationLevelAccess(Serializable stationLevelAccess) {
        this.stationLevelAccess = stationLevelAccess;
    }

    public Serializable getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Serializable canCreate) {
        this.canCreate = canCreate;
    }

    public Serializable getCanRetrieve() {
        return canRetrieve;
    }

    public void setCanRetrieve(Serializable canRetrieve) {
        this.canRetrieve = canRetrieve;
    }

    public Serializable getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Serializable canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Serializable getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Serializable canDelete) {
        this.canDelete = canDelete;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
    }
    
}
