package com.guangzhourent.version.Controller;

import com.guangzhourent.version.DAO.InstitutionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWord",urlPatterns = "/Test")
public class HelloWord extends HttpServlet {

    private InstitutionDAO institutionDAO = new InstitutionDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        response.getWriter().append(String.valueOf(institutionDAO.add(name)));
    }
}
