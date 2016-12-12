package com.sbrf.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Owner;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -8568681083447054748L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @OneToOne(mappedBy = "user_id")
    Owner owner;

    public User() {}

    public User(long id, String login, String password, Owner owner) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.owner = owner;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
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
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
