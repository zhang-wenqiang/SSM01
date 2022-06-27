package com.zhang.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/*
 *   时间：2022/5/11
 *
 *
 */
@Controller

public class TestController {


    public String test(){
        return "123";
    }
}
