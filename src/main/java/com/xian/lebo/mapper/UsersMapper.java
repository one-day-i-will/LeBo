package com.xian.lebo.mapper;

import com.xian.lebo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("select * from users where code= #{code} and password=#{password}")
    Users getUser(Users users);


}
