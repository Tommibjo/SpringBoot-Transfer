/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.transaction.account.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author tommib
 */
@Entity
public class Account extends AbstractPersistable<Long> {

    @Id
    private Long id;
    private String name;
    private String surname;
    private double balance;

    public Account() {
    }

    public Account(String name, String surname, double balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", balance=" + balance + '}';
    }

}
