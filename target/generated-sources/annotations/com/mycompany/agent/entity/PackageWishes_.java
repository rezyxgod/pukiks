package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Packages;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-27T12:32:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PackageWishes.class)
public class PackageWishes_ { 

    public static volatile SingularAttribute<PackageWishes, Client> clientId;
    public static volatile SingularAttribute<PackageWishes, Packages> packageId;
    public static volatile SingularAttribute<PackageWishes, String> wishDescription;
    public static volatile SingularAttribute<PackageWishes, Integer> wishId;

}