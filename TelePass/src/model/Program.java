/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tasos
 */
@Entity
@Table(name = "PROGRAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findById", query = "SELECT p FROM Program p WHERE p.id = :id"),
    @NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :name"),
    @NamedQuery(name = "Program.findByDescription", query = "SELECT p FROM Program p WHERE p.description = :description"),
    @NamedQuery(name = "Program.findByPassLimit", query = "SELECT p FROM Program p WHERE p.passLimit = :passLimit"),
    @NamedQuery(name = "Program.findByFreePass", query = "SELECT p FROM Program p WHERE p.freePass = :freePass")})
public class Program implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PASS_LIMIT")
    private Integer passLimit;
    @Column(name = "FREE_PASS")
    private Integer freePass;
    @OneToMany(mappedBy = "programId")
    private List<ProgramRate> programRateList;
    @OneToMany(mappedBy = "programId")
    private List<Card> cardList;

    public Program() {
    }

    public Program(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPassLimit() {
        return passLimit;
    }

    public void setPassLimit(Integer passLimit) {
        this.passLimit = passLimit;
    }

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    @XmlTransient
    public List<ProgramRate> getProgramRateList() {
        return programRateList;
    }

    public void setProgramRateList(List<ProgramRate> programRateList) {
        this.programRateList = programRateList;
    }

    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
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
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "model.Program[ id=" + id + " ]";
        return this.name;
    }
    
}
