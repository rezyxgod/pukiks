package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Users;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Consultations.class)
public class Consultations_ { 

    public static volatile SingularAttribute<Consultations, Date> date;
    public static volatile SingularAttribute<Consultations, Users> clientId;
    public static volatile SingularAttribute<Consultations, Integer> idConsultations;
    public static volatile SingularAttribute<Consultations, String> topic;
    public static volatile SingularAttribute<Consultations, String> status;

}