/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author gleb9
 */
@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClient")
    private Integer idClient;
    @JoinColumn(name = "client_user", referencedColumnName = "idusers")
    @ManyToOne
    private Users clientUser;

    public Client() {
    }
    
     public List<Client> getUserClient(int iDuser,
EntityManager em) {
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Client> cq = cb.createQuery(Client.class);
Root<Client> root = cq.from(Client.class);
Join<Client, Users> user = root.join(Client_.clientUser);
user.on(cb.equal(user.get(Users_.idusers), iDuser));
cq.select(root).where(cb.equal(user.get(Users_.idusers), iDuser));
TypedQuery query = em.createQuery(cq);
List<Client> userDirector = query.getResultList();
return userDirector;
}
    public void addClient(Client client, EntityManager em) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public void deleteClient(Client Users, EntityManager em) {
        em.getTransaction().begin();
        Client u = em.find(Client.class, Users.getIdClient());
        em.remove(u);
        em.getTransaction().commit();
    }
    
    

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Users getClientUser() {
        return clientUser;
    }

    public void setClientUser(Users clientUser) {
        this.clientUser = clientUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Client[ idClient=" + idClient + " ]";
    }
    
}
