package com.example.springedu.dao;

import com.example.springedu.domain.UsersDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersDAO {
    @Insert("insert into users (user_id, user_password, "
            + "user_name, nickname, email, image) "
            + "values (#{userId}, #{userPassword}, #{userName}, #{nickname}, #{email}, #{image})")
    public boolean createUser(UsersDTO dto);

    @Select("select user_id, user_password, user_name, nickname, email, image from users")
    public List<UsersDTO> readUser();

    @Update("update users "
            + "set user_id = #{userId}, user_password = #{userPassword},"
            + "user_name = #{userName}, nickname = #{nickname}, email = #{email}, image = #{image}"
            + "where user_id = #{userId}")
    public boolean updateUser(UsersDTO dto);

    @Delete("delete from users where user_id = #{userId}")
    public boolean deleteUser(int userId);

    @Select("select user_id, user_password, user_name, nickname, email, image from users where ${cn} = #{v}")
    public List<UsersDTO> readUserBy(@Param("cn") String columnName, @Param("v") String value);
}
