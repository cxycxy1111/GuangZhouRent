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

@WebServlet(name = "ApartmentList",urlPatterns = "/apartmentList")
public class ApartmentList extends BaseServlet {

    private ApartmentSourceService apartmentSourceService = new ApartmentSourceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
        long d_id = QTool.reqParseToLong(request,"d_id");
        int price_up = QTool.reqParseToInt(request,"price_up");
        int price_down = QTool.reqParseToInt(request,"price_down");
        int order = QTool.reqParseToInt(request,"order");
        int rent_way = QTool.reqParseToInt(request,"rent_way");
        int pay_way = QTool.reqParseToInt(request,"pay_way");
        int source_type = QTool.reqParseToInt(request,"source_type");
        int house_model = QTool.reqParseToInt(request,"house_model");
        String s = apartmentSourceService.queryApartmentSourceListHighClass(d_id,price_up,price_down,order,rent_way,pay_way,source_type,house_model);
        response.getWriter().append(s);
    }
}
