package com.lms.demo.service.impl;


import com.lms.demo.dao.BookMapper;
import com.lms.demo.pojo.Book;
import com.lms.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper mapper;
    @Override
    public List<Book> getUncheckedBook() {
        return mapper.getUncheckedBook();
    }

    @Override
    public List<Book> getBook() {
        return mapper.getBook();
    }

    @Override
    public boolean deleteBookInfo(String bid) {
        return mapper.deleteBook(bid)==1;
    }

    @Override
    public boolean addBookInfo(String name, double price) {
        return mapper.addBook(name,price)==1;
    }
}
