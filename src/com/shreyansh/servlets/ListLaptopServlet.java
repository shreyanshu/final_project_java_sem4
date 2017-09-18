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
 * Created by User on 9/14/2017.
 */

public class ListLaptopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LaptopService laptopService = new LaptopService();
        HttpSession session = request.getSession(false);

        if(session.getAttribute("user")!=null )
        {
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }

        else {
            request.setAttribute("msg", "Login required");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
