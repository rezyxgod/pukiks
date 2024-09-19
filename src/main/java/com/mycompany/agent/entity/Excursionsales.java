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
@Table(name = "excursionsales")
@NamedQueries({
    @NamedQuery(name = "Excursionsales.findAll", query = "SELECT e FROM Excursionsales e"),
    @NamedQuery(name = "Excursionsales.findByIdSale", query = "SELECT e FROM Excursionsales e WHERE e.idSale = :idSale"),
    @NamedQuery(name = "Excursionsales.findBySaleDate", query = "SELECT e FROM Excursionsales e WHERE e.saleDate = :saleDate"),
    @NamedQuery(name = "Excursionsales.findByNumberOfTickets", query = "SELECT e FROM Excursionsales e WHERE e.numberOfTickets = :numberOfTickets"),
    @NamedQuery(name = "Excursionsales.findByTotalPrice", query = "SELECT e FROM Excursionsales e WHERE e.totalPrice = :totalPrice")})
public class Excursionsales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sale")
    private Integer idSale;
    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    @Column(name = "number_of_tickets")
    private Integer numberOfTickets;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @JoinColumn(name = "client_id", referencedColumnName = "idClient")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "excursion_id", referencedColumnName = "id_excursions")
    @ManyToOne
    private Excursions excursionId;

    public Excursionsales() {
    }

    public Excursionsales(Integer idSale) {
        this.idSale = idSale;
    }

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
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

    public Excursions getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Excursions excursionId) {
        this.excursionId = excursionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSale != null ? idSale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Excursionsales)) {
            return false;
        }
        Excursionsales other = (Excursionsales) object;
        if ((this.idSale == null && other.idSale != null) || (this.idSale != null && !this.idSale.equals(other.idSale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Excursionsales[ idSale=" + idSale + " ]";
    }
    
}
