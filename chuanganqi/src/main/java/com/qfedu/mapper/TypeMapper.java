package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.model.DeviceType;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 22:22
 */
public interface TypeMapper extends BaseMapper<DeviceType> {
    @Select("select tname from deviceType where tid = #{tid}")
    String findBytid(int tid);
    @Select("select * from deviceType")
    List<DeviceType> findAll();

}
