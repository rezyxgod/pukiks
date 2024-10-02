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
 * @author 207371
 */
@Entity
@Table(name = "manager")
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m"),
    @NamedQuery(name = "Manager.findByIdManager", query = "SELECT m FROM Manager m WHERE m.idManager = :idManager")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idManager")
    private Integer idManager;
    @JoinColumn(name = "manager_user", referencedColumnName = "idusers")
    @ManyToOne
    private Users managerUser;

    public Manager() {
    }

    public List<Manager> getUserManager(int iDuser,
            EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Manager> cq = cb.createQuery(Manager.class);
        Root<Manager> root = cq.from(Manager.class);
        Join<Manager, Users> user = root.join(Manager_.managerUser);
        user.on(cb.equal(user.get(Users_.idusers), iDuser));
        cq.select(root).where(cb.equal(user.get(Users_.idusers), iDuser));
        TypedQuery query = em.createQuery(cq);
        List<Manager> userDirector = query.getResultList();
        return userDirector;
    }
    
    public Manager(Integer idManager) {
        this.idManager = idManager;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public Users getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(Users managerUser) {
        this.managerUser = managerUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManager != null ? idManager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.idManager == null && other.idManager != null) || (this.idManager != null && !this.idManager.equals(other.idManager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Manager[ idManager=" + idManager + " ]";
    }
    
}
