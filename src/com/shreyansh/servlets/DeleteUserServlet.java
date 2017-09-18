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
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserService userService = new UserService();
        if((session.getAttribute("role").equals("Admin")) && (session.getAttribute("user")!=null)) {

            int id = Integer.parseInt(request.getParameter("id"));
            userService.deleteUser(id);
            List<User> userList = userService.selectAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        }
        else{

            List<User> userList = userService.selectAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("listUser.jsp").forward(request, response);

        }
    }
}
