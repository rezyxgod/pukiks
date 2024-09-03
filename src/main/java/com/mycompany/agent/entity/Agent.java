/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 207380
 */
@Entity
@Table(name = "agent")
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findByIdAgent", query = "SELECT a FROM Agent a WHERE a.idAgent = :idAgent"),
    @NamedQuery(name = "Agent.findByAgentUser", query = "SELECT a FROM Agent a WHERE a.agentUser = :agentUser")})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgent")
    private Integer idAgent;
    @Column(name = "agent_User")
    private Integer agentUser;

    public Agent() {
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

    public Integer getAgentUser() {
        return agentUser;
    }

    public void setAgentUser(Integer agentUser) {
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
