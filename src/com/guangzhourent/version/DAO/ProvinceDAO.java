package com.guangzhourent.version.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class ProvinceDAO extends DAO{

    public ProvinceDAO() {
        super();
    }


    public ArrayList<HashMap<String,Object>> queryList() {
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<>();
        String sql = "SELECT * FROM province";
        mapArrayList = super.helper.query(sql);
        return mapArrayList;
    }



}
