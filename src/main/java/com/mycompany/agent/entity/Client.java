/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 207371
 */
@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClient")
    private Integer idClient;
    @OneToMany(mappedBy = "clientId")
    private Collection<RoomSales> roomSalesCollection;
    @OneToMany(mappedBy = "clientId")
    private Collection<DesiredPackages> desiredPackagesCollection;
    @OneToMany(mappedBy = "clientId")
    private Collection<PackageWishes> packageWishesCollection;
    @OneToMany(mappedBy = "clientId")
    private Collection<HotelBookings> hotelBookingsCollection;
    @OneToMany(mappedBy = "clientId")
    private Collection<PackageSales> packageSalesCollection;
    @OneToMany(mappedBy = "clientId")
    private Collection<Excursionsales> excursionsalesCollection;
    @JoinColumn(name = "client_user", referencedColumnName = "idusers")
    @ManyToOne
    private Users clientUser;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Collection<RoomSales> getRoomSalesCollection() {
        return roomSalesCollection;
    }

    public void setRoomSalesCollection(Collection<RoomSales> roomSalesCollection) {
        this.roomSalesCollection = roomSalesCollection;
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

    public Collection<HotelBookings> getHotelBookingsCollection() {
        return hotelBookingsCollection;
    }

    public void setHotelBookingsCollection(Collection<HotelBookings> hotelBookingsCollection) {
        this.hotelBookingsCollection = hotelBookingsCollection;
    }

    public Collection<PackageSales> getPackageSalesCollection() {
        return packageSalesCollection;
    }

    public void setPackageSalesCollection(Collection<PackageSales> packageSalesCollection) {
        this.packageSalesCollection = packageSalesCollection;
    }

    public Collection<Excursionsales> getExcursionsalesCollection() {
        return excursionsalesCollection;
    }

    public void setExcursionsalesCollection(Collection<Excursionsales> excursionsalesCollection) {
        this.excursionsalesCollection = excursionsalesCollection;
    }

    public Users getClientUser() {
        return clientUser;
    }

    public void setClientUser(Users clientUser) {
        this.clientUser = clientUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Client[ idClient=" + idClient + " ]";
    }
    
}
