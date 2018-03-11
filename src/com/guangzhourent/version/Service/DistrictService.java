package com.guangzhourent.version.Service;

import com.guangzhourent.version.DAO.DistrictDAO;
import com.guangzhourent.version.Util.QTool;
import com.guangzhourent.version.Util.Ref;

import java.util.ArrayList;
import java.util.HashMap;

public class DistrictService extends DistrictDAO{

    private DistrictDAO districtDAO;

    public DistrictService() {
        super();
        districtDAO = new DistrictDAO();
    }

    public String query(long c_id){
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<>();
        mapArrayList = districtDAO.queryList(c_id);
        if (mapArrayList.size() == 0) {
            return Ref.EMPTY_RESULT;
        }else {
            return QTool.tfc(mapArrayList);
        }
    }

    public String fullQuery() {
        return null;
    }

}
