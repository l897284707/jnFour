package com.qfedu.cloud.mapper;

import com.qfedu.cloud.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 09:40
 */
public interface UserMapper {
    @Select("select * from user where id= #{id}")
    User getUser(Integer id);
}
