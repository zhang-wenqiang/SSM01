package com.zhang.service;

import com.zhang.dao.BookMapper;
import com.zhang.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Book> queryBooks() {
        return this.bookMapper.queryBooks();
    }

    @Override
    public List<Book> queryBooksByBookName(String bookName) {
        return this.bookMapper.queryBooksByBookName(bookName);
    }
}
