package com.qfedu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qfedu.mapper.MessageMapper;
import com.qfedu.model.Message;
import com.qfedu.page.PageResult;
import com.qfedu.page.QueryPageBean;
import com.qfedu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version: java version 1.8
 * @Author: LiJH
 * @description:
 * @date: 2023-02-22 19:24
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void analysisData(String data) {

        if (StringUtils.isEmpty(data) || data.length() != 12) {
            //数据为空
            throw new RuntimeException("采集数据有误");
        } else {
            //0102030401
            String substring = data.substring(4, 6);
            if (data.startsWith("01") && StringUtils.equals("03", substring)) {
                //数据正确开始解析 获取后面6位
                String substring1 = data.substring(6);
                String idStr = substring1.substring(0, 2);
                String flagStr = substring1.substring(2, 4);
                String basic = substring1.substring(4);
                //获取阈值作比较
                Map threshold = redisTemplate.opsForHash().entries("threshold");
                //从map中取出指定设备id阈值


            }
        }
    }
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        PageResult pageResult = new PageResult();
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        long count = messageMapper.count();
        pageResult.setTotal(count);
        List<Message> page = messageMapper.findPage((currentPage - 1) * pageSize, pageSize);
        pageResult.setRows(page);
        return pageResult;
    }
}
