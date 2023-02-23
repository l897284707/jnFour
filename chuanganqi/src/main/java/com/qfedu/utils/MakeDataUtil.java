package com.qfedu.utils;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:25
 */
public class MakeDataUtil {
    public static String makeData(int basic) {
        //04代表温度传感器Id  01代表+  最后两位代表数据值
        //长度为12  01 开头 56为必须是03  910位01代表+  00代表-   78位代表设备id
        String  data ="0102030401"+basic;

        return data;
    }
}
