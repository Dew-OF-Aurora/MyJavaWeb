package com.aurora.bank.web;

import com.aurora.bank.exception.NoMoneyException;
import com.aurora.bank.exception.TransferException;
import com.aurora.bank.service.AccountService;
import com.aurora.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/transfer",name = "transference")
public class AccountServlet extends HttpServlet {
    private AccountService service = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String from = req.getParameter("from").trim();
        String to = req.getParameter("to").trim();
        double count = Double.parseDouble(req.getParameter("count").trim());
        //调用service层
        try {
            service.transfer(from,to,count);
            resp.sendRedirect("success.jsp");
        } catch (NoMoneyException | TransferException e) {
            throw new RuntimeException(e);
        }
        //调用视图层展示
    }
}
