/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

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

/**
 *
 * @author 207371
 */
@Entity
@Table(name = "manager")
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m"),
    @NamedQuery(name = "Manager.findByIdManager", query = "SELECT m FROM Manager m WHERE m.idManager = :idManager")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idManager")
    private Integer idManager;
    @JoinColumn(name = "manager_user", referencedColumnName = "idusers")
    @ManyToOne
    private Users managerUser;

    public Manager() {
    }

    public Manager(Integer idManager) {
        this.idManager = idManager;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public Users getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(Users managerUser) {
        this.managerUser = managerUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManager != null ? idManager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.idManager == null && other.idManager != null) || (this.idManager != null && !this.idManager.equals(other.idManager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Manager[ idManager=" + idManager + " ]";
    }
    
}
