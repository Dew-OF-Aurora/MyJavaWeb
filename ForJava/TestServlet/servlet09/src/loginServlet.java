import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login","/exit"})
public class loginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        if("/login".equals(servletPath)){
            doLogin(req,resp);
        }
        if ("/exit".equals(servletPath)){
            doExit(req,resp);
        }
    }

    private void doExit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null){
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
        }

    }

    protected void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("username").equals("")) {
            HttpSession session = req.getSession();
            session.setAttribute("user", new User(req.getParameter("username"), req.getParameter("passwd")));
            //进入主页
            req.getRequestDispatcher("/test/b").forward(req,resp);
        }
        else {
            resp.setContentType("text/html");
            resp.getWriter().println("未获取请求参数");
        }
    }
}
