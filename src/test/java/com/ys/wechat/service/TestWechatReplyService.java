package com.ys.wechat.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.model.TWechatReply;
import com.ys.wechat.util.JsonBuilder;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-消息回复-junit
 *
 * @author 吕志博
 * @date 2016-3-10 下午4:37:54
 * @version V1.0
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath*:application*.xml"})
public class TestWechatReplyService {
	@Autowired
	private TWechatReplyService wechatReplyService;
	
	@Test
	public void insert(){
		TWechatReply wechatReply = new TWechatReply();
		wechatReply.setKeyword("test");
		wechatReply.setKeyType(Constants.REPLY_KEY_TYPE_ACCURATE);
		wechatReply.setReplyType(Constants.REPLY_TYPE_TEXT);
		wechatReply.setReplyText("测试类回复回复回复回复回复");
		wechatReply.setStatus(Constants.STATUS_OPEN);
		System.out.println("------------------->"+wechatReplyService.insert(wechatReply));
	}
	
	@Test
	public void updateByPrimaryKey(){
		TWechatReply wechatReply = new TWechatReply();
		wechatReply.setKeyword("test");
		wechatReply.setStatus(Constants.STATUS_OPEN);
		wechatReply = wechatReplyService.selectBy(wechatReply).get(0);
		wechatReply.setKeyword("test6");
		wechatReplyService.updateByPrimaryKey(wechatReply);
		TWechatReply wechatReply2 = new TWechatReply();
		wechatReply2.setKeyword("test6");
		wechatReply2.setStatus(Constants.STATUS_OPEN);
		JsonBuilder jsonBuilder = new JsonBuilder();
		System.out.println(jsonBuilder.toJson("------------------->"+wechatReplyService.selectBy(wechatReply2)));
	}
	
	@Test
	public void selectBy(){
		TWechatReply wechatReply = new TWechatReply();
		wechatReply.setKeyword("test");
		wechatReply.setStatus(Constants.STATUS_OPEN);
		JsonBuilder jsonBuilder = new JsonBuilder();
		System.out.println(jsonBuilder.toJson("------------------->"+wechatReplyService.selectBy(wechatReply)));
	}
}
