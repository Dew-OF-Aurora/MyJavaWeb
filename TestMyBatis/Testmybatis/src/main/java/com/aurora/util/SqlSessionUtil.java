package com.aurora.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Mybatis工具类
 * @author 19626
 * @version 1.0
 *
 */
public class SqlSessionUtil {
    private SqlSessionUtil(){}
    private static SqlSessionFactory build;

    static {
        try {
            //返回一个inputStream
            build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSession(){
        SqlSession sqlSession = build.openSession();
        return sqlSession;
    }
}
