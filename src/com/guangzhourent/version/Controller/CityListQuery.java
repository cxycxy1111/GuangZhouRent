package com.guangzhourent.version.Controller;

import com.guangzhourent.version.DAO.CityDAO;
import com.guangzhourent.version.Service.CityService;
import com.guangzhourent.version.Util.BaseServlet;
import com.guangzhourent.version.Util.QTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CityListQuery",urlPatterns = "/cityList")
public class CityListQuery extends BaseServlet {

    private CityService cityService = new CityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
        long p_id = QTool.reqParseToLong(request,"p_id");
        String s = cityService.queryList(p_id);
        response.getWriter().append(s);
    }
}
