package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 动力节点
 * @version 1.0
 * @className AccountDaoImpl
 * @since 1.0
 **/
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select name, balance from account where name = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int update(Account act) {
        String sql = "update account set balance = ? where name = ?";
        int count = jdbcTemplate.update(sql, act.getBalance(), act.getName());
        return count;
    }

    @Override
    public int insert(Account act) {
        String sql = "insert into account values(?,?)";
        return jdbcTemplate.update(sql, act.getName(), act.getBalance());
    }

}