import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 业务类
 */
@WebServlet("/test/*")
public class SessionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if ((req.getContextPath() + "/test/a").equals(req.getRequestURI())) {
            doA(req, resp);
        }
        if ((req.getContextPath() + "/test/b").equals(req.getRequestURI())) {
            doB(req, resp);
        }
    }

    private void doB(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        //req.getScheme();
        //req.getRequestDispatcher("/123.jsp").forward(req, resp);
        try {
            throw new myexception("你出错啦");
        }
        catch (myexception e){
            e.printStackTrace();
            resp.getWriter().println(e.getMessage()+e.toString());

        }
    }

    private void doA(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("Aurora");
    }


}
