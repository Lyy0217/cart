package com.lyy.cart.servlet;

import com.lyy.cart.bean.OrderItem;
import com.lyy.cart.bean.Product;
import com.lyy.cart.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemAddServle extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        Product p = new ProductDAO().getProduct(pid);

        OrderItem oi = new OrderItem();

        oi.setNum(num);
        oi.setProduct(p);

        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("orderItems");

        if (null == ois) {
            ois = new ArrayList<OrderItem>();
            request.getSession().setAttribute("orderItems", ois);
        }

        boolean found = false;
        for (OrderItem orderItem : ois) {
            if (orderItem.getProduct().getId() == oi.getProduct().getId()) {
                orderItem.setNum(orderItem.getNum() + oi.getNum());
                found = true;
                break;
            }
        }

        if (!found)
            ois.add(oi);

        response.sendRedirect("/web/listOrderItem");

    }
}