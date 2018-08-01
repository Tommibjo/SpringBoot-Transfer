/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.transaction.owner.service;

import com.yritys.transaction.account.jpa.Account;
import com.yritys.transaction.account.jpa.AccountRepository;
import com.yritys.transaction.owner.jpa.Owner;
import com.yritys.transaction.owner.jpa.OwnerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tommib
 */
@Service
public class OwnerService {

    @Autowired
    private AccountRepository accountrepository;
    @Autowired
    private OwnerRepository ownerrepository;

    public void createAccount(String name, String surname, double balance) {
        Owner owner = new Owner(name, surname);
        Account account = new Account(balance);
        accountrepository.saveAndFlush(account);
        owner.addAccount(account);
        ownerrepository.saveAndFlush(owner);
    }

    public List<Owner> getAllAccounts() {
        return ownerrepository.findAll();
    }

    public void addAccount(Long id, double balance) {
        Owner owner = ownerrepository.getOne(id);
        Account account = new Account(balance);
        accountrepository.saveAndFlush(account);
        owner.addAccount(account);
        ownerrepository.saveAndFlush(owner);
    }

    @Transactional
    public void transferMoney(Long id1, Long id2, double sum) {
        Account from = accountrepository.getOne(id1);
        Account to = accountrepository.getOne(id2);

        from.setBalance(from.getBalance() - sum);
        to.setBalance(to.getBalance() + sum);
    }
}
