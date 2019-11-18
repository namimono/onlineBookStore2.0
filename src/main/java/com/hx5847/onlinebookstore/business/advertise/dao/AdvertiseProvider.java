package com.hx5847.onlinebookstore.business.advertise.dao;

import com.hx5847.onlinebookstore.business.advertise.model.Advertisement;
import org.apache.ibatis.jdbc.SQL;

public class AdvertiseProvider {

    public String updateAdvertisement(final Advertisement advertisement){

        return new SQL(){{
            UPDATE("advertisement");
            if (advertisement.getLocation()!=null){
                SET("location=#{location}");
            }
            if(advertisement.getPicUrl()!=null){
                SET("pic_url=#{picUrl}");
            }
            if(advertisement.getUrl()!=null){
                SET("url=#{url}");
            }
            WHERE("adv_id=#{advId}");
        }}.toString();
    }
}
