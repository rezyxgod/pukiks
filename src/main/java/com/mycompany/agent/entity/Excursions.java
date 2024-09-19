/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "excursions")
@NamedQueries({
    @NamedQuery(name = "Excursions.findAll", query = "SELECT e FROM Excursions e"),
    @NamedQuery(name = "Excursions.findByIdExcursions", query = "SELECT e FROM Excursions e WHERE e.idExcursions = :idExcursions"),
    @NamedQuery(name = "Excursions.findByName", query = "SELECT e FROM Excursions e WHERE e.name = :name"),
    @NamedQuery(name = "Excursions.findByDescription", query = "SELECT e FROM Excursions e WHERE e.description = :description"),
    @NamedQuery(name = "Excursions.findByPrice", query = "SELECT e FROM Excursions e WHERE e.price = :price"),
    @NamedQuery(name = "Excursions.findByAvailableSlots", query = "SELECT e FROM Excursions e WHERE e.availableSlots = :availableSlots"),
    @NamedQuery(name = "Excursions.findByStartDate", query = "SELECT e FROM Excursions e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Excursions.findByEndDate", query = "SELECT e FROM Excursions e WHERE e.endDate = :endDate")})
public class Excursions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_excursions")
    private Integer idExcursions;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "available_slots")
    private Integer availableSlots;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(mappedBy = "excursionId")
    private Collection<Excursionsales> excursionsalesCollection;

    public Excursions() {
    }

    public Excursions(Integer idExcursions) {
        this.idExcursions = idExcursions;
    }

    public Integer getIdExcursions() {
        return idExcursions;
    }

    public void setIdExcursions(Integer idExcursions) {
        this.idExcursions = idExcursions;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Integer availableSlots) {
        this.availableSlots = availableSlots;
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

    public Collection<Excursionsales> getExcursionsalesCollection() {
        return excursionsalesCollection;
    }

    public void setExcursionsalesCollection(Collection<Excursionsales> excursionsalesCollection) {
        this.excursionsalesCollection = excursionsalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExcursions != null ? idExcursions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Excursions)) {
            return false;
        }
        Excursions other = (Excursions) object;
        if ((this.idExcursions == null && other.idExcursions != null) || (this.idExcursions != null && !this.idExcursions.equals(other.idExcursions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Excursions[ idExcursions=" + idExcursions + " ]";
    }
    
}
