package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.model.Message;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:23
 */
public interface MessageMapper extends BaseMapper<User> {
    @Select("select count(*) from message")
    long count();


    @Select("select * from message  limit #{currentPage},#{pageSize}")
    List<Message> findPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

}
