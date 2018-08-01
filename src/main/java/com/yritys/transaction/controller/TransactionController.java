/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.transaction.controller;

import com.yritys.transaction.owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tommib
 */
@Controller
public class TransactionController {

    @Autowired
    private OwnerService ownerservice;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("accounlist", ownerservice.getAllAccounts());
        return "transactions";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam String name, @RequestParam String surname, @RequestParam double balance) {
        ownerservice.createAccount(name, surname, balance);
        return "redirect:/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam Long id, @RequestParam double balance) {
        ownerservice.addAccount(id, balance);
        return "redirect:/";
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String Transaction(@RequestParam Long id1, @RequestParam Long id2, @RequestParam double sum) {
        ownerservice.transferMoney(id1, id2, sum);
        return "redirect:/";
    }
}
