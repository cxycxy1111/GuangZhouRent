package com.guangzhourent.version.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class CityDAO extends DAO{

    public CityDAO() {
        super();
    }

    public ArrayList<HashMap<String,Object>> queryCityList(long p_id) {
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<HashMap<String,Object>>();
        String sql = "SELECT * FROM city WHERE province_id = " + p_id;
        mapArrayList =  super.helper.query(sql);
        return mapArrayList;
    }
}
