package com.hx5847.onlinebookstore.business.advertise.dao;

import com.hx5847.onlinebookstore.business.advertise.model.Advertisement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdvertisementMapper extends Mapper<Advertisement> {
    @Select("select adv_id as advId,url,pic_url as picUrl ,last_mdf_time as lastMdfTime, location from advertisement where adv_id=#{id}")
    public Advertisement getAdvertisementById(Integer id);


    @Select("select adv_id as advId,url,pic_url as picUrl ,last_mdf_time as lastMdfTime, location from advertisement")
    public List<Advertisement> getAll();


    @UpdateProvider(type = AdvertiseProvider.class,method = "updateAdvertisement")
    public int updateAdvertisement(Advertisement advertisement);

    @Select("select * from advertisement where location=#{location}")
    public List<Advertisement> getAdvertisementByLocation(String location);

    @Insert("insert into advertisement (url,pic_url,location) values (#{url},#{picUrl},#{location})")
    public void insertAdvertisement(Advertisement advertisement);

    @Delete("delete from advertisement where adv_id=#{id}")
    public void delAdvertise(Integer id);

    @Select("select count(*) from advertisement where location  = #{location}")
    Integer selectLocationCount(String location);

}
