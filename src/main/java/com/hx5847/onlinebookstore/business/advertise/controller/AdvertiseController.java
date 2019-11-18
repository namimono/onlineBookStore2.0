package com.hx5847.onlinebookstore.business.advertise.controller;

import com.hx5847.onlinebookstore.business.advertise.model.Advertisement;
import com.hx5847.onlinebookstore.business.advertise.service.AdvertiseService;
import com.hx5847.onlinebookstore.config.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdvertiseController {
    @Autowired
    AdvertiseService advertiseService;

    /**
     * 查询所有广告
     * @return
     */
    @GetMapping(value = "/getAllAdvertise")
    public List<Advertisement> getAllAdvertise(){
        List<Advertisement> list = advertiseService.getAdvertisements();
        return list;
    }

    /**
     * 根据id查询广告
     * @param id
     * @return
     */
    @GetMapping(value = "/advertise/{id}")
    public Advertisement getAdvertise(@PathVariable("id") Integer id){
        Advertisement advertise = advertiseService.getAdvertise(id);
        return advertise;
    }

    /**
     * 删除广告
     * @param id
     * @return
     */
    @DeleteMapping(value = "/advertise/{id}")
    public String delAdvertise(@PathVariable("id") Integer id){

        String msg=advertiseService.delAdvertise(id);
        return msg;
    }

    /**
     * 更新或新增广告
     * @param advertisement
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/updateAdvertise")
    public Result updateAdvertise(@RequestBody  Advertisement advertisement) throws IOException {
        return advertiseService.updateAndInsert(advertisement);
    }
//    @PostMapping(value = "/updateAdvertise")
//    public String  updateAdvertise(@RequestParam(value = "file",required = false) CommonsMultipartFile file, Advertisement advertisement) throws IOException {
//        String msg=null;
//        System.out.println(advertisement);
//        System.out.println(file);
////        判断文件是否为空，如果不为空保存文件，并更新对象中的PicUrl
//        if (!file.isEmpty()){
//            File file1 = new File("../webapps/onlineBookStore/static/"+file.getOriginalFilename());
//            file.transferTo(file1);
//            String absolutePath = file1.getAbsolutePath();
//            System.out.println(absolutePath);
//            System.out.println("fileName："+file.getOriginalFilename());
//            advertisement.setPicUrl("static/"+file.getOriginalFilename());
//        }
//        if(advertisement.getAdvId()==null){
//            String s = advertiseService.insertAdvertise(advertisement);
//            return s;
//        }
//        try {
//            msg=advertiseService.updateAdvertise(advertisement);
//        } catch (Exception e) {
//            msg="fail";
//        }
//        return msg;
//    }

}
