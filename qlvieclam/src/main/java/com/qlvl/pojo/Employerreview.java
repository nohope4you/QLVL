/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "employerreview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employerreview.findAll", query = "SELECT e FROM Employerreview e"),
    @NamedQuery(name = "Employerreview.findById", query = "SELECT e FROM Employerreview e WHERE e.id = :id"),
    @NamedQuery(name = "Employerreview.findByCmt", query = "SELECT e FROM Employerreview e WHERE e.cmt = :cmt"),
    @NamedQuery(name = "Employerreview.findByRating", query = "SELECT e FROM Employerreview e WHERE e.rating = :rating")})
public class Employerreview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "cmt")
    private String cmt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Double rating;
    @JoinColumn(name = "EmployerID", referencedColumnName = "id")
    @ManyToOne
    private Employer employerID;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne
    private User userID;

    public Employerreview() {
    }

    public Employerreview(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Employer getEmployerID() {
        return employerID;
    }

    public void setEmployerID(Employer employerID) {
        this.employerID = employerID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employerreview)) {
            return false;
        }
        Employerreview other = (Employerreview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlvl.pojo.Employerreview[ id=" + id + " ]";
    }
    
}
