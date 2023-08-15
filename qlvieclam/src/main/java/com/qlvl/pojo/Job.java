/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlvl.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id"),
    @NamedQuery(name = "Job.findByNameJob", query = "SELECT j FROM Job j WHERE j.nameJob = :nameJob"),
    @NamedQuery(name = "Job.findBySoLuongTuyenDung", query = "SELECT j FROM Job j WHERE j.soLuongTuyenDung = :soLuongTuyenDung"),
    @NamedQuery(name = "Job.findByKinhNghiem", query = "SELECT j FROM Job j WHERE j.kinhNghiem = :kinhNghiem"),
    @NamedQuery(name = "Job.findByAge", query = "SELECT j FROM Job j WHERE j.age = :age")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nameJob")
    private String nameJob;
    @Lob
    @Size(max = 16777215)
    @Column(name = "salary")
    private String salary;
    @Column(name = "SoLuongTuyenDung")
    private Integer soLuongTuyenDung;
    @Column(name = "KinhNghiem")
    private Integer kinhNghiem;
    @Column(name = "Age")
    private Integer age;
    @OneToMany(mappedBy = "jobID")
    private Set<Application> applicationSet;
    @JoinColumn(name = "cityID", referencedColumnName = "id")
    @ManyToOne
    private City cityID;
    @JoinColumn(name = "districID", referencedColumnName = "id")
    @ManyToOne
    private District districID;
    @JoinColumn(name = "EducationID", referencedColumnName = "id")
    @ManyToOne
    private Education educationID;
    @JoinColumn(name = "employerID", referencedColumnName = "id")
    @ManyToOne
    private Employer employerID;
    @JoinColumn(name = "majorID", referencedColumnName = "id")
    @ManyToOne
    private Major majorID;
    @JoinColumn(name = "typeJobID", referencedColumnName = "id")
    @ManyToOne
    private Typejob typeJobID;

    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getSoLuongTuyenDung() {
        return soLuongTuyenDung;
    }

    public void setSoLuongTuyenDung(Integer soLuongTuyenDung) {
        this.soLuongTuyenDung = soLuongTuyenDung;
    }

    public Integer getKinhNghiem() {
        return kinhNghiem;
    }

    public void setKinhNghiem(Integer kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @XmlTransient
    public Set<Application> getApplicationSet() {
        return applicationSet;
    }

    public void setApplicationSet(Set<Application> applicationSet) {
        this.applicationSet = applicationSet;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    public District getDistricID() {
        return districID;
    }

    public void setDistricID(District districID) {
        this.districID = districID;
    }

    public Education getEducationID() {
        return educationID;
    }

    public void setEducationID(Education educationID) {
        this.educationID = educationID;
    }

    public Employer getEmployerID() {
        return employerID;
    }

    public void setEmployerID(Employer employerID) {
        this.employerID = employerID;
    }

    public Major getMajorID() {
        return majorID;
    }

    public void setMajorID(Major majorID) {
        this.majorID = majorID;
    }

    public Typejob getTypeJobID() {
        return typeJobID;
    }

    public void setTypeJobID(Typejob typeJobID) {
        this.typeJobID = typeJobID;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qlvl.pojo.Job[ id=" + id + " ]";
    }
    
}
