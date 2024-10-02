package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Packages;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-27T12:32:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PackageSales.class)
public class PackageSales_ { 

    public static volatile SingularAttribute<PackageSales, Client> clientId;
    public static volatile SingularAttribute<PackageSales, BigDecimal> totalPrice;
    public static volatile SingularAttribute<PackageSales, Integer> packageSaleId;
    public static volatile SingularAttribute<PackageSales, Packages> packageId;
    public static volatile SingularAttribute<PackageSales, Date> saleDate;

}