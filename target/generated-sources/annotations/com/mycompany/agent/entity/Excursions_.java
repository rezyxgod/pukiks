package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Excursionsales;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-27T12:32:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Excursions.class)
public class Excursions_ { 

    public static volatile SingularAttribute<Excursions, Integer> idExcursions;
    public static volatile SingularAttribute<Excursions, Date> endDate;
    public static volatile CollectionAttribute<Excursions, Excursionsales> excursionsalesCollection;
    public static volatile SingularAttribute<Excursions, BigDecimal> price;
    public static volatile SingularAttribute<Excursions, String> name;
    public static volatile SingularAttribute<Excursions, String> description;
    public static volatile SingularAttribute<Excursions, Integer> availableSlots;
    public static volatile SingularAttribute<Excursions, Date> startDate;

}