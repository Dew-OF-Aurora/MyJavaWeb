package com.aurora.bank.service.impl;

import com.aurora.bank.exception.NoMoneyException;
import com.aurora.bank.exception.TransferException;
import com.aurora.bank.mapper.AccountMapper;
import com.aurora.bank.pojo.Account;
import com.aurora.bank.service.AccountService;
import com.aurora.bank.util.SqlSessionUtil;

public class AccountServiceImpl implements AccountService {
    //自己构建的动态代理工具
    //AccountDao dao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(),AccountDao.class);
    //mybatis提供的代理机制
    //private AccountDao dao = SqlSessionUtil.openSession().getMapper(AccountDao.class);
    //更换为Mapper接口
    private AccountMapper mapper = SqlSessionUtil.openSession().getMapper(AccountMapper.class);
    @Override
    public void transfer(String from, String to, double MoneyCount) throws NoMoneyException, TransferException {
        //需要判断业务数据是否符合规范
        //判余额是否充足
        Account from_account = mapper.selectOneByName(from);
        Account to_account = mapper.selectOneByName(to);
        if (from_account.getBalance() < MoneyCount){
            throw new NoMoneyException("没钱啦");
        }
        from_account.setBalance(from_account.getBalance() - MoneyCount);
        to_account.setBalance(to_account.getBalance() + MoneyCount);
        if (mapper.updateBalanceByUser(from_account)+ mapper.updateBalanceByUser(to_account) != 2){
            throw new TransferException("数据库更新异常");
        }
        //使用ThreadLocal,拿到的是同一个SqlSession对象, 如果没有使用local实现, 使用util获取的是一个新的SqlSession对象
        SqlSessionUtil.commit();
        SqlSessionUtil.close();
    }
}
