package com.ys.wechat.service;

import java.util.List;

import com.ys.wechat.model.TWechatReply;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-消息回复-Service
 *
 * @author 吕志博
 * @date 2016-3-10 下午1:44:25
 * @version V1.0
 */
public interface TWechatReplyService {
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
     * @return 
     */
	TWechatReply updateByPrimaryKey(TWechatReply record);
    
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
	
	/**
	 * 
	 * @Description:根据关键字查询查询
	 *
	 * @author 吕志博
	 * @date 2016-3-11 上午11:56:15
	 * @version V1.0
	 * @param keyword
	 * @return null 为未查找到对应的回复
	 */
	TWechatReply selectByKeyword(String keyword);
}
