package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Excursions;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-27T12:32:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Excursionsales.class)
public class Excursionsales_ { 

    public static volatile SingularAttribute<Excursionsales, Client> clientId;
    public static volatile SingularAttribute<Excursionsales, Integer> numberOfTickets;
    public static volatile SingularAttribute<Excursionsales, BigDecimal> totalPrice;
    public static volatile SingularAttribute<Excursionsales, Integer> idSale;
    public static volatile SingularAttribute<Excursionsales, Excursions> excursionId;
    public static volatile SingularAttribute<Excursionsales, Date> saleDate;

}