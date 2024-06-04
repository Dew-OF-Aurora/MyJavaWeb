import com.powernode.reflect.SomeService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author:Aurora
 * @create: 2023-01-02 12:48
 * @Description:
 */
public class test1 {
    @Test
    public void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /*
            使用反射创建对象(引入资源)
         */
        SomeService someService = (SomeService) Class.forName("com.powernode.reflect.SomeService").newInstance();
        someService.doSome();
        /*
            使用反射获取某个声明方法(无需引入SomeService资源包), 4个要素:对象,方法,参数,返回
         */
        Class<?> aClass = Class.forName("com.powernode.reflect.SomeService");
        Object o = aClass.getDeclaredConstructor().newInstance();
        //需要获取方法名, 参数类型, 这里先写死
        Method declaredMethod = aClass.getDeclaredMethod("doSome", String.class, int.class);//
        //返回
        Object retValue = declaredMethod.invoke(o, "李四", 250);
        System.out.println(retValue);
    }
    @Test
    public void test02(){
        //获取set方法名
        String str = "age";//属性
        System.out.println("set"+str.toUpperCase().charAt(0)+str.substring(1));
    }
    @Test
    public void test03() throws ClassNotFoundException, NoSuchFieldException {
        //获取属性名的类型
        Class<?> aClass = Class.forName("com.powernode.reflect.User");
        Field field = aClass.getDeclaredField("age");
        //field.getType()返回int类型 => int.class
        System.out.println(field.getType());
    }
}
