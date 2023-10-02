package com.rongyi.mapper;


import com.rongyi.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into my_user values (#{uid},#{username},#{password},#{avatar})")
    void insertUser(User user);

    @Select("select * from my_user where username=#{username} and password=#{password}")
    User queryByUsernameAndPassword(@Param("username") String username,@Param("password") String encodedPassword);
}
