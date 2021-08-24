package com.cj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Objects;

/**
 * @author CJ
 * @date 2021/7/14 9:38
 */
public class OnlineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (Objects.isNull(onlineCount)) {
            Integer count = 1;
            System.out.println("onlineCount为null，设置初始值1");
            context.setAttribute("onlineCount", count);
        } else {
            System.out.println("onlineCount+1");
            context.setAttribute("onlineCount", onlineCount + 1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (!Objects.isNull(onlineCount) && onlineCount > 0) {
            System.out.println("onlineCount-1");
            context.setAttribute("onlineCount", onlineCount - 1);
        }
    }
}
