package com.hx5847.onlinebookstore.business.advertise.service;


import com.hx5847.onlinebookstore.business.advertise.dao.AdvertisementMapper;
import com.hx5847.onlinebookstore.business.advertise.model.Advertisement;
import com.hx5847.onlinebookstore.config.result.Result;
import com.hx5847.onlinebookstore.config.result.ResultCode;
import com.hx5847.onlinebookstore.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertiseService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    public List<Advertisement> getAdvertisements(){
        List<Advertisement> list = advertisementMapper.getAll();
        return list;
    }

    public Advertisement getAdvertise(Integer id) {
        return advertisementMapper.getAdvertisementById(id);
    }

    public String  insertAdvertise(Advertisement advertisement){
        if (advertisement.getLocation().equals("middle")||advertisement.getLocation().equals("tail")){
            List<Advertisement> list = advertisementMapper.getAdvertisementByLocation(advertisement.getLocation());
            if (list.size()>0){
                return "fail";
            } 
        }
        advertisementMapper.insertAdvertisement(advertisement);
        return "success";

    }

    public String  updateAdvertise(Advertisement advertisement)  {
        advertisementMapper.updateAdvertisement(advertisement);

//        if (advertisementMapper.getAdvertisementByLocation("middle").size()>1){
//            throw new UpdateException("update fail");
//        }
//        if (advertisementMapper.getAdvertisementByLocation("tail").size()>1){
//            throw new UpdateException("update fail");
//        }
//        if (advertisement.getLocation().equals("middle")||advertisement.getLocation().equals("tail")){
//            List<Advertisement> list = advertisementMapper.getAdvertisementByLocation(advertisement);
//            if (list.size()>0){
//                return "fail";
//            }
//        }
        return "success";
    }

    public String delAdvertise(Integer id) {

        advertisementMapper.delAdvertise(id);
        return "success";
    }

    public Result updateAndInsert(Advertisement advertisement) {
        if (advertisement.getAdvId() == null){
            String location = advertisement.getLocation();

            //判断新增位置是否有记录了
            Integer num = advertisementMapper.selectLocationCount(location);
            if(num >=1){
                return Result.result(ResultCode.FAIL, "该位置已经有广告了",null);
            }

            int flag = advertisementMapper.insert(advertisement);
            return Result.result(flag,"新增成功","新增失败");
        }else{
            int flag = advertisementMapper.updateAdvertisement(advertisement);
            return Result.result(flag,"修改成功","修改失败");
        }

    }
}
