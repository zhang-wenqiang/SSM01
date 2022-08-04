package com.zhang.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 *   时间：2022/5/11
 *
 *
 */
@Controller

public class TestController {


    public String test(){
        return "1234";
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(format);

        Date parse2 = new SimpleDateFormat("yyyy-MM-dd").parse(format);
        Date parse3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-05");

        System.out.println(date.compareTo(parse2));

        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format+" 00:00:00");
        System.out.println(parse);
        Date parse1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-05-05 23:59:59");
        System.out.println(parse1);

        System.out.println(parse1.compareTo(parse));
        Date time1 = new SimpleDateFormat("HH:mm:ss").parse("10:10:10");
        Date time2 = new SimpleDateFormat("HH:mm:ss").parse("23:59:59");



        Date time3 = new SimpleDateFormat("HH:mm:ss").parse("20:20:20");
        Date time4 = new SimpleDateFormat("HH:mm:ss").parse("01:00:00");
        System.out.println(time2.before(time4));


        Date time5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-05-05"+" "+"20:20:20");
        Date time6 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-05");
        Date time7 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-05");


    }


    public static void test1(){
        Stream<String> aaa = Stream.of("1","2","");
        aaa.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return StringUtils.isEmpty(s);
            }
        }).collect(Collectors.toList());



    }
}
