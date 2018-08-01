/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.transaction.owner.jpa;

import com.yritys.transaction.account.jpa.Account;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author tommib
 */
@Entity
public class Owner extends AbstractPersistable<Long>{
    
    @Id
    private Long id;
    private String name;
    private String surname; 
    @OneToMany
    private List<Account> accounts;
    
    public Owner(){
        
    }
    
    public Owner(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.accounts = new ArrayList<>();
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "Owner ID: " + id + ", name:" + name + ", surname=" + surname + ", accounts: " + accounts + '}';
    }
   
}
