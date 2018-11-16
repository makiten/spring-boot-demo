package com.harlandclarke.bootdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "Person", catalog = "DB", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
        , @NamedQuery(name = "Person.findByPersonIndex", query = "SELECT p FROM Person p WHERE p.personIndex = ?1")
        , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = ?1")
        , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = ?1")
        , @NamedQuery(name = "Person.findByAccountNumber", query = "SELECT p FROM Person p WHERE p.accountNumber = ?1")
        , @NamedQuery(name = "Person.findByRoutingNumber", query = "SELECT p FROM Person p WHERE p.routingNumber = ?1")
        , @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = ?1")
        , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = ?1")
        , @NamedQuery(name = "Person.findByLoginID", query = "SELECT p FROM Person p WHERE p.loginID = ?1")
})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PersonIndex")
    private Integer personIndex;
    @Size(max = 45)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "AccountNumber")
    private String accountNumber;
    @Size(max = 45)
    @Column(name = "RoutingNumber")
    private String routingNumber;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email")
    private String email;
    @Size(max = 45)
    @Column(name = "LoginID")
    private String loginID;

    public Person() {
    }

    public Person(Integer personIndex) {
        this.personIndex = personIndex;
    }

    public Integer getPersonIndex() {
        return personIndex;
    }

    public void setPersonIndex(Integer personIndex) {
        this.personIndex = personIndex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personIndex != null ? personIndex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personIndex == null && other.personIndex != null) || (this.personIndex != null && !this.personIndex.equals(other.personIndex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.Person[ personIndex=" + personIndex + " ]";
    }

}
