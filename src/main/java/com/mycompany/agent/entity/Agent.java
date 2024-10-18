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
@Table(name = "agent")
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findByIdAgent", query = "SELECT a FROM Agent a WHERE a.idAgent = :idAgent")})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgent")
    private Integer idAgent;
    @JoinColumn(name = "agent_User", referencedColumnName = "idusers")
    @ManyToOne
    private Users agentUser;

    public Agent() {
    }

    public List<Agent> getUserAgent(int iDuser,
            EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Agent> cq = cb.createQuery(Agent.class);
        Root<Agent> root = cq.from(Agent.class);
        Join<Agent, Users> user = root.join(Agent_.agentUser);
        user.on(cb.equal(user.get(Users_.idusers), iDuser));
        cq.select(root).where(cb.equal(user.get(Users_.idusers), iDuser));
        TypedQuery query = em.createQuery(cq);
        List<Agent> userDirector = query.getResultList();
        return userDirector;
    }
    
    public Agent(Integer idAgent) {
        this.idAgent = idAgent;
    }

    public Integer getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Integer idAgent) {
        this.idAgent = idAgent;
    }

    public Users getAgentUser() {
        return agentUser;
    }

    public void setAgentUser(Users agentUser) {
        this.agentUser = agentUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgent != null ? idAgent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.idAgent == null && other.idAgent != null) || (this.idAgent != null && !this.idAgent.equals(other.idAgent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Agent[ idAgent=" + idAgent + " ]";
    }
    
}
