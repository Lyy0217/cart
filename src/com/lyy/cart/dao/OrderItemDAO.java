package com.lyy.cart.dao;

import com.lyy.cart.bean.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderItemDAO {

    public static void main(String[] args) {

    }

    public void insert(OrderItem oi) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "203991");

            String sql = "insert into orderitem values(null,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, oi.getProduct().getId());
            ps.setInt(2, oi.getNum());
            ps.setInt(3, oi.getOrder().getId());

            ps.execute();

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}