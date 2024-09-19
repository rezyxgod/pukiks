/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

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

/**
 *
 * @author 207371
 */
@Entity
@Table(name = "package_sales")
@NamedQueries({
    @NamedQuery(name = "PackageSales.findAll", query = "SELECT p FROM PackageSales p"),
    @NamedQuery(name = "PackageSales.findByPackageSaleId", query = "SELECT p FROM PackageSales p WHERE p.packageSaleId = :packageSaleId"),
    @NamedQuery(name = "PackageSales.findBySaleDate", query = "SELECT p FROM PackageSales p WHERE p.saleDate = :saleDate"),
    @NamedQuery(name = "PackageSales.findByTotalPrice", query = "SELECT p FROM PackageSales p WHERE p.totalPrice = :totalPrice")})
public class PackageSales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "package_sale_id")
    private Integer packageSaleId;
    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @JoinColumn(name = "client_id", referencedColumnName = "idClient")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne
    private Packages packageId;

    public PackageSales() {
    }

    public PackageSales(Integer packageSaleId) {
        this.packageSaleId = packageSaleId;
    }

    public Integer getPackageSaleId() {
        return packageSaleId;
    }

    public void setPackageSaleId(Integer packageSaleId) {
        this.packageSaleId = packageSaleId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
        hash += (packageSaleId != null ? packageSaleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageSales)) {
            return false;
        }
        PackageSales other = (PackageSales) object;
        if ((this.packageSaleId == null && other.packageSaleId != null) || (this.packageSaleId != null && !this.packageSaleId.equals(other.packageSaleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.PackageSales[ packageSaleId=" + packageSaleId + " ]";
    }
    
}
