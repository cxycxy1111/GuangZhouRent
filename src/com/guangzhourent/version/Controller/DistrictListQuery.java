package com.guangzhourent.version.Controller;

import com.guangzhourent.version.Service.DistrictService;
import com.guangzhourent.version.Util.BaseServlet;
import com.guangzhourent.version.Util.QTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DistrictListQuery",urlPatterns = "/districtList")
public class DistrictListQuery extends BaseServlet {

    private DistrictService districtService = new DistrictService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
        long c_id = QTool.reqParseToLong(request,"c_id");
        String s = districtService.query(c_id);
        response.getWriter().append(s);
    }
}
