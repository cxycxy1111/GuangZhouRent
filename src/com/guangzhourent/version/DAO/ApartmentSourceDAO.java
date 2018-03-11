package com.guangzhourent.version.DAO;

import com.guangzhourent.version.Util.QTool;
import com.guangzhourent.version.Util.Ref;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ApartmentSourceDAO extends DAO{

    public ApartmentSourceDAO() {
        super();
    }

    public boolean add(long iid,long did,String title,int price,String longitude,String latitude,int toward,int room_no,
                       int rent_way,int pay_way,int source_type,int house_model,float total_size,float single_size,int total_floor,
                       int located_floor,long cuid,long contact_user_id,String create_date,String last_modify_time) {
        String sql = "INSERT INTO apartment_source (institution_id," +
                "district_id," +
                "title," +
                "price," +
                "longitude," +
                "latitude," +
                "toward," +
                "room_no," +
                "rent_way," +
                "pay_way," +
                "source_type," +
                "house_model," +
                "total_size," +
                "single_size," +
                "total_floor," +
                "located_floor," +
                "del," +
                "create_user_id," +
                "contact_user_id," +
                "create_time," +
                "last_modify_time) VALUES("
                + iid + ","+ did + ",'" + title + "'," + price + ",'" + longitude  + "','" + latitude + "',"+ toward + "," + room_no + "," +
                rent_way + "," + pay_way + "," + source_type + "," + house_model + "," + total_size + "," + single_size + "," + total_floor + "," +
                located_floor + ",0," + cuid + "," + contact_user_id + ",'" + create_date + "','" + last_modify_time + "')";

        boolean isAdded = false;
        try {
            isAdded =  super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public boolean delete(long id) {
        String sql = "UPDATE apartment_source SET del = 1 WHERE id=" + id;
        boolean isDeleted = false;
        try {
            isDeleted =  super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }


    public boolean updateString(String key,String value) {
        String sql = "UPDATE apartment_source SET (" + key + ") VALUES ('" + value + "')";
        boolean isUpdated = false;
        try {
            isUpdated =  super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public boolean updateNumber(String key,long value) {
        String sql = "UPDATE apartment_source SET (" + key + ") VALUES (" + value + ")";
        boolean isUpdated = false;
        try {
            isUpdated =  super.helper.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public ArrayList<HashMap<String,Object>> queryDetail(long id) {
        String sql = "SELECT ase.*,CONCAT('" + Ref.LOCAL_HOST + "',asconfig.cover_img) as cover_img," +
                "CONCAT('" + Ref.LOCAL_HOST + "',asconfig.img_1) as img_1," +
                "CONCAT('" + Ref.LOCAL_HOST + "',asconfig.img_2) as img_2," +
                "CONCAT('" + Ref.LOCAL_HOST + "',asconfig.img_3) as img_3," +
                "CONCAT('" + Ref.LOCAL_HOST + "',asconfig.img_4) as img_4," +
                "CONCAT('" + Ref.LOCAL_HOST + "',asconfig.img_5) as img_5," +
                "has_wifi," +
                "has_water_heater," +
                "has_washer," +
                "has_refrigerator," +
                "has_sofa,has_tv," +
                "has_microwave_owen," +
                "has_gas_stove," +
                "has_cooker_hood," +
                "has_induction_cooker," +
                "metro," +
                "bus," +
                "mall," +
                "restaurant," +
                "iu.phone," +
                "iu.name FROM apartment_source ase " +
                "LEFT JOIN apartment_source_config asconfig ON ase.id=asconfig.apartment_source_id " +
                "LEFT JOIN institution_user iu ON ase.contact_user_id=iu.id " +
                "WHERE ase.del=0 AND ase.id = " + id;
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        result = super.helper.query(sql);
        return result;
    }

    /**
     * 高级查询
     * @param d_id
     * @param price_up
     * @param price_down
     * @param order
     * @param rent_way
     * @param pay_way
     * @param source_type
     * @param house_model
     * @return
     */
    public ArrayList<HashMap<String,Object>> queryList(long d_id,int price_up,int price_down,int order,int rent_way,int pay_way,int source_type,int house_model) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT CONCAT('" + Ref.LOCAL_HOST + "',asconfig.cover_img) as cover_img," +
                "ase.title,ase.room_no,ase.toward,ase.single_size,ase.longitude," +
                "ase.latitude,ase.rent_way,ase.last_modify_time,ase.price FROM apartment_source ase " +
                "LEFT JOIN apartment_source_config asconfig ON ase.id=asconfig.apartment_source_id " +
                "WHERE district_id =").append(d_id);
        if (price_down != -1 && price_up != -1) {
            builder.append(" AND ase.price IN (").append(price_down).append(",").append(price_up).append(")");
        }
        if (rent_way != -1) {
            builder.append(" AND ase.rent_way=").append(rent_way);
        }
        if (pay_way != -1) {
            builder.append(" AND ase.pay_way=").append(pay_way);
        }
        if (source_type != -1){
            builder.append(" AND ase.source_type=").append(source_type);
        }
        if (house_model != -1) {
            builder.append(" AND ase.house_model=").append(house_model);
        }
        if (order !=-1) {
            if (order == 1) {
                builder.append(" ORDER BY ase.last_modify_time");
            }else if (order == 2) {
                builder.append(" ORDER BY ase.last_modify_time DESC");
            }else if (order == 3) {
                builder.append(" ORDER BY ase.price");
            }else if (order == 4) {
                builder.append(" ORDER BY ase.price DESC");
            }else if (order == 5) {
                builder.append(" ORDER BY ase.total_size");
            }else {
                builder.append(" ORDER BY ase.total_size DESC");
            }
        }
        String sql = builder.toString();
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        result = super.helper.query(sql);
        return result;
    }

    /**
     * 默认查询
     * @param d_id
     * @return
     */
    public ArrayList<HashMap<String,Object>> queryListDefault(long d_id) {
        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<>();
        String sql = "SELECT CONCAT('" + Ref.LOCAL_HOST + "',asconfig.cover_img) as cover_img,ase.title,ase.room_no,ase.toward,ase.single_size,ase.longitude,ase.latitude,ase.rent_way,ase.last_modify_time,ase.price FROM apartment_source ase " +
                "LEFT JOIN apartment_source_config asconfig ON ase.id = asconfig.apartment_source_id " +
                "WHERE ase.del = 0 AND ase.district_id = " + d_id;
        arrayList = helper.query(sql);
        return arrayList;
    }

}
