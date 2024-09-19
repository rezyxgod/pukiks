/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 207371
 */
@Entity
@Table(name = "packages")
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findByPackageId", query = "SELECT p FROM Packages p WHERE p.packageId = :packageId"),
    @NamedQuery(name = "Packages.findByDestination", query = "SELECT p FROM Packages p WHERE p.destination = :destination"),
    @NamedQuery(name = "Packages.findByStartDate", query = "SELECT p FROM Packages p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Packages.findByEndDate", query = "SELECT p FROM Packages p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Packages.findByPrice", query = "SELECT p FROM Packages p WHERE p.price = :price"),
    @NamedQuery(name = "Packages.findByType", query = "SELECT p FROM Packages p WHERE p.type = :type"),
    @NamedQuery(name = "Packages.findByStatus", query = "SELECT p FROM Packages p WHERE p.status = :status")})
public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "package_id")
    private Integer packageId;
    @Column(name = "destination")
    private String destination;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "price")
    private String price;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "packageId")
    private Collection<DesiredPackages> desiredPackagesCollection;
    @OneToMany(mappedBy = "packageId")
    private Collection<PackageWishes> packageWishesCollection;
    @OneToMany(mappedBy = "packageId")
    private Collection<PackageSales> packageSalesCollection;

    public Packages() {
    }

    public Packages(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<DesiredPackages> getDesiredPackagesCollection() {
        return desiredPackagesCollection;
    }

    public void setDesiredPackagesCollection(Collection<DesiredPackages> desiredPackagesCollection) {
        this.desiredPackagesCollection = desiredPackagesCollection;
    }

    public Collection<PackageWishes> getPackageWishesCollection() {
        return packageWishesCollection;
    }

    public void setPackageWishesCollection(Collection<PackageWishes> packageWishesCollection) {
        this.packageWishesCollection = packageWishesCollection;
    }

    public Collection<PackageSales> getPackageSalesCollection() {
        return packageSalesCollection;
    }

    public void setPackageSalesCollection(Collection<PackageSales> packageSalesCollection) {
        this.packageSalesCollection = packageSalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageId != null ? packageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.packageId == null && other.packageId != null) || (this.packageId != null && !this.packageId.equals(other.packageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Packages[ packageId=" + packageId + " ]";
    }
    
}
