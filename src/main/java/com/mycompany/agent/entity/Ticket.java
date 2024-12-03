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
 * @author 207380
 */
@Entity
@Table(name = "ticket")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket"),
    @NamedQuery(name = "Ticket.findByNameTicket", query = "SELECT t FROM Ticket t WHERE t.nameTicket = :nameTicket"),
    @NamedQuery(name = "Ticket.findByFlightNumber", query = "SELECT t FROM Ticket t WHERE t.flightNumber = :flightNumber"),
    @NamedQuery(name = "Ticket.findByDepartureDate", query = "SELECT t FROM Ticket t WHERE t.departureDate = :departureDate"),
    @NamedQuery(name = "Ticket.findByArrivalDate", query = "SELECT t FROM Ticket t WHERE t.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "Ticket.findByPrice", query = "SELECT t FROM Ticket t WHERE t.price = :price")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Column(name = "name_ticket")
    private String nameTicket;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "price")
    private Integer price;
    @OneToMany(mappedBy = "idTicket")
    private Collection<PackageSales> packageSalesCollection;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
