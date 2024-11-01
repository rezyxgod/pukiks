/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gleb9
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdusers", query = "SELECT u FROM Users u WHERE u.idusers = :idusers"),
    @NamedQuery(name = "Users.findByImya", query = "SELECT u FROM Users u WHERE u.imya = :imya"),
    @NamedQuery(name = "Users.findByFamiliya", query = "SELECT u FROM Users u WHERE u.familiya = :familiya"),
    @NamedQuery(name = "Users.findByOtchestvo", query = "SELECT u FROM Users u WHERE u.otchestvo = :otchestvo"),
    @NamedQuery(name = "Users.findByDataRoj", query = "SELECT u FROM Users u WHERE u.dataRoj = :dataRoj"),
    @NamedQuery(name = "Users.findByDataTruda", query = "SELECT u FROM Users u WHERE u.dataTruda = :dataTruda"),
    @NamedQuery(name = "Users.findByPassportSeries", query = "SELECT u FROM Users u WHERE u.passportSeries = :passportSeries"),
    @NamedQuery(name = "Users.findByPassportNumber", query = "SELECT u FROM Users u WHERE u.passportNumber = :passportNumber"),
    @NamedQuery(name = "Users.findBySnils", query = "SELECT u FROM Users u WHERE u.snils = :snils"),
    @NamedQuery(name = "Users.findByCode", query = "SELECT u FROM Users u WHERE u.code = :code"),
    @NamedQuery(name = "Users.findByPodtverzdenie", query = "SELECT u FROM Users u WHERE u.podtverzdenie = :podtverzdenie"),
    @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusers")
    private Integer idusers;
    @Column(name = "Imya")
    private String imya;
    @Column(name = "Familiya")
    private String familiya;
    @Column(name = "Otchestvo")
    private String otchestvo;
    @Column(name = "dataRoj")
    @Temporal(TemporalType.DATE)
    private Date dataRoj;
    @Column(name = "dataTruda")
    @Temporal(TemporalType.DATE)
    private Date dataTruda;
    @Column(name = "passportSeries")
    private String passportSeries;
    @Column(name = "passportNumber")
    private String passportNumber;
    @Column(name = "snils")
    private String snils;
    @Lob
    @Column(name = "photolink")
    private String photolink;
    @Column(name = "code")
    private String code;
    @Column(name = "Podtverzdenie")
    private String podtverzdenie;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Users() {
    }
    public List<Users> getUsersList(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Users> userList = query.getResultList();
        return userList;
    }

    public void addUsers(Users users, EntityManager em) {
        em.getTransaction().begin();
        em.persist(users);
        em.getTransaction().commit();

    }

    public void deleteUsers(Users users, EntityManager em) {
        em.getTransaction().begin();
        Users u = em.find(Users.class, users.getIdusers());
        em.remove(u);
        em.getTransaction().commit();
    }
    public void upDateUsers(Users employees, EntityManager em) {
        em.getTransaction().begin();
        Users emp = em.find(Users.class, employees.getIdusers());
        emp.setImya(employees.getImya());
        emp.setFamiliya(employees.getFamiliya());
        emp.setOtchestvo(employees.getOtchestvo());
        emp.setDataRoj(employees.getDataRoj());
        emp.setDataTruda(employees.getDataTruda());
        emp.setPassportSeries(employees.getPassportSeries());
        emp.setPassportNumber(employees.getPassportNumber());
        emp.setSnils(employees.getSnils());
        emp.setPhotolink(employees.getPhotolink());
        emp.setCode(employees.getCode());
        emp.setPodtverzdenie(employees.getPodtverzdenie());
        emp.setLogin(employees.getLogin());
        emp.setPassword(employees.getPassword());
        em.merge(emp);
        em.getTransaction().commit();
    }
     public List<Users> getUserLoginPassword(String login, String password,
            EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);
        cq.select(root).where(cb.and(cb.equal(root.get(Users_.login), login),
                cb.equal(root.get(Users_.password), password)));
        TypedQuery query = em.createQuery(cq);
        List<Users> userLoginPassword = query.getResultList();
        return userLoginPassword;
    }

    public Users(Integer idusers) {
        this.idusers = idusers;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public Date getDataRoj() {
        return dataRoj;
    }

    public void setDataRoj(Date dataRoj) {
        this.dataRoj = dataRoj;
    }

    public Date getDataTruda() {
        return dataTruda;
    }

    public void setDataTruda(Date dataTruda) {
        this.dataTruda = dataTruda;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getPhotolink() {
        return photolink;
    }

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPodtverzdenie() {
        return podtverzdenie;
    }

    public void setPodtverzdenie(String podtverzdenie) {
        this.podtverzdenie = podtverzdenie;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusers != null ? idusers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idusers == null && other.idusers != null) || (this.idusers != null && !this.idusers.equals(other.idusers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.agent.entity.Users[ idusers=" + idusers + " ]";
    }
    
}
