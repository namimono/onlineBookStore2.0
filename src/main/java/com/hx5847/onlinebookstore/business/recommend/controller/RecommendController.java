package com.hx5847.onlinebookstore.business.recommend.controller;

import com.hx5847.onlinebookstore.business.recommend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "*")
@Controller
public class RecommendController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserRecommend/{id}", method = RequestMethod.GET)
    public Map<String ,Object> getUserRecommend(@PathVariable("id") Integer id){
        Map<String, Object> userRecommend = userService.getUserRecommend(id);
        if (userRecommend==null){
            return null;
        }
        return userRecommend;
    }

    @ResponseBody
    @RequestMapping(value = "/generateRecommend/{id}", method = RequestMethod.GET)
    public String  generateRecommend(@PathVariable("id") Integer id){
        String msg = userService.generateUserRecommendById(id);
        return msg;
    }

}
