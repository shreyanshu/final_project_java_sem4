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
@WebServlet(name = "EditLaptopServlet")
public class EditLaptopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if((session.getAttribute("role").equals("Admin")) && (session.getAttribute("user")!=null)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Laptop laptop = new Laptop();
            LaptopService laptopService = new LaptopService();
            laptop.setBrand(request.getParameter("brand"));
            laptop.setModelNo(request.getParameter("modelNo"));
            laptop.setPrice(Integer.parseInt(request.getParameter("price")));
            laptop.setRating(Integer.parseInt(request.getParameter("rating")));
            laptopService.editLaptop(laptop, id);

            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }

        else{
            LaptopService laptopService = new LaptopService();
            List<Laptop> laptopList = laptopService.selectAll();
            request.setAttribute("laptopList", laptopList);
            request.getRequestDispatcher("listLaptop.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
