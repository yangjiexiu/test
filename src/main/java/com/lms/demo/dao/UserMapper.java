package com.lms.demo.dao;


import com.lms.demo.pojo.Account;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Results({
            @Result(column = "nick_name", property = "nickName")
    })
    @Select("select * from user where name=#{name} and password=#{password}")
    Account getUser(@Param("name") String name, @Param("password")String password);
    @Select("select * from user where name=#{name}")
    Account getUserByName(@Param("name") String name);
}
