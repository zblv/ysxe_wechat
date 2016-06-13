package com.ys.wechat.controller.wechat;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.model.TWechatReply;
import com.ys.wechat.model.resp.Article;
import com.ys.wechat.model.resp.NewsMessage;
import com.ys.wechat.model.resp.TextMessage;
import com.ys.wechat.service.TWechatReplyService;
import com.ys.wechat.util.HttpRequest;
import com.ys.wechat.util.JsonBuilder;
import com.ys.wechat.util.MessageUtil;
import com.ys.wechat.util.SignUtil;
import com.ys.wechat.util.WechatUtil;
 

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-核心业务类
 *
 * @author 吕志博
 * @date 2016-3-8 下午4:25:15
 * @version V1.0
 */
@Controller
@Scope("prototype")
public class CoreController extends BaseController {
    private static Logger log = Logger.getLogger(CoreController.class.getName());
    
    @Autowired
    private TWechatReplyService wechatReplyService;
    
    
    private JsonBuilder jsonBuilder = new JsonBuilder();
    
    /**
     * 
     * @Description:与微信推送来的消息地址相同但是请求方式区分
     *
     * @author 吕志博
     * @date 2016-3-8 下午4:27:36
     * @version V1.0
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/coreservlet",method=RequestMethod.GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;  
    }
    
    /**
     * 
     * @Description:与微信的token验证获取验证地址相同但是请求方式区分-POST
     *
     * @author 吕志博
     * @date 2016-3-8 下午4:27:36
     * @version V1.0
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/coreservlet",method=RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {  
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = processRequest(request);
          
        // 响应消息  
       PrintWriter out = response.getWriter();  
       out.print(respMessage);
       out.close();  
    }
    
    /**
     * 核心业务类接收消息、处理消息 、回复消息
     */
    public String processRequest(HttpServletRequest request) throws Exception{  
        String respMessage = null;  
        
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
            String content = requestMap.get("Content");
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { 
            	if (isQqFace(content)) respContent = content;
            	else{
            		Map<String, String> map = reply(fromUserName, toUserName,content);
            		switch (map.get("type")) {
					case Constants.REPLY_TYPE_TEXT:
						respContent=map.get("text");
						break;
					case Constants.REPLY_TYPE_NEWS:
						return map.get("text");
					default:
						//无法自动处理转发至客服
						textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TRANSFER);
						break;
					}
            	}
            }else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {// 事件推送  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { 
                	Map<String, String> map = reply(fromUserName, toUserName,"zdhf");
                	switch (map.get("type")) {
					case Constants.REPLY_TYPE_TEXT:
						respContent=map.get("text");
						break;
					case Constants.REPLY_TYPE_NEWS:
						return map.get("text");
					default:
						//如果找不到系统后台设置的自动回复则回复该文字消息
						respContent="";
						break;
                	}
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                	//取消订阅后如果账户已与微信绑定则解除账号绑定关系
                	
                }  
                // TODO 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	 // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");
                    StringBuffer buffer = new StringBuffer();
                    NewsMessage newsMessage = new NewsMessage();
                    Article article = new Article();
                    Article[] articles = new Article[1];
                    String json;
                    Map<String, String> map = new HashMap<String, String>();
                    switch (eventKey) {
                    case "mdl"://免登陆按钮点击
                    	
						break;
					default:
						Map<String, String> map1 = reply(fromUserName, toUserName,eventKey);
	            		switch (map1.get("type")) {
						case Constants.REPLY_TYPE_TEXT:
							respContent=map1.get("text");
							break;
						case Constants.REPLY_TYPE_NEWS:
							return map1.get("text");
						default:
							respContent= "功能尚未开发";//点击的类型找不到
							log.info("微信用户："+fromUserName+"发生菜单异常："+content);
							break;
						}
						break;
					}
                    
                }else textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TRANSFER);
            }  
  
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return respMessage;  
    }
    
    //核心业务-回复
    private Map<String, String> reply(String fromUserName,String toUserName,String keyword){
    	Map<String, String> map = new HashMap<String, String>();
    	TWechatReply wechatReply = wechatReplyService.selectByKeyword(keyword);
		if (wechatReply != null && StringUtils.isNotBlank(wechatReply.getReplyText())) {
			textProcessing(wechatReply);
			if (Constants.REPLY_TYPE_TEXT.equals(wechatReply.getReplyType())) {
				map.put("type", Constants.REPLY_TYPE_TEXT);
				map.put("text", wechatReply.getReplyText());
			}else if (Constants.REPLY_TYPE_NEWS.equals(wechatReply.getReplyType())) {
                NewsMessage newsMessage = new NewsMessage();
                Article article = new Article();
                Article[] articles = new Article[1];
				newsMessage.setToUserName(fromUserName);  
				newsMessage.setFromUserName(toUserName);  
				newsMessage.setCreateTime(new Date().getTime());  
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
				newsMessage.setFuncFlag(0);	
				newsMessage.setArticleCount(1);
				article.setTitle(wechatReply.getNewsTitle());
				article.setDescription(wechatReply.getReplyText());
				article.setUrl(wechatReply.getNewsLink());
				article.setPicUrl(wechatReply.getNewsImgLink());
				articles[0] = article;
				newsMessage.setArticles(articles);
				map.put("type", Constants.REPLY_TYPE_NEWS);
				map.put("text", MessageUtil.newsMessageToXml(newsMessage));
			}
		}else {
			if ("zdhf".equals(keyword)) {
				map.put("type", Constants.REPLY_TYPE_TEXT);
				map.put("text", "");
			}else {
				map.put("type", MessageUtil.RESP_MESSAGE_TYPE_TRANSFER);
			}
			
		}
    	return map;
    }
    
    /**
     * 文本处理，回复给用户一个可换行的消息
     */
    private void textProcessing(TWechatReply wechatReply){
    	String str = wechatReply.getReplyText();
    	int x=0;//标记字符串每次开始搜索的起始下标
		StringBuffer buffer = new StringBuffer();
		while (true) {//死循环检测字符串
			int i =str.indexOf("\\\\",x);//每次从上一次搜索结束后的位置开始搜索
			if (i>0) {//当字符串中存在\时
				if ("t".equals(str.substring(i+2, i+3))) {
					buffer.append(str.substring(x,i)).append("\t");
					x = i+3;//将搜索下标从新定位
				}else if ("n".equals(str.substring(i+2, i+3))) {
					buffer.append(str.substring(x,i)).append("\n");
					x = i+3;//将搜索下标从新定位
				}else {
					buffer.append(str.substring(x,i+2));
					x = i+2;//将搜索下标从新定位
				}
			}else {
				buffer.append(str.substring(x));//将最后一段文字加入字符串
				break;
			}
		}
		wechatReply.setReplyText(buffer.toString());
    }
    

    
    //判断是否用户发送的是QQ表情
    public boolean isQqFace(String content) {  
        boolean result = false;  
        // 判断QQ表情的正则表达式  
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||" +
        		"/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|" +
        		"/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|" +
        		"/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|" +
        		"/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|" +
        		"/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|" +
        		"/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|" +
        		"/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";  
        Pattern p = Pattern.compile(qqfaceRegex);  
        Matcher m = p.matcher(content);  
        if (m.matches()) {  
            result = true;  
        }  
        return result;  
    }
}
