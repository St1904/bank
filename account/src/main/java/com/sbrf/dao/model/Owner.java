package com.sbrf.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {
    private static final long serialVersionUID = -8568681083447054748L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    @Column(name = "firstName")
    String firstName;

    @Column(name = "middleName")
    String middleName;

    @Column(name = "lastName")
    String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner_id")
    Set<Account> accounts;

    @OneToOne
    @JoinColumn(name = "user_id")
    long userId;

    public Owner() {
    }

    public Owner(long id, String firstName, String middleName, String lastName, Set<Account> accounts, long userId) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.accounts = accounts;
        this.userId = userId;
    }

    public Owner(String firstName, String middleName, String lastName, long userId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userId = userId;
        this.accounts = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                ", userId=" + userId +
                '}';
    }
}
