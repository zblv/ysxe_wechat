package com.ys.wechat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ys.wechat.model.TWechatDataAudit;

public interface TWechatDataAuditMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(TWechatDataAudit record);

    TWechatDataAudit selectByPrimaryKey(Long id);

    int updateByPrimaryKey(TWechatDataAudit record);
    
    List<TWechatDataAudit> selectAll(@Param("state")String state);
    
    int delById(Long id);
}