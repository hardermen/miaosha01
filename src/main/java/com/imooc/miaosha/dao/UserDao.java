package com.imooc.miaosha.dao;

import com.imooc.miaosha.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id")int id);
    @Insert("insert into user(name,password)values(#{name},#{password})")
    public int insert(User user);
}
