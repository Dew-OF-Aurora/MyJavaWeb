import com.aurora.pojo.User;
import com.aurora.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author:Aurora
 * @create: 2023-02-04 23:39
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_application_context.xml","classpath:spring_application_service.xml"})
public class FirstTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetPage(){
        List<User> list = userService.selectUserPage(null, null, 0);
        list.forEach(user -> {
            System.out.println(user);
        });
    }
    @Test
    public void testDel(){
        Integer integer = userService.deleteUserById("15968954638794962");
        System.out.println(integer);
    }
    @Test
    public void testGetRowCount(){
        Integer num = userService.getRowCount(null, "男");
        System.out.println(num);
    }
    @Test
    public void testNewUser(){
        Integer num = userService.createUser(new User("123456789123456789", "身份证", "337845818", "西哥", "男", "18", "军人"));
        System.out.println(num);
    }
}
