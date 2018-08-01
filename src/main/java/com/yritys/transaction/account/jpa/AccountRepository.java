/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.transaction.account.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tommib
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
