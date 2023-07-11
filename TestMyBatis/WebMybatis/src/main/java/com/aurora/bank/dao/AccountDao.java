package com.aurora.bank.dao;

import com.aurora.bank.pojo.Account;

public interface AccountDao {

    /**
     *
     * @param actName
     * @return Account
     */
    Account selectOneByName(String actName);

    /**
     * @param account
     * @return int
     */
    int updateBalanceByUser(Account account);
}
