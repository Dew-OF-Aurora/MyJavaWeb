package com.aurora.bank.mapper;

import com.aurora.bank.pojo.Account;

public interface AccountMapper {
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
