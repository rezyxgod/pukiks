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
@Table(name = "desired_packages")
@NamedQueries({
    @NamedQuery(name = "DesiredPackages.findAll", query = "SELECT d FROM DesiredPackages d"),
    @NamedQuery(name = "DesiredPackages.findByDesiredPackageId", query = "SELECT d FROM DesiredPackages d WHERE d.desiredPackageId = :desiredPackageId")})
public class DesiredPackages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desired_package_id")
    private Integer desiredPackageId;
    @JoinColumn(name = "client_id", referencedColumnName = "idClient")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne
    private Packages packageId;

    public DesiredPackages() {
    }

    public DesiredPackages(Integer desiredPackageId) {
        this.desiredPackageId = desiredPackageId;
    }

    public Integer getDesiredPackageId() {
        return desiredPackageId;
    }

    public void setDesiredPackageId(Integer desiredPackageId) {
        this.desiredPackageId = desiredPackageId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Packages getPackageId() {
        return packageId;
    }

    public void setPackageId(Packages packageId) {
        this.packageId = packageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desiredPackageId != null ? desiredPackageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesiredPackages)) {
            return false;
        }
        DesiredPackages other = (DesiredPackages) object;
        if ((this.desiredPackageId == null && other.desiredPackageId != null) || (this.desiredPackageId != null && !this.desiredPackageId.equals(other.desiredPackageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.DesiredPackages[ desiredPackageId=" + desiredPackageId + " ]";
    }
    
}
