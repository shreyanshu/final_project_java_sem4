package com.shreyansh.servlets;

import com.shreyansh.domains.Laptop;
import com.shreyansh.domains.User;
import com.shreyansh.services.LaptopService;
import com.shreyansh.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 9/13/2017.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String role = request.getParameter("role");

        /*if(new UserService().verify(username, password, role)){

        }*/
        User user = new UserService().getUser(username, password, role);
        if(user != null)
        {
            HttpSession session = request.getSession(false);
            session.setAttribute("user", user);
            session.setAttribute("role", role);
            LaptopService laptopService = new LaptopService();
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }
        else{
            request.setAttribute("msg", "Invalid Credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
