package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Hotel;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(HotelBookings.class)
public class HotelBookings_ { 

    public static volatile SingularAttribute<HotelBookings, Client> clientId;
    public static volatile SingularAttribute<HotelBookings, Integer> idBooking;
    public static volatile SingularAttribute<HotelBookings, Date> checkOutDate;
    public static volatile SingularAttribute<HotelBookings, BigDecimal> totalPrice;
    public static volatile SingularAttribute<HotelBookings, Hotel> hotelId;
    public static volatile SingularAttribute<HotelBookings, Date> checkInDate;

}