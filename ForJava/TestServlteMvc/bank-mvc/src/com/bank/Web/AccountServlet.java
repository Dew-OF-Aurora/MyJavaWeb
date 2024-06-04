package com.bank.Web;

import com.bank.Exceptions.AppException;
import com.bank.Exceptions.MoneyNotEnoughException;
import com.bank.Service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Controller, 控制器层
 */
@WebServlet({"/bank/submit","/bank/*"})
public class AccountServlet extends HttpServlet {

    private final AccountServiceImpl service = new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/bank/submit".equals(req.getServletPath())){
            doBankSubmit(req,resp);
        }
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doBankSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toName = req.getParameter("toname");
        String fromName = req.getParameter("fromname");
        double money = Double.parseDouble(req.getParameter("money"));
        try {
            service.transfer(fromName,toName,money);
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
        } catch (MoneyNotEnoughException | AppException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }
}
