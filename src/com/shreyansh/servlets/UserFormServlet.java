package com.shreyansh.servlets;

import com.shreyansh.domains.Laptop;
import com.shreyansh.services.LaptopService;

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
@WebServlet(name = "UserFormServlet")
public class UserFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if((session.getAttribute("role").equals("Admin")) && (session.getAttribute("user")!=null)) {
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
        }

        else{
            LaptopService laptopService = new LaptopService();
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }
    }
}
