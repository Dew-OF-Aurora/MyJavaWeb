package com.bank.Dao;

import com.bank.Bean.Account;

import java.util.List;

public interface AccountDao {
    int insert(Account account);

    int deleteByName(String name);

    int update(Account account);

    Account selectByname(String name);

    List<Account> selectAll();
}
