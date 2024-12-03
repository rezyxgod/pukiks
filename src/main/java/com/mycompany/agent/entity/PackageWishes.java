/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "package_wishes")
@NamedQueries({
    @NamedQuery(name = "PackageWishes.findAll", query = "SELECT p FROM PackageWishes p"),
    @NamedQuery(name = "PackageWishes.findByWishId", query = "SELECT p FROM PackageWishes p WHERE p.wishId = :wishId"),
    @NamedQuery(name = "PackageWishes.findByWishDescription", query = "SELECT p FROM PackageWishes p WHERE p.wishDescription = :wishDescription")})
public class PackageWishes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wish_id")
    private Integer wishId;
    @Column(name = "wish_description")
    private String wishDescription;
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    @ManyToOne
    private Packages packageId;
    @JoinColumn(name = "client_id", referencedColumnName = "idusers")
    @ManyToOne
    private Users clientId;
    
    public List<PackageWishes> getPackageWishesList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(PackageWishes.class);
        Root<PackageWishes> root = cq.from(PackageWishes.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<PackageWishes> packageWishesList = query.getResultList();
        return packageWishesList;
    }

    public PackageWishes() {
    }

    public PackageWishes(Integer wishId) {
        this.wishId = wishId;
    }

    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
    }

    public String getWishDescription() {
        return wishDescription;
    }

    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    public Packages getPackageId() {
        return packageId;
    }

    public void setPackageId(Packages packageId) {
        this.packageId = packageId;
    }

    public Users getClientId() {
        return clientId;
    }

    public void setClientId(Users clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishId != null ? wishId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageWishes)) {
            return false;
        }
        PackageWishes other = (PackageWishes) object;
        if ((this.wishId == null && other.wishId != null) || (this.wishId != null && !this.wishId.equals(other.wishId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.PackageWishes[ wishId=" + wishId + " ]";
    }
    
}
