package com.hx5847.onlinebookstore.business.rank.controller;

import com.hx5847.onlinebookstore.business.common.model.Book;
import com.hx5847.onlinebookstore.business.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@Controller
public class RankController {

    @Autowired
    private RankService rankService;
//        如果前端传来的是一个对象（JSON对象），需要用RequestBody接收。
//        传来的是序列化值（表单提交结果，用RequestParam，或者直接用对应字段的对象即可）

//    使用@RequestBody Map<String, Object> map，会将数组类型的值转为list集合
//    {types=[军事, 都市], conditon=click}
    @ResponseBody
    @RequestMapping(value = "/getRank", method = RequestMethod.POST)
    public List<Book> getRank(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        ArrayList<String> list= (ArrayList) map.get("types");
        String[] types = list.toArray(new String[list.size()]);
        String condition= (String) map.get("condition");
        System.out.println(map.get("condition"));
        List<Book> rankBooks = rankService.getRankBooks(types, condition);

        return rankBooks;
    }

}
