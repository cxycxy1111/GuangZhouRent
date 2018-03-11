package com.guangzhourent.version.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class DistrictDAO extends DAO{

    public DistrictDAO() {
        super();
    }

    public ArrayList<HashMap<String,Object>> queryList(long c_id) {
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<HashMap<String,Object>>();
        String sql = "SELECT * FROM district WHERE city_id=" + c_id;
        mapArrayList =  super.helper.query(sql);
        return mapArrayList;
    }

    public ArrayList<HashMap<String,Object>> query() {
        ArrayList<HashMap<String,Object>> mapArrayList= new ArrayList<HashMap<String,Object>>();
        return  mapArrayList;
    }
}
