package com.zhang.service;

import com.zhang.dao.BookMapper;
import com.zhang.entity.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*
 *   时间：2021/12/9
 *
 *
 */
//@Service
public class BookServiceImpl implements BookService{

    /*@Autowired
    @Qualifier("bookMapper")*/
    private BookMapper bookMapper;


    private SqlSession sqlSession;


    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Book book) {
        return this.bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return this.bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return this.bookMapper.updateBook(book);
    }

    @Override
    public Book queryBook(int id) {
        return this.bookMapper.queryBook(id);
    }

    //一个是mapper关联配置文件查询数据库
    //一个是直接用配置文件中sqlid查询数据库
    @Override
    public List<Book> queryBooks() {
        //List<Book> objects = sqlSession.selectList("orNight.queryF");
        //return this.bookMapper.queryBooks();
        List<Map> objects = sqlSession.selectList("");


        return sqlSession.selectList("orNight.queryF");
    }

    @Override
    public List<Book> queryBooksByBookName(String bookName) {
        return this.bookMapper.queryBooksByBookName(bookName);
    }
}
