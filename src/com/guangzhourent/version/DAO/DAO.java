package com.guangzhourent.version.DAO;

import com.guangzhourent.version.Util.SQLHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DAO {

    protected SQLHelper helper;
    protected SimpleDateFormat sdf;

    public DAO() {
        helper = new SQLHelper();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}
