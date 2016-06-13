package com.ys.wechat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.dao.TWechatReplyMapper;
import com.ys.wechat.model.TWechatReply;
import com.ys.wechat.service.TWechatReplyService;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-消息回复-ServiceImpl
 *
 * @author 吕志博
 * @date 2016-3-10 下午1:44:25
 * @version V1.0
 */
@Service
public class TWechatReplyServiceImpl implements TWechatReplyService{
	@Autowired
	private TWechatReplyMapper wechatReplyMapper;
	
	@Override
	public int insert(TWechatReply record) {
		record.setCreateDate(new Date());
		return wechatReplyMapper.insert(record);
	}

	@Override
	public TWechatReply updateByPrimaryKey(TWechatReply record) {
		record.setUpdateDate(new Date());
		return record.getId()==null?null:wechatReplyMapper.updateByPrimaryKey(record)>0?record:null;
	}

	@Override
	public List<TWechatReply> selectBy(TWechatReply wechatReply) {
		return wechatReplyMapper.selectBy(wechatReply);
	}

	@Override
	public TWechatReply selectByKeyword(String keyword) {
		TWechatReply wechatReply = new TWechatReply();
		wechatReply.setKeyword(keyword);
		wechatReply.setStatus(Constants.STATUS_OPEN);
		List<TWechatReply> list = selectBy(wechatReply);
		return list.size()>0?list.get(0):null;
	}

}
