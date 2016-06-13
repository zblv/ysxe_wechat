package com.ys.wechat.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ys.wechat.model.TWechatMessage;

public interface TWechatMessageMapper {

    int insert(TWechatMessage record);

    TWechatMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TWechatMessage record);
    
    /**
     * 
     * @Description:查询一段时间内用户的留言
     *
     * @author 吕志博
     * @date 2016-3-23 下午2:01:17
     * @version V1.0
     * @param beginDate	开始时间
     * @param endDate	结束时间
     * @return
     */
    List<TWechatMessage> selectByCreateDate(@Param("beginDate")Date beginDate,@Param("endDate")Date endDate);
}