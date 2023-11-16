package com.lms.demo.dao;


import com.lms.demo.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookMapper {
    @Select("select * from book")
    List<Book> getBook();
    @Select("SELECT * FROM book WHERE bid NOT IN (SELECT book_id FROM borrow)")
    List<Book> getUncheckedBook();
    @Delete("delete from book where bid=#{bid}")
    int deleteBook(String bid);
    @Insert("insert into book(name,price) values (#{name},#{price})")
    int addBook(@Param("name") String name, @Param("price") double price);
}
