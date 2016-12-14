package com.sbrf.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = -8568681083447054748L;

    @Id
    @Column(name = "id")
    @GeneratedValue
    long id;

    @Column(name = "number")
    long number;

    @Column(name = "money")
    BigDecimal money;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    long owner;

    public Account() {
    }

    public Account(long number, BigDecimal money, long owner) {
        this.number = number;
        this.money = money;
        this.owner = owner;
    }

    public Account(long number, long owner) {
        this.number = number;
        this.money = BigDecimal.ZERO;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number=" + number +
                ", money=" + money +
                ", owner=" + owner +
                '}';
    }
}
