/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 207371
 */
@Entity
@Table(name = "consultations")
@NamedQueries({
    @NamedQuery(name = "Consultations.findAll", query = "SELECT c FROM Consultations c"),
    @NamedQuery(name = "Consultations.findByIdConsultations", query = "SELECT c FROM Consultations c WHERE c.idConsultations = :idConsultations"),
    @NamedQuery(name = "Consultations.findByDate", query = "SELECT c FROM Consultations c WHERE c.date = :date"),
    @NamedQuery(name = "Consultations.findByTopic", query = "SELECT c FROM Consultations c WHERE c.topic = :topic"),
    @NamedQuery(name = "Consultations.findByStatus", query = "SELECT c FROM Consultations c WHERE c.status = :status")})
public class Consultations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultations")
    private Integer idConsultations;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "topic")
    private String topic;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "client_id", referencedColumnName = "idusers")
    @ManyToOne
    private Users clientId;

    public Consultations() {
    }

    public Consultations(Integer idConsultations) {
        this.idConsultations = idConsultations;
    }

    public Integer getIdConsultations() {
        return idConsultations;
    }

    public void setIdConsultations(Integer idConsultations) {
        this.idConsultations = idConsultations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getClientId() {
        return clientId;
    }

    public void setClientId(Users clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultations != null ? idConsultations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultations)) {
            return false;
        }
        Consultations other = (Consultations) object;
        if ((this.idConsultations == null && other.idConsultations != null) || (this.idConsultations != null && !this.idConsultations.equals(other.idConsultations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Consultations[ idConsultations=" + idConsultations + " ]";
    }
    
}
