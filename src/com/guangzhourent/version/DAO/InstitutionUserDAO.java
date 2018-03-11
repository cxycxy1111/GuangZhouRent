package com.guangzhourent.version.DAO;

import com.guangzhourent.version.Util.QTool;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class InstitutionUserDAO extends DAO{

    public InstitutionUserDAO() {
        super();
    }

    public boolean add(long institution_id,String name,String phone,String user_name,String password) {
        boolean isAdded = false;
        Date create_date = new Date();
        String sql = "INSERT INTO institution_user (institution_id,name,phone,user_name,password,locked,del,create_time) VALUE("
                 + institution_id +
                ",'" + name +
                "','" + phone +
                "','’" + user_name +
                "','" + QTool.MD5(password) +
                "'," + 0 +
                "," + 0 +
                ",'" + super.sdf.format(create_date) +
                "')";

        return isAdded;
    }

    public boolean isLocked(long id) {
        boolean isLocked = false;
        String sql = "SELECT is_locked FROM institution_user WHERE id = " + id;
        isLocked = QTool.toBool(super.helper.query(sql),"locked");
        return isLocked;
    }

    public boolean isDeleted(long id) {
        boolean isDeleted = false;
        String sql = "SELECT is_locked FROM institution_user WHERE id = " + id;;
        isDeleted = QTool.toBool(super.helper.query(sql),"del");
        return isDeleted;
    }

    public boolean lock(long id) {
        boolean isLocked = false;
        String sql = "UPDATE institution_user SET locked = 1 WHERE id = " + id;
        try {
            isLocked = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLocked;
    }

    public boolean delete(long id) {
        boolean isDeleted = false;
        String sql = "UPDATE institution_user SET del = 1 WHERE id = " + id;
        try {
            isDeleted = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public boolean loginCheck(String user_name,String password) {
        String sql = "SELECT password FROM institution_user WHERE user_name='" + user_name + "'";
        String correctPassword = String.valueOf(super.helper.query(sql).get(0).get("password"));
        if (Objects.equals(password, correctPassword)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isUserNameExist(String user_name) {
        String sql = "SELECT * FROM institution_user WHERE user_name = '" + "'";
        if (super.helper.query(sql).size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
