import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("id","123321");
        //设置cookie保存在硬盘
        cookie.setMaxAge(60*60);
        //立即删除该cookie
        cookie.setMaxAge(0);
        //设置cookie存储在内存中,而不存在硬盘中
        cookie.setMaxAge(-1);

        //浏览器会发送cookie的uri
        cookie.setPath(req.getContextPath());

        //发送cookie
        resp.addCookie(cookie);

        //取得Cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie1 : cookies) {
            String name = cookie1.getName();
            String value = cookie.getValue();
        }
    }
}
