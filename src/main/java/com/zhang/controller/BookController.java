package com.zhang.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.entity.Book;
import com.zhang.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.zip.GZIPOutputStream;

/*
 *   时间：2021/12/9
 *
 *
 */
@Controller
@RequestMapping("/Book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部书籍，然后页面显示
    @RequestMapping("/allBook")
    public String listBooks(Model model){
        List<Book> books = bookService.queryBooks();
        model.addAttribute("list",books);


        /*Base64是网络上最常见的用于传输8Bit字节代码的编码方式之一，
        在发送电子邮件时，服务器认证的用户名和密码需要用Base64编码，
        附件也需要用Base64编码。*/
        /*Base64要求把每三个8Bit的字节转换为四个6Bit的字节（3*8 = 4*6 = 24），
        然后把6Bit再添两位高位0，组成四个8Bit的字节，也就是说，转换后的字符串理论上将要比原来的长1/3。*/
        //String a = "hello";
        //new BASE64Encoder().encode(a.getBytes());



        //获取配置文件中键值对
        //Properties properties = new Properties();
        //ResourceBundle bundle = ResourceBundle.getBundle("");


        return "allBook";
    }


    //去添加图书
    @RequestMapping("/toAddBook")
    public String toAddBook(){

        return "addBook";
    }
    //添加图书
    @RequestMapping("/addBook")
    public String addBook(Book book){


        bookService.addBook(book);
        return "redirect:/Book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Book book = bookService.queryBook(id);
        model.addAttribute("book",book);
        return "/updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:/Book/allBook";
    }

    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBook(id);
        return "redirect:/Book/allBook";

    }

    //模糊查询
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Book> books = bookService.queryBooksByBookName("%"+queryBookName.trim()+"%");//.trim()去空格

        if (books.size()==0){
            books = bookService.queryBooks();
            model.addAttribute("error","未查到数据");
        }
        model.addAttribute("list",books);
        return "allBook";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String picTest(){


        Book book = new Book(1,"书名",100,"描述");
        String string = JSON.toJSONString(book);

        return string;

    }

}
