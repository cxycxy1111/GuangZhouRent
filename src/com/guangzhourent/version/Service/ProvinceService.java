package com.guangzhourent.version.Service;

import com.guangzhourent.version.DAO.ProvinceDAO;
import com.guangzhourent.version.Util.QTool;
import com.guangzhourent.version.Util.Ref;

import java.util.ArrayList;
import java.util.HashMap;

public class ProvinceService extends Service{

    private ProvinceDAO provinceDAO;

    public ProvinceService() {
        super();
        provinceDAO = new ProvinceDAO();
    }

    public String queryProvince() {
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<>();
        mapArrayList = provinceDAO.queryList();
        if (mapArrayList.size() == 0) {
            return Ref.EMPTY_RESULT;
        }else {
            return QTool.tfc(mapArrayList);
        }
    }

}
