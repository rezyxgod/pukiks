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
@Table(name = "director")
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
    @NamedQuery(name = "Director.findByIdDirector", query = "SELECT d FROM Director d WHERE d.idDirector = :idDirector")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDirector")
    private Integer idDirector;
    @JoinColumn(name = "director_user", referencedColumnName = "idusers")
    @ManyToOne
    private Users directorUser;

    public Director() {
    }

    public List<Director> getUserDirector(int iDuser,
            EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Director> cq = cb.createQuery(Director.class);
        Root<Director> root = cq.from(Director.class);
        Join<Director, Users> user = root.join(Director_.directorUser);
        user.on(cb.equal(user.get(Users_.idusers), iDuser));
        cq.select(root).where(cb.equal(user.get(Users_.idusers), iDuser));
        TypedQuery query = em.createQuery(cq);
        List<Director> userDirector = query.getResultList();
        return userDirector;
    }
    
    public Director(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Users getDirectorUser() {
        return directorUser;
    }

    public void setDirectorUser(Users directorUser) {
        this.directorUser = directorUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDirector != null ? idDirector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.idDirector == null && other.idDirector != null) || (this.idDirector != null && !this.idDirector.equals(other.idDirector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Director[ idDirector=" + idDirector + " ]";
    }
    
}
