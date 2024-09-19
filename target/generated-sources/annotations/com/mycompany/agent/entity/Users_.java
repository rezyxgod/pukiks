package com.mycompany.agent.entity;

import com.mycompany.agent.entity.Admin;
import com.mycompany.agent.entity.Agent;
import com.mycompany.agent.entity.Client;
import com.mycompany.agent.entity.Consultations;
import com.mycompany.agent.entity.Director;
import com.mycompany.agent.entity.Manager;
import com.mycompany.agent.entity.Ticket;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-17T12:15:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> code;
    public static volatile CollectionAttribute<Users, Consultations> consultationsCollection;
    public static volatile SingularAttribute<Users, Date> dataRoj;
    public static volatile CollectionAttribute<Users, Client> clientCollection;
    public static volatile SingularAttribute<Users, String> login;
    public static volatile CollectionAttribute<Users, Agent> agentCollection;
    public static volatile SingularAttribute<Users, String> otchestvo;
    public static volatile SingularAttribute<Users, Date> dataTruda;
    public static volatile SingularAttribute<Users, String> familiya;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> photolink;
    public static volatile SingularAttribute<Users, Integer> idusers;
    public static volatile SingularAttribute<Users, String> passport;
    public static volatile CollectionAttribute<Users, Ticket> ticketCollection;
    public static volatile CollectionAttribute<Users, Admin> adminCollection;
    public static volatile SingularAttribute<Users, String> imya;
    public static volatile SingularAttribute<Users, String> snils;
    public static volatile SingularAttribute<Users, String> podtverzdenie;
    public static volatile CollectionAttribute<Users, Manager> managerCollection;
    public static volatile CollectionAttribute<Users, Director> directorCollection;

}