package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Users;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Integer> idTicket;
    public static volatile SingularAttribute<Ticket, Users> clientId;
    public static volatile SingularAttribute<Ticket, Integer> price;
    public static volatile SingularAttribute<Ticket, Date> departureDate;
    public static volatile SingularAttribute<Ticket, String> flightNumber;
    public static volatile SingularAttribute<Ticket, String> arrivalDate;
    public static volatile SingularAttribute<Ticket, String> status;

}