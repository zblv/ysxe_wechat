package com.ys.wechat.controller.sys;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.InvokeResult;
import com.ys.wechat.model.TWechatReply;
import com.ys.wechat.service.TWechatReplyService;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:自动回复消息设置
 *
 * @author 吕志博
 * @date 2016-3-22 下午3:34:19
 * @version V1.0
 */
@Controller
@RequestMapping(value="/system/message")
public class MessageController extends BaseController {
	private static Logger log = Logger.getLogger(MessageController.class.getName());
	@Autowired
	private TWechatReplyService wechatReplyService;
	
	/**去自动回复消息管理*/
	@RequestMapping(value = "/init")
	public String init(){
		List<TWechatReply> replies = wechatReplyService.selectBy(new TWechatReply());
		request.setAttribute("replies", replies);
		return "message/auto_message_edit";
	}
	
	/** 添加或修改自动回复*/
	@RequestMapping(value = "/addOrUpdateReply")
	@ResponseBody
	public InvokeResult addOrUpdateReply(TWechatReply wechatReply){
		log.info(getCurrUser().getUserName()+"---->进行自动回复设置："+wechatReply.getKeyword());
		if (StringUtils.isBlank(wechatReply.getKeyword())) {
			return InvokeResult.returnError("请填写关键词");
		}
		if (StringUtils.isBlank(wechatReply.getKeyType())) {
			return InvokeResult.returnError("请选择索引方式");
		}
		if (StringUtils.isBlank(wechatReply.getReplyType())) {
			return InvokeResult.returnError("请选择回复方式");
		}
		if (StringUtils.isBlank(wechatReply.getReplyText())) {
			return InvokeResult.returnError("请输入回复内容");
		}
		if (StringUtils.isBlank(wechatReply.getStatus())) {
			wechatReply.setStatus("open");
		}
		if ("news".equals(wechatReply.getReplyType())) {
			if (StringUtils.isBlank(wechatReply.getNewsTitle())) {
				return InvokeResult.returnError("请输入图文消息标题");
			}
		}
		textProcessing(wechatReply);
		if (wechatReply.getId() != null) {
			wechatReplyService.updateByPrimaryKey(wechatReply);
		}else {
			if (wechatReplyService.selectByKeyword(wechatReply.getKeyword()) != null) {
				return InvokeResult.returnError("该关键词以存在，不得重复添加");
			}
			wechatReplyService.insert(wechatReply);
		}
		return InvokeResult.returnSuccess("操作成功");
	}
	
	/**
     * 文本处理
	 *
     */
    private void textProcessing(TWechatReply wechatReply){
    	String str = wechatReply.getReplyText();
    	int x=0;//标记字符串每次开始搜索的起始下标
		StringBuffer buffer = new StringBuffer();
		while (true) {//死循环检测字符串
			int i =str.indexOf("\\",x);//每次从上一次搜索结束后的位置开始搜索
			if (i>0) {//当字符串中存在\时
				if ("t".equals(str.substring(i+1, i+2)) && !"\\".equals(str.substring(i-1, i))) {
					buffer.append(str.substring(x,i)).append("\\\\t");
					x = i+2;//将搜索下标从新定位
				}else if ("n".equals(str.substring(i+1, i+2)) && !"\\".equals(str.substring(i-1, i))) {
					buffer.append(str.substring(x,i)).append("\\\\n");
					x = i+2;//将搜索下标从新定位
				}else {
					buffer.append(str.substring(x,i+1));
					x = i+1;//将搜索下标从新定位
				}
			}else {
				buffer.append(str.substring(x));//将最后一段文字加入字符串
				break;
			}
		}
		wechatReply.setReplyText(buffer.toString());
    }
	
}
