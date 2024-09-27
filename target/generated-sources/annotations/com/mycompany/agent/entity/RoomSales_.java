package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Hotel;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-27T12:32:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(RoomSales.class)
public class RoomSales_ { 

    public static volatile SingularAttribute<RoomSales, Client> clientId;
    public static volatile SingularAttribute<RoomSales, Integer> saleId;
    public static volatile SingularAttribute<RoomSales, BigDecimal> totalPrice;
    public static volatile SingularAttribute<RoomSales, Integer> numberOfRooms;
    public static volatile SingularAttribute<RoomSales, Date> saleDate;
    public static volatile SingularAttribute<RoomSales, Hotel> hotelId;

}