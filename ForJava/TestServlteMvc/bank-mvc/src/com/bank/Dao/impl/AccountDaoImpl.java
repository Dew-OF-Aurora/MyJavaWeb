package com.bank.Dao.impl;

import com.bank.Bean.Account;
import com.bank.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据层
 */
public class AccountDaoImpl implements com.bank.Dao.AccountDao {
    /**
     * 插入
     *
     * @param account
     * @return
     */
    @Override
    public int insert(Account account) {
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getCon();
            String sql = "INSERT INTO account (account.`name`,account.balance)VALUES(?,?)"; //这里要不要写单引号?
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getName());
            ps.setDouble(2, account.getBalance());
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.close(null,ps,null);
        }
        return count;
    }

    /**
     * 删除用户
     *
     * @param name
     * @return
     */
    @Override
    public int deleteByName(String name) {
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getCon();
            String sql = "DELETE FROM account WHERE account.`name` = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.close(null,ps,null);
        }
        return count;
    }

    /**
     * 更新
     *
     * @param account
     * @return
     */
    @Override
    public int update(Account account) {
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getCon();
            String sql = "UPDATE account SET account.`name` = ?,account.balance = ? WHERE account.`name` = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getName());
            ps.setString(3, account.getName());
            ps.setDouble(2, account.getBalance());
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.close(null,ps,null);
        }
        return count;
    }

    /**
     * 查询
     *
     * @param name
     * @return
     */
    @Override
    public Account selectByname(String name) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = null;
        try {
            connection = DBUtil.getCon();

            //System.out.println(connection);

            String sql = "select * from account where name = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account(rs.getLong("id"), name, rs.getDouble("balance"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.close(null,ps,rs);
        }
        return account;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Account> selectAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtil.getCon();
            String sql = "select * from account";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String actno = rs.getString("name");
                Double balance = rs.getDouble("balance");
                Account account = new Account(id, actno, balance);
                list.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(null,ps,rs);
        }
        return list;
    }
}
