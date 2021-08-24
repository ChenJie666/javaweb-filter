package com.cj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author CJ
 * @date 2021/7/14 10:13
 */
public class OnlineCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        System.out.println("sessionId: " + req.getSession().getId());

        ServletContext context = this.getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");

        PrintWriter out = resp.getWriter();
        out.write("当前在线人数: " + onlineCount);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
