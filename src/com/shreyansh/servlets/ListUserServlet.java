package com.shreyansh.servlets;

import com.shreyansh.domains.User;
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
@WebServlet(name = "ListUserServlet")
public class ListUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession(false);

        if(session.getAttribute("user")!=null )
        {
            List<User> userList = userService.selectAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        }

        else {
            request.setAttribute("msg", "Login required");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
