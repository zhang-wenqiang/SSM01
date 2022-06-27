package com.zhang.service;

import com.zhang.entity.Book;

import java.util.List;

/*
 *   时间：2021/12/9
 *
 *
 */
public interface BookService {
    //添加一本书
    int addBook(Book book);

    //删除一本书
    int deleteBook(int id);

    //更改一本书
    int updateBook(Book book);

    //查询一本书
    Book queryBook(int id);

    //查询全部图书
    List<Book> queryBooks();

    //根据书名查询书籍
    List<Book> queryBooksByBookName(String bookName);
}
