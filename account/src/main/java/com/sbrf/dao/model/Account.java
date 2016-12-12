package com.sbrf.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {
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
    Owner owner;

    public Account() {
    }

    public Account(long id, Owner owner, BigDecimal money) {
        this.id = id;
        this.owner = owner;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
