package com.ys.wechat.dao;

import org.apache.ibatis.annotations.Param;

import com.ys.wechat.model.TWechatUserInfo;

public interface TWechatUserInfoMapper {

    int insert(TWechatUserInfo record);

    TWechatUserInfo selectByOpenid(String openid);

    int updateByOpenid(@Param("openid")String openid,@Param("status")String status);
}