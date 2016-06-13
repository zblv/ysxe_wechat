package com.ys.wechat.dao;

import com.ys.wechat.model.TWechatScan;

public interface TWechatScanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TWechatScan record);

    int insertSelective(TWechatScan record);

    TWechatScan selectByPrimaryKey(Long id);
    
    TWechatScan selectByUid(String uid);

    int updateByPrimaryKeySelective(TWechatScan record);
    
    int updateByUid(TWechatScan record);
    
    int updateByPrimaryKey(TWechatScan record);
}