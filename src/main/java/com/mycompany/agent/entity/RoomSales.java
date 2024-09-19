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
@Table(name = "room_sales")
@NamedQueries({
    @NamedQuery(name = "RoomSales.findAll", query = "SELECT r FROM RoomSales r"),
    @NamedQuery(name = "RoomSales.findBySaleId", query = "SELECT r FROM RoomSales r WHERE r.saleId = :saleId"),
    @NamedQuery(name = "RoomSales.findBySaleDate", query = "SELECT r FROM RoomSales r WHERE r.saleDate = :saleDate"),
    @NamedQuery(name = "RoomSales.findByNumberOfRooms", query = "SELECT r FROM RoomSales r WHERE r.numberOfRooms = :numberOfRooms"),
    @NamedQuery(name = "RoomSales.findByTotalPrice", query = "SELECT r FROM RoomSales r WHERE r.totalPrice = :totalPrice")})
public class RoomSales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sale_id")
    private Integer saleId;
    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @JoinColumn(name = "client_id", referencedColumnName = "idClient")
    @ManyToOne
    private Client clientId;
    @JoinColumn(name = "hotel_id", referencedColumnName = "idHotel")
    @ManyToOne
    private Hotel hotelId;

    public RoomSales() {
    }

    public RoomSales(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
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
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomSales)) {
            return false;
        }
        RoomSales other = (RoomSales) object;
        if ((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.RoomSales[ saleId=" + saleId + " ]";
    }
    
}
