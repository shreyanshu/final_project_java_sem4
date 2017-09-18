package com.shreyansh.servlets;

import com.shreyansh.domains.Laptop;
import com.shreyansh.services.LaptopService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
 * Created by User on 9/14/2017.
 */
@WebServlet(name = "DeleteLaptopServlet")
public class DeleteLaptopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(false);
        LaptopService laptopService=new LaptopService();
        if((session.getAttribute("role").equals("Admin")) && (session.getAttribute("user")!=null)){
            laptopService.delete(id);
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }

        else
        {
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);

        }

    }
}
