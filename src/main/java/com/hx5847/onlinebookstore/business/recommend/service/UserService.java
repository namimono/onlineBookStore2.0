package com.hx5847.onlinebookstore.business.recommend.service;

import com.hx5847.onlinebookstore.business.common.dao.BooksMapper;
import com.hx5847.onlinebookstore.business.common.dao.UserMapper;
import com.hx5847.onlinebookstore.business.common.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BooksMapper booksMapper;

    public Map<String,Object> getUserRecommend(Integer id){
        String name= userMapper.getUserNameById(id);
        System.out.println("----------------->"+name);
//        获取用户推荐列表时先判断用户是否存在
        if (name==null){
            return null;

        }
        List<String> userIntrestList = userMapper.getUserIntrestById(id);
        List<Book> recList = userMapper.getUserRecListById(id);
//        将推荐结果封装在map中返回
        HashMap<String ,Object> map=new HashMap<String, Object>();
        map.put("userName",name);
        map.put("intrest",userIntrestList);
        map.put("recList",recList);

        return map;
    }
    public String generateUserRecommendById(Integer id){
        List<String> userIntrestList = userMapper.getUserIntrestById(id);
        List<Integer> booksId = booksMapper.getBooksIdByTypes(userIntrestList);
//        生成推荐表之前先删除已有列表。
        userMapper.delRecommendById(id);
        for (Integer bookId:booksId){
            userMapper.insertUserRecommendById(id,bookId);
        }
        return "success";
    }
}
