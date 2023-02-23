package com.qfedu.service;

import com.qfedu.page.PageResult;
import com.qfedu.page.QueryPageBean;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:24
 */
public interface MessageService {
    void analysisData(String data);

    PageResult findPage(QueryPageBean queryPageBean);
}
