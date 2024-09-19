/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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

/**
 *
 * @author 207371
 */
@Entity
@Table(name = "hotel")
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findByIdHotel", query = "SELECT h FROM Hotel h WHERE h.idHotel = :idHotel"),
    @NamedQuery(name = "Hotel.findByName", query = "SELECT h FROM Hotel h WHERE h.name = :name"),
    @NamedQuery(name = "Hotel.findByPhone", query = "SELECT h FROM Hotel h WHERE h.phone = :phone"),
    @NamedQuery(name = "Hotel.findByKolvoNomerov", query = "SELECT h FROM Hotel h WHERE h.kolvoNomerov = :kolvoNomerov"),
    @NamedQuery(name = "Hotel.findByRating", query = "SELECT h FROM Hotel h WHERE h.rating = :rating"),
    @NamedQuery(name = "Hotel.findByAddress", query = "SELECT h FROM Hotel h WHERE h.address = :address"),
    @NamedQuery(name = "Hotel.findByKolvoStar", query = "SELECT h FROM Hotel h WHERE h.kolvoStar = :kolvoStar"),
    @NamedQuery(name = "Hotel.findByPrice", query = "SELECT h FROM Hotel h WHERE h.price = :price")})
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHotel")
    private Integer idHotel;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "kolvoNomerov")
    private Integer kolvoNomerov;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "address")
    private String address;
    @Column(name = "kolvoStar")
    private Integer kolvoStar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(mappedBy = "hotelId")
    private Collection<RoomSales> roomSalesCollection;
    @OneToMany(mappedBy = "hotelId")
    private Collection<HotelBookings> hotelBookingsCollection;

    public Hotel() {
    }

    public Hotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getKolvoNomerov() {
        return kolvoNomerov;
    }

    public void setKolvoNomerov(Integer kolvoNomerov) {
        this.kolvoNomerov = kolvoNomerov;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getKolvoStar() {
        return kolvoStar;
    }

    public void setKolvoStar(Integer kolvoStar) {
        this.kolvoStar = kolvoStar;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Collection<RoomSales> getRoomSalesCollection() {
        return roomSalesCollection;
    }

    public void setRoomSalesCollection(Collection<RoomSales> roomSalesCollection) {
        this.roomSalesCollection = roomSalesCollection;
    }

    public Collection<HotelBookings> getHotelBookingsCollection() {
        return hotelBookingsCollection;
    }

    public void setHotelBookingsCollection(Collection<HotelBookings> hotelBookingsCollection) {
        this.hotelBookingsCollection = hotelBookingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHotel != null ? idHotel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.idHotel == null && other.idHotel != null) || (this.idHotel != null && !this.idHotel.equals(other.idHotel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Hotel[ idHotel=" + idHotel + " ]";
    }
    
}
