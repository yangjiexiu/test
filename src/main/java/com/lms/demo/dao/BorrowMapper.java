package com.lms.demo.dao;


import com.lms.demo.pojo.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BorrowMapper {
    @Results({
            @Result(column = "sname", property = "studentName"),
            @Result(column = "bname", property = "bookName")
//            @Result(column = "borrow.bid", property = "bid"),
//            @Result(column = "borrow.sid", property = "sid"),
//            @Result(column = "borrow.id", property = "id"),
//            @Result(column = "borrow.time", property = "time")
    })

    @Select("select book.name as bname,student.name as sname,borrow.id as id,time,borrow.book_id as bid,borrow.student_id as sid from borrow, student, book where borrow.book_id = book.bid and student.sid = borrow.student_id ORDER BY id")
    List<Borrow> getAll();
    @Delete("delete from borrow where id=#{id}")
    int deleteById(String id);
    @Insert("insert into borrow(student_id,book_id,time) values(#{sid},#{bid},NOW())")
    int add(@Param("bid") String bid,@Param("sid") String sid);
}
