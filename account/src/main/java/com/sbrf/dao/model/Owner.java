package com.sbrf.dao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner_id")
    List<Account> accounts;

    @OneToOne
    @JoinColumn(name = "user_id")
    long userId;

    public Owner() {
    }

    public Owner(long id, String firstName, String middleName, String lastName, List<Account> accounts, long userId) {
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
    }

    public long getId() {
        return id;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
