/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.transaction.account.service;

import com.yritys.transaction.account.jpa.Account;
import com.yritys.transaction.account.jpa.AccountRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tommib
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountrepository;
    
    public void createAccount(String name, String surname, double balance) {
        accountrepository.saveAndFlush(new Account(name, surname, balance));
    }
    
    public List<Account> getAllAccounts() {
        return accountrepository.findAll();
    }
    
    public Account getAccount(Long id){
        return accountrepository.getOne(id);
    }
    
    @Transactional
    public void transferMoney(Long id1, Long id2, double sum){
       Account from = accountrepository.getOne(id1);
       Account to = accountrepository.getOne(id2);
        
       from.setBalance(from.getBalance() - sum);
       to.setBalance(to.getBalance() + sum);
    }
    
}
