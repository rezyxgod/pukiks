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
 * @author 207380
 */
@Entity
@Table(name = "hotel_bookings")
@NamedQueries({
    @NamedQuery(name = "HotelBookings.findAll", query = "SELECT h FROM HotelBookings h"),
    @NamedQuery(name = "HotelBookings.findByIdBooking", query = "SELECT h FROM HotelBookings h WHERE h.idBooking = :idBooking"),
    @NamedQuery(name = "HotelBookings.findByCheckInDate", query = "SELECT h FROM HotelBookings h WHERE h.checkInDate = :checkInDate"),
    @NamedQuery(name = "HotelBookings.findByCheckOutDate", query = "SELECT h FROM HotelBookings h WHERE h.checkOutDate = :checkOutDate"),
    @NamedQuery(name = "HotelBookings.findByTotalPrice", query = "SELECT h FROM HotelBookings h WHERE h.totalPrice = :totalPrice")})
public class HotelBookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_booking")
    private Integer idBooking;
    @Column(name = "check_in_date")
    @Temporal(TemporalType.DATE)
    private Date checkInDate;
    @Column(name = "check_out_date")
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @JoinColumn(name = "client_id", referencedColumnName = "idClient")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "hotel_id", referencedColumnName = "idHotel")
    @ManyToOne
    private Hotel hotelId;

    public HotelBookings() {
    }

    public HotelBookings(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
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

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelBookings)) {
            return false;
        }
        HotelBookings other = (HotelBookings) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.HotelBookings[ idBooking=" + idBooking + " ]";
    }
    
}
