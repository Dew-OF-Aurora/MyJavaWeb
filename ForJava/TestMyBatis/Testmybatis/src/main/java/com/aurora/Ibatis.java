package com.aurora;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Ibatis {
    public static int Batis2Jdbc(){
        SqlSession sqlSession = null;
        int count = -1;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            sqlSession = build.openSession();
            //下面放置业务代码
            count = sqlSession.insert("insertUser");
            //sqlSession.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if (sqlSession != null){sqlSession.rollback();}
            return count;
        }
        finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
        return count;
    }
}