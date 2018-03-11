package com.guangzhourent.version.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ApartmentSourceConfigDAO extends DAO{

    public ApartmentSourceConfigDAO() {
        super();
    }

    public boolean removeImage(long as_id,int position) {
        String sql = "UPDATE apartment_source_config asconfig SET img_" + position + " ='' WHERE apartment_source_id=" + as_id;
        boolean isRemoved = false;
        try {
            isRemoved = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemoved;
    }

    public boolean addImage(long as_id,int position,String name) {
        String sql = "UPDATE apartment_source_config asconfig SET img_" + position + " ='" + name + "' WHERE apartment_source_id=" + as_id;
        boolean isAdded = false;
        try {
            isAdded = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public boolean updateImage(long as_id,int position,String name) {
        String sql = "UPDATE apartment_source_config asconfig SET img_" + position + " ='" + name + "' WHERE apartment_source_id=" + as_id;
        boolean isUpdated = false;
        try {
            isUpdated = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public ArrayList<HashMap<String,Object>> query(long as_id) {
        String sql = "SELECT * FROM apartment_source_config WHERE apartment_source_id=" + as_id;
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        result = super.helper.query(sql);
        return result;
    }

    public boolean insert(long ac_id,String cover_img,String img_1,String img_2,String img_3,String img_4,String img_5,
                          int has_wifi,int has_water_heater,int has_washer,int has_refrigerator,int has_sofa,int has_tv,
                          int has_microwave_owen,int has_gas_stove,int has_cooker_hood,int has_induction_cooker,String metro,
                          String bus,String mall,String restaurant) {
        String sql = "INSERT INTO apartment_source_config (apartment_source_id," +
                "cover_img," +
                "img_1," +
                "img_2," +
                "img_3," +
                "img_4," +
                "img_5," +
                "has_wifi," +
                "has_water_heater," +
                "has_washer," +
                "has_refrigerator," +
                "has_sofa," +
                "has_tv," +
                "has_microwave_owen," +
                "has_gas_stove," +
                "has_cooker_hood," +
                "has_induction_cooker," +
                "metro," +
                "bus," +
                "mall," +
                "restaurant) VALUES (" + ac_id + ",'cover_img','img_1'," +
                "'img_2','img_3','img_4','img_5'" + "," + has_wifi + "," + has_water_heater + "," + has_washer + "," + has_refrigerator + "," +
                has_sofa + "," + has_tv + "," + has_microwave_owen + "," + has_gas_stove + "," + has_cooker_hood + "," +
                has_induction_cooker + ",'" + metro + "','" + bus + "','" + mall + "','" + restaurant + "')";
        boolean isInserted = false;
        try {
            isInserted = super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInserted;
    }

}
