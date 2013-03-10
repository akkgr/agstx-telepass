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
 * @author tasos
 */
@Entity
@Table(name = "ROLE_PERMISSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePermission.findAll", query = "SELECT r FROM RolePermission r"),
    @NamedQuery(name = "RolePermission.findById", query = "SELECT r FROM RolePermission r WHERE r.id = :id"),
    @NamedQuery(name = "RolePermission.findByStationLevelAccess", query = "SELECT r FROM RolePermission r WHERE r.stationLevelAccess = :stationLevelAccess"),
    @NamedQuery(name = "RolePermission.findByCanCreate", query = "SELECT r FROM RolePermission r WHERE r.canCreate = :canCreate"),
    @NamedQuery(name = "RolePermission.findByCanRetrieve", query = "SELECT r FROM RolePermission r WHERE r.canRetrieve = :canRetrieve"),
    @NamedQuery(name = "RolePermission.findByCanUpdate", query = "SELECT r FROM RolePermission r WHERE r.canUpdate = :canUpdate"),
    @NamedQuery(name = "RolePermission.findByCanDelete", query = "SELECT r FROM RolePermission r WHERE r.canDelete = :canDelete")})
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "STATION_LEVEL_ACCESS")
    private boolean stationLevelAccess;
    @Column(name = "CAN_CREATE")
    private boolean canCreate;
    @Column(name = "CAN_RETRIEVE")
    private boolean canRetrieve;
    @Column(name = "CAN_UPDATE")
    private boolean canUpdate;
    @Column(name = "CAN_DELETE")
    private boolean canDelete;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne
    private UserRole roleId;
    @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Module moduleId;

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

    public boolean getStationLevelAccess() {
        return stationLevelAccess;
    }

    public void setStationLevelAccess(boolean stationLevelAccess) {
        this.stationLevelAccess = stationLevelAccess;
    }

    public boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(boolean canCreate) {
        this.canCreate = canCreate;
    }

    public boolean getCanRetrieve() {
        return canRetrieve;
    }

    public void setCanRetrieve(boolean canRetrieve) {
        this.canRetrieve = canRetrieve;
    }

    public boolean getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public UserRole getRoleId() {
        return roleId;
    }

    public void setRoleId(UserRole roleId) {
        this.roleId = roleId;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
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
    
}
