package com.lyy.cart.servlet;

import com.lyy.cart.bean.Order;
import com.lyy.cart.bean.OrderItem;
import com.lyy.cart.bean.User;
import com.lyy.cart.dao.OrderDAO;
import com.lyy.cart.dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class OrderCreateServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User u = (User) request.getSession().getAttribute("user");
        if(null==u){
            response.sendRedirect("/login.jsp");
            return;
        }

        Order o = new Order();
        o.setUser(u);

        new OrderDAO().insert(o);

        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("orderItems");
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }

        ois.clear();

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");

    }
}