package com.aurora.stuproject.utils;

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
    public static final ThreadLocal<SqlSession> local = new ThreadLocal<>();
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            sqlSession = build.openSession();
            local.set(sqlSession);
        }
        return local.get();
    }
    public static void commit(){
        if (local.get() != null) {
            local.get().commit();
        }
    }
    public static void close(){
        if (local.get() != null){
            local.remove();
        }
    }

}
