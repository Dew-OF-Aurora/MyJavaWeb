import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/*"})
public class Myfilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String path = req.getServletPath();

        if ("/index.jsp".equals(path) || "/login".equals(path) ||
                session != null && session.getAttribute("user") != null) {
            chain.doFilter(request,response);
        }
        else {
            resp.sendRedirect(req.getContextPath());
        }

    }
}
