package com.qfedu.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-28 09:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String pwd;
}