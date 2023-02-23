package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.model.Device;
import com.qfedu.model.DeviceType;
import com.qfedu.model.Message;
import com.qfedu.vo.DeviceVo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:23
 */
public interface DeviceMapper extends BaseMapper<Device> {
    @Select("select count(*) from device")
    long count();
    @Results(id = "deviceMap",value = {
            @Result(column = "id",property ="id"),
            @Result(column = "dname",property ="dname"),
            @Result(column = "address",property ="address"),
            @Result(column = "max",property ="max"),
            @Result(column = "min",property ="min"),
            @Result(column = "tid",property = "tname",
                    one = @One(select = "com.qfedu.mapper.TypeMapper.findBytid",fetchType = FetchType.DEFAULT)
            ),
            @Result(column = "createtime",property = "createtime"),
            @Result(column = "updatetime",property = "updatetime")

    })
    @Select("select * from device  limit #{currentPage},#{pageSize}")
    List<DeviceVo> findPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
    @Results(id = "devicetypeMap",value = {
            @Result(column = "dname",property ="dname"),
            @Result(column = "address",property ="address"),
            @Result(column = "max",property ="max"),
            @Result(column = "min",property ="min"),
            @Result(column = "tid",property = "tname",
                    one = @One(select = "com.qfedu.mapper.TypeMapper.findBytid",fetchType = FetchType.DEFAULT)
            ),
            @Result(column = "createtime",property = "createtime"),
            @Result(column = "updatetime",property = "updatetime")

    })
    @Select("select * from device where id = #{id}")
    DeviceVo findById(int id);

    @Update("update device set dname=#{dname},address=#{address},max=#{max},min=#{min},tid=#{tid} where id=#{id}")
    int editDevice(Device device);
}
