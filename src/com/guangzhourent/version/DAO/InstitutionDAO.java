package com.guangzhourent.version.DAO;

import com.guangzhourent.version.Util.QTool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class InstitutionDAO extends DAO{

    public InstitutionDAO() {
        super();
    }

    public boolean add(String name) {
        Date create_date = new Date();
        String sql = "INSERT INTO institution (name,locked,del,create_time) VALUES('" + name +
                "',0,0,'" + super.sdf.format(create_date) + "')";
        boolean isAdded = false;
        try {
             isAdded = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public boolean isLocked(long id) {
        boolean isLocked = false;
        String sql = "SELECT locked FROM institution WHERE id=" + id ;
        ArrayList<HashMap<String,Object>> mapArrayList = new ArrayList<HashMap<String,Object>>();
        mapArrayList = helper.query(sql);
        if (mapArrayList.size()==1) {
            isLocked = QTool.toBool(mapArrayList,"locked");
        }
        return isLocked;
    }

    public boolean isDeleted(long id) {
        boolean isDel = false;
        String sql = "SELECT del FROM institution WHERE id = " + id;
        isDel = QTool.toBool(super.helper.query(sql),"del");
        return isDel;
    }

    public boolean isExist(long id) {
        String sql = "SELECT * FROM institution WHERE id = " + id;
        if (super.helper.query(sql).size() != 0) {
            return true;
        }
        return false;
    }

    public boolean lock(long id) {
        String sql = "UPDATE institution SET locked = 1 WHERE id = " + id;
        boolean isLocked = false;
        try {
            isLocked = helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLocked;
    }

    public boolean delete(long id) {
        String  sql = "UPDATE institution SET del = 1 WHERE id = " + id;
        boolean isDeleted = false;
        try {
            isDeleted = helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }



}
