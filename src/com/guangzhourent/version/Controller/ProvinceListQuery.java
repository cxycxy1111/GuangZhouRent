package com.guangzhourent.version.Controller;

import com.guangzhourent.version.Service.ProvinceService;
import com.guangzhourent.version.Util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProvinceListQuery",urlPatterns = "/provinceList")
public class ProvinceListQuery extends BaseServlet {

    private ProvinceService provinceService = new ProvinceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
        String s = provinceService.queryProvince();
        response.getWriter().append(s);
    }
}
