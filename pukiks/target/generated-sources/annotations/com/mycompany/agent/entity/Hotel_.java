package com.mycompany.agent.entity;

import com.mycompany.agent.entity.HotelBookings;
import com.mycompany.agent.entity.RoomSales;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-27T12:32:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Hotel.class)
public class Hotel_ { 

    public static volatile SingularAttribute<Hotel, String> address;
    public static volatile SingularAttribute<Hotel, Integer> idHotel;
    public static volatile SingularAttribute<Hotel, String> phone;
    public static volatile SingularAttribute<Hotel, BigDecimal> price;
    public static volatile SingularAttribute<Hotel, String> name;
    public static volatile SingularAttribute<Hotel, Integer> rating;
    public static volatile CollectionAttribute<Hotel, HotelBookings> hotelBookingsCollection;
    public static volatile SingularAttribute<Hotel, Integer> kolvoNomerov;
    public static volatile SingularAttribute<Hotel, Integer> kolvoStar;
    public static volatile CollectionAttribute<Hotel, RoomSales> roomSalesCollection;

}