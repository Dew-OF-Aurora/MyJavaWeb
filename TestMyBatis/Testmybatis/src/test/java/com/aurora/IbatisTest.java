package com.aurora;

import com.aurora.pojo.User;
import com.aurora.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IbatisTest {
    @Test
    public void testJDBC() throws Exception {
        //Assert.assertEquals(1,Ibatis.Batis2Jdbc());
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSession openSession = builder.build(Resources.getResourceAsStream("mybatis-config.xml"), "development").openSession();
    }
    //@Test
    public void testUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.insert("insertUser");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testCRUD(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","act006");
        map.put("balance",70000);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //sqlSession.delete("deleteUser",map);
        //sqlSession.insert("insertUser",map);
        //sqlSession.update("updateUser",map);
        User user = sqlSession.selectOne("selectByName", "act006");
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<User> list = sqlSession.selectList("selectUser");
        list.forEach(user -> System.out.println(user.toString()));
        sqlSession.close();
    }
}
