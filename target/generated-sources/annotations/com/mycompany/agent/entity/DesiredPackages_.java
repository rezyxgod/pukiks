package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Packages;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(DesiredPackages.class)
public class DesiredPackages_ { 

    public static volatile SingularAttribute<DesiredPackages, Client> clientId;
    public static volatile SingularAttribute<DesiredPackages, Packages> packageId;
    public static volatile SingularAttribute<DesiredPackages, Integer> desiredPackageId;

}