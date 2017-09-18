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
 * Created by User on 9/16/2017.
 */
@WebServlet(name = "EditLaptopFormServlet")
public class EditLaptopFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(false);
        LaptopService laptopService=new LaptopService();
        if((session.getAttribute("role").equals("Admin")) && (session.getAttribute("user")!=null)) {
            Laptop laptop = new LaptopService().getLaptop(id);
            request.setAttribute("laptop", laptop);
            request.setAttribute("id", id);
            request.getRequestDispatcher("editLaptopForm.jsp").forward(request, response);
        }
        else{
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }
    }
}
