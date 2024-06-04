package com.aurora.bank;

import com.aurora.bank.mapper.AccountMapper;
import com.aurora.bank.util.SqlSessionUtil;
import org.junit.Test;

public class CrudTest {
    @Test
    public void TestParameter(){
        AccountMapper mapper = SqlSessionUtil.openSession().getMapper(AccountMapper.class);
    }
}
