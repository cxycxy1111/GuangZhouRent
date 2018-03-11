package com.guangzhourent.version.Controller;

import com.guangzhourent.version.Service.ApartmentSourceService;
import com.guangzhourent.version.Util.BaseServlet;
import com.guangzhourent.version.Util.QTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApartmentDetail",urlPatterns = "/apartmentDetail")
public class ApartmentDetail extends BaseServlet {

    private ApartmentSourceService apartmentSourceService = new ApartmentSourceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
        long id = QTool.reqParseToInt(request,"id");
        String s = apartmentSourceService.queryApartmentSourceDetail(id);
        response.getWriter().append(s);
    }
}
