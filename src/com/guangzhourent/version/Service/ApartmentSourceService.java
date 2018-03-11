package com.guangzhourent.version.Service;

import com.guangzhourent.version.DAO.ApartmentSourceDAO;
import com.guangzhourent.version.Util.QTool;
import com.guangzhourent.version.Util.Ref;

import java.util.ArrayList;
import java.util.HashMap;

public class ApartmentSourceService extends Service{

    private ApartmentSourceDAO apartmentSourceDAO;

    public ApartmentSourceService() {
        super();
        apartmentSourceDAO = new ApartmentSourceDAO();
    }

    public String queryApartmentSourceListDefault(long id) {
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        result = apartmentSourceDAO.queryListDefault(id);
        if (result.size() == 0) {
            return Ref.EMPTY_RESULT;
        }else {
            return QTool.tfc(result);
        }
    }

    public String queryApartmentSourceListHighClass(long d_id,int price_up,int price_down,int order,int rent_way,int pay_way,int source_type,int house_model){
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        result = apartmentSourceDAO.queryList(d_id,price_up,price_down,order,rent_way,pay_way,source_type,house_model);
        if (result.size() == 0) {
            return Ref.EMPTY_RESULT;
        }else {
            return QTool.tfc(result);
        }
    }

    public String queryApartmentSourceDetail(long id) {
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        result = apartmentSourceDAO.queryDetail(id);
        if (result.size() == 0) {
            return Ref.EMPTY_RESULT;
        }else {
            return QTool.tfc(result);
        }
    }

}
