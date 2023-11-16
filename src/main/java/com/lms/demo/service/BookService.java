package com.lms.demo.service;



import com.lms.demo.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getUncheckedBook();
    List<Book> getBook();
    boolean deleteBookInfo(String bid);
    boolean addBookInfo(String name,double price);
}
