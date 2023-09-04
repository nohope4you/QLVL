/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "employer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employer.findAll", query = "SELECT e FROM Employer e"),
    @NamedQuery(name = "Employer.findById", query = "SELECT e FROM Employer e WHERE e.id = :id"),
    @NamedQuery(name = "Employer.findByNameEmployer", query = "SELECT e FROM Employer e WHERE e.nameEmployer = :nameEmployer"),
    @NamedQuery(name = "Employer.findByNameCompany", query = "SELECT e FROM Employer e WHERE e.nameCompany = :nameCompany"),
    @NamedQuery(name = "Employer.findByAddressComapny", query = "SELECT e FROM Employer e WHERE e.addressComapny = :addressComapny"),
    @NamedQuery(name = "Employer.findBySoDienThoai", query = "SELECT e FROM Employer e WHERE e.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "Employer.findByAvatar", query = "SELECT e FROM Employer e WHERE e.avatar = :avatar"),
    @NamedQuery(name = "Employer.findByNganhNghe", query = "SELECT e FROM Employer e WHERE e.nganhNghe = :nganhNghe"),
    @NamedQuery(name = "Employer.findByIsApproved", query = "SELECT e FROM Employer e WHERE e.isApproved = :isApproved")})
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nameEmployer")
    private String nameEmployer;
    @Size(max = 50)
    @Column(name = "nameCompany")
    private String nameCompany;
    @Size(max = 50)
    @Column(name = "AddressComapny")
    private String addressComapny;
    @Size(max = 13)
    @Column(name = "soDienThoai")
    private String soDienThoai;
    @Size(max = 200)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 50)
    @Column(name = "NganhNghe")
    private String nganhNghe;
    @Column(name = "isApproved")
    private Boolean isApproved;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne
    private User userID;
    @OneToMany(mappedBy = "employerID")
    @JsonIgnore
    private Set<Employerreview> employerreviewSet;
    @OneToMany(mappedBy = "employerID")
    @JsonIgnore
    private Set<Job> jobSet;

    @Transient
    private MultipartFile file;
    public Employer() {
    }

    public Employer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEmployer() {
        return nameEmployer;
    }

    public void setNameEmployer(String nameEmployer) {
        this.nameEmployer = nameEmployer;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getAddressComapny() {
        return addressComapny;
    }

    public void setAddressComapny(String addressComapny) {
        this.addressComapny = addressComapny;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNganhNghe() {
        return nganhNghe;
    }

    public void setNganhNghe(String nganhNghe) {
        this.nganhNghe = nganhNghe;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Set<Employerreview> getEmployerreviewSet() {
        return employerreviewSet;
    }

    public void setEmployerreviewSet(Set<Employerreview> employerreviewSet) {
        this.employerreviewSet = employerreviewSet;
    }

    @XmlTransient
    public Set<Job> getJobSet() {
        return jobSet;
    }

    public void setJobSet(Set<Job> jobSet) {
        this.jobSet = jobSet;
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
        if (!(object instanceof Employer)) {
            return false;
        }
        Employer other = (Employer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlvl.pojo.Employer[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
