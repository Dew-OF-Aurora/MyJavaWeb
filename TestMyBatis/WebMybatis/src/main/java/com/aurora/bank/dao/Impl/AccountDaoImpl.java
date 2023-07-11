package com.aurora.bank.dao.Impl;

import com.aurora.bank.dao.AccountDao;
import com.aurora.bank.pojo.Account;
import com.aurora.bank.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectOneByName(String actName) {
        SqlSession db = SqlSessionUtil.openSession();
        Account account = db.selectOne("account.selectOneByName",actName);
        return account;
    }

    @Override
    public int updateBalanceByUser(Account account) {
        SqlSession db = SqlSessionUtil.openSession();
        int update = db.update("account.updateUserBalance",account);
        //dao不能处理事务, 需要在service层处理
        //db.commit();
        //db.close();
        return update;
    }
}
