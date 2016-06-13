package com.ys.wechat.dao;

import java.util.List;

import com.ys.wechat.model.TWechatReply;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-消息回复-DAO
 *
 * @author 吕志博
 * @date 2016-3-10 上午11:48:12
 * @version V1.0
 */
public interface TWechatReplyMapper {
	/**
	 * 
	 * @Description:新增回复
	 *
	 * @author 吕志博
	 * @date 2016-3-10 上午11:48:05
	 * @version V1.0
	 * @param record
	 * @return 1:成功,0:失败
	 */
	int insert(TWechatReply record);
	
	/**
     * 
     * @Description:修改回复
     *
     * @author 吕志博
     * @date 2016-3-10 上午11:25:32
     * @version V1.0
     * @param record 根据ID修改其所有信息
     * @return 1:成功,0:失败
     */
	int updateByPrimaryKey(TWechatReply record);
    
	/**
	 * 
	 * @Description:根据对象查询
	 *
	 * @author 吕志博
	 * @date 2016-3-10 下午12:04:35
	 * @version V1.0
	 * @param id
	 * @return
	 */
    List<TWechatReply> selectBy(TWechatReply wechatReply);
    
}