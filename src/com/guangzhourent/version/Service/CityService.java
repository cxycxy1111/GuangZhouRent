package com.guangzhourent.version.Service;

import com.guangzhourent.version.DAO.CityDAO;
import com.guangzhourent.version.Util.QTool;
import com.guangzhourent.version.Util.Ref;

import java.util.ArrayList;
import java.util.HashMap;

public class CityService extends CityDAO{

    private CityDAO cityDAO;

    public CityService() {
        super();
        cityDAO = new CityDAO();
    }


    public String queryList(long province_id) {
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<>();
        mapArrayList = cityDAO.queryCityList(province_id);
        if (mapArrayList.size() == 0) {
            return Ref.EMPTY_RESULT;
        }else {
            return QTool.tfc(mapArrayList);
        }
    }



}
