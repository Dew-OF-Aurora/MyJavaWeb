package com.aurora.bank;

import com.aurora.bank.dao.AccountDao;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AccountDaoImplTest {
    @Test
    public void JavassistInMybatisTest() throws CannotCompileException, InstantiationException, IllegalAccessException {
        //类池
        ClassPool pool = ClassPool.getDefault();
        //类名
        CtClass ctClass = pool.makeClass("com.aurora.bank.dao.AccountDaoImpl");
        //接口
        CtClass ctInterface = pool.makeInterface("com.aurora.bank.dao.AccountDao");
        //实现接口
        ctClass.addInterface(ctInterface);
        //获取接口方法
        Method[] methods = AccountDao.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            //int updateBalanceByUser(Account account);方法拼串
            StringBuilder methodCode = new StringBuilder();
            methodCode.append("public ");
            methodCode.append(method.getReturnType().getName());
            methodCode.append(" ");
            methodCode.append(method.getName());
            methodCode.append("(");
            //遍历参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                methodCode.append(parameterType.getName());
                methodCode.append(" ");
                methodCode.append("arg"+i);
                if (i != parameterTypes.length -1 ){
                    methodCode.append(",");
                }
            }
            methodCode.append("){System.out.println(\"123\");");
            String simpleName = method.getReturnType().getSimpleName();
            if ("void".equals(simpleName)){

            }
            else if ("String".equals(simpleName)){
                methodCode.append("return \"hello\";");
            }
            else if ("int".equals(simpleName)){
                methodCode.append("return 1;");
            }
            else if ("Account".equals(simpleName)){
                methodCode.append("return null;");
            }
            methodCode.append("}");
            try {
                System.out.println(methodCode.toString());
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //构造类并执行方法
        Class<?> aClass = ctClass.toClass();
        AccountDao accountDao = (AccountDao) aClass.newInstance();
        accountDao.selectOneByName("123");
        accountDao.updateBalanceByUser(null);
    }
}
