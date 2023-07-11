package com.aurora.bank.util;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 动态生成Dao实现类
 * @author 19626
 */
public class GenerateDaoProxy {
    public static Object generate(SqlSession sqlSession, Class daoInterface){
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass(daoInterface.getName()+"Proxy");
        //制造接口
        CtClass ctInterface = pool.makeInterface(daoInterface.getName());
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口方法
        Method[] methods = daoInterface.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            try {
                //获取方法片段
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                // 需要方法的形式参数列表
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg" + i);
                    if(i != parameterTypes.length - 1){
                        methodCode.append(",");
                    }
                }
                methodCode.append(")");
                methodCode.append("{");
                // 需要方法体当中的代码
                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = com.aurora.bank.util.SqlSessionUtil.openSession();");
                // 需要知道是什么类型的sql语句
                // sql语句的id是框架使用者提供的，具有多变性。对于我框架的开发人员来说。我不知道。
                // 既然我框架开发者不知道sqlId，怎么办呢？mybatis框架的开发者于是就出台了一个规定：凡是使用GenerateDaoProxy机制的。
                // sqlId都不能随便写。namespace必须是dao接口的全限定名称。id必须是dao接口中方法名。
                String sqlId = daoInterface.getName() + "." + method.getName();
                //MappedStatement是存储sql语句和sqlid的pojo类
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                if (sqlCommandType == SqlCommandType.INSERT) {
                }
                if (sqlCommandType == SqlCommandType.DELETE) {
                }
                if (sqlCommandType == SqlCommandType.UPDATE) {
                    methodCode.append("return sqlSession.update(\""+sqlId+"\", arg0);");
                }
                if (sqlCommandType == SqlCommandType.SELECT) {
                    //使用全限定类名作为返回值
                    String returnType = method.getReturnType().getName();
                    methodCode.append("return ("+returnType+")sqlSession.selectOne(\""+sqlId+"\", arg0);");
                }
                methodCode.append("}");
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        });
        //创建对象
        Object obj = null;
        Class<?> aClass = null;
        try {
            aClass = ctClass.toClass();
            obj = aClass.newInstance();
        } catch (CannotCompileException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
