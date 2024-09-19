package com.mycompany.agent.entity;

import com.mycompany.agent.entity.DesiredPackages;
import com.mycompany.agent.entity.PackageSales;
import com.mycompany.agent.entity.PackageWishes;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Packages.class)
public class Packages_ { 

    public static volatile SingularAttribute<Packages, Date> endDate;
    public static volatile SingularAttribute<Packages, String> price;
    public static volatile SingularAttribute<Packages, Integer> packageId;
    public static volatile SingularAttribute<Packages, String> destination;
    public static volatile CollectionAttribute<Packages, PackageSales> packageSalesCollection;
    public static volatile CollectionAttribute<Packages, DesiredPackages> desiredPackagesCollection;
    public static volatile SingularAttribute<Packages, String> type;
    public static volatile SingularAttribute<Packages, Date> startDate;
    public static volatile CollectionAttribute<Packages, PackageWishes> packageWishesCollection;
    public static volatile SingularAttribute<Packages, String> status;

}