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
@Table(name = "application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findById", query = "SELECT a FROM Application a WHERE a.id = :id"),
    @NamedQuery(name = "Application.findByFileCV", query = "SELECT a FROM Application a WHERE a.fileCV = :fileCV"),
    @NamedQuery(name = "Application.findByHo", query = "SELECT a FROM Application a WHERE a.ho = :ho"),
    @NamedQuery(name = "Application.findByTen", query = "SELECT a FROM Application a WHERE a.ten = :ten"),
    @NamedQuery(name = "Application.findByEmail", query = "SELECT a FROM Application a WHERE a.email = :email"),
    @NamedQuery(name = "Application.findBySdt", query = "SELECT a FROM Application a WHERE a.sdt = :sdt"),
    @NamedQuery(name = "Application.findByNgheNghiep", query = "SELECT a FROM Application a WHERE a.ngheNghiep = :ngheNghiep"),
    @NamedQuery(name = "Application.findByTrinhDoHocVan", query = "SELECT a FROM Application a WHERE a.trinhDoHocVan = :trinhDoHocVan"),
    @NamedQuery(name = "Application.findByAddressUser", query = "SELECT a FROM Application a WHERE a.addressUser = :addressUser"),
    @NamedQuery(name = "Application.findByNamKinhNghiem", query = "SELECT a FROM Application a WHERE a.namKinhNghiem = :namKinhNghiem"),
    @NamedQuery(name = "Application.findByTuoi", query = "SELECT a FROM Application a WHERE a.tuoi = :tuoi")})
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "fileCV")
    private String fileCV;
    @Size(max = 50)
    @Column(name = "ho")
    private String ho;
    @Size(max = 50)
    @Column(name = "ten")
    private String ten;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "sdt")
    private String sdt;
    @Size(max = 50)
    @Column(name = "NgheNghiep")
    private String ngheNghiep;
    @Size(max = 50)
    @Column(name = "trinhDoHocVan")
    private String trinhDoHocVan;
    @Size(max = 50)
    @Column(name = "addressUser")
    private String addressUser;
    @Column(name = "NamKinhNghiem")
    private Integer namKinhNghiem;
    @Column(name = "Tuoi")
    private Integer tuoi;
    @JoinColumn(name = "jobID", referencedColumnName = "id")
    @ManyToOne
    private Job jobID;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne
    private User userID;

    public Application() {
    }

    public Application(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileCV() {
        return fileCV;
    }

    public void setFileCV(String fileCV) {
        this.fileCV = fileCV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getTrinhDoHocVan() {
        return trinhDoHocVan;
    }

    public void setTrinhDoHocVan(String trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public Integer getNamKinhNghiem() {
        return namKinhNghiem;
    }

    public void setNamKinhNghiem(Integer namKinhNghiem) {
        this.namKinhNghiem = namKinhNghiem;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public Job getJobID() {
        return jobID;
    }

    public void setJobID(Job jobID) {
        this.jobID = jobID;
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
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlvl.pojo.Application[ id=" + id + " ]";
    }
    
}
