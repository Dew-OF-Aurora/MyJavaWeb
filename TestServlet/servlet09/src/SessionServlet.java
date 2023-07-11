import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 业务类
 */
@WebServlet("/test/*")
public class SessionServlet extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //jsp编译的java代码会生成一个session, 所以需要判断
        HttpSession session = req.getSession(false);

        //User user =  (User) session.getAttribute("user");

        if (session != null && session.getAttribute("user") != null) {
            if ((req.getContextPath() + "/test/a").equals(req.getRequestURI())) {
                doA(req, resp);
            }
            if ((req.getContextPath() + "/test/b").equals(req.getRequestURI())){
                doB(req,resp);
            }
        }
        else {
            resp.sendRedirect(req.getContextPath());
        }
    }

    private void doB(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/123.jsp").forward(req,resp);
    }

    private void doA(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("Aurora");
    }



}
