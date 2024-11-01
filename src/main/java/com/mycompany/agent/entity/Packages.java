/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author gleb9
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
    @NamedQuery(name = "Packages.findByType", query = "SELECT p FROM Packages p WHERE p.type = :type")})
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageId != null ? packageId.hashCode() : 0);
        return hash;
    }
    
    public List<Packages> getPackagesList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Packages.class);
        Root<Packages> root = cq.from(Packages.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Packages> packagesList = query.getResultList();
        return packagesList;
    }

    public void addPackages(Packages packages, EntityManager em) {
        em.getTransaction().begin();
        em.persist(packages);
        em.getTransaction().commit();

    }

    public void deletePackages(Packages packages, EntityManager em) {
        em.getTransaction().begin();
        Packages u = em.find(Packages.class, packages.getPackageId());
        em.remove(u);
        em.getTransaction().commit();
    }
    public void upDatePackages(Packages employees, EntityManager em) {
        em.getTransaction().begin();
        Packages emp = em.find(Packages.class, employees.getPackageId());
        emp.setPackageId(employees.getPackageId());
        emp.setDestination(employees.getDestination());
        emp.setStartDate(employees.getStartDate());
        emp.setEndDate(employees.getEndDate());
        emp.setPrice(employees.getPrice());
        emp.setType(employees.getType());
        em.merge(emp);
        em.getTransaction().commit();
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
