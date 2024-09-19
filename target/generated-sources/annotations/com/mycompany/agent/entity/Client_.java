package com.mycompany.agent.entity;

import com.mycompany.agent.entity.DesiredPackages;
import com.mycompany.agent.entity.Excursionsales;
import com.mycompany.agent.entity.HotelBookings;
import com.mycompany.agent.entity.PackageSales;
import com.mycompany.agent.entity.PackageWishes;
import com.mycompany.agent.entity.RoomSales;
import com.mycompany.agent.entity.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Users> clientUser;
    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile CollectionAttribute<Client, Excursionsales> excursionsalesCollection;
    public static volatile CollectionAttribute<Client, PackageSales> packageSalesCollection;
    public static volatile CollectionAttribute<Client, DesiredPackages> desiredPackagesCollection;
    public static volatile CollectionAttribute<Client, HotelBookings> hotelBookingsCollection;
    public static volatile CollectionAttribute<Client, PackageWishes> packageWishesCollection;
    public static volatile CollectionAttribute<Client, RoomSales> roomSalesCollection;

}