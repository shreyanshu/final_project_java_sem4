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
import java.util.List;

/**
 * Created by User on 9/15/2017.
 */
@WebServlet(name = "AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if((session.getAttribute("role").equals("Admin")) && (session.getAttribute("user")!=null)) {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            user.setCity(request.getParameter("city"));
            user.setAddress(request.getParameter("address"));
            new UserService().addUser(user);

            List<User> userList = new UserService().selectAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        }

        else{
            List<User> userList = new UserService().selectAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
