package com.bank.Service.impl;

import com.bank.Bean.Account;
import com.bank.Dao.AccountDao;
import com.bank.Dao.impl.AccountDaoImpl;
import com.bank.Exceptions.AppException;
import com.bank.Exceptions.MoneyNotEnoughException;
import com.bank.Util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 业务
 */
public class AccountServiceImpl implements com.bank.Service.AccountService {

    private final AccountDao accountDao = new AccountDaoImpl();

    /**
     * 转账业务
     *
     * @param formName
     * @param toName
     * @param money
     * @throws MoneyNotEnoughException
     * @throws AppException
     */
    @Override
    public void transfer(String formName, String toName, double money) throws MoneyNotEnoughException, AppException {
        // service层控制事务
        try (Connection connection = DBUtil.getCon()) {
            connection.setAutoCommit(false);
            // 查询余额是否充足
            Account fromAct = accountDao.selectByname(formName);

            if (fromAct.getBalance() < money) {
                throw new MoneyNotEnoughException("对不起，余额不足");
            }
            // 程序到这里说明余额充足
            Account toAct = accountDao.selectByname(toName);

            // 修改余额
            fromAct.setBalance(fromAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);

            int count = accountDao.update(fromAct);
            count += accountDao.update(toAct);
            if (count != 2) {
                throw new AppException("账户转账异常");
            }

            //String a = null;
            //a.toString();
            //模拟异常需要捕捉异常

            connection.commit();

        } catch (SQLException | NullPointerException e) {
            throw new AppException("账户转账异常");
        }

    }
}
