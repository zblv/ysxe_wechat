package com.ys.wechat.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.wechat.thread.TokenThread;
import com.ys.wechat.util.WechatUtil;
import com.ys.wechat.util.WeixinUtil;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自动启动任务
 *
 * @author 吕志博
 * @date 2016-3-10 下午5:04:04
 * @version V1.0
 */
public class InitServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;  
    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);  
  
    public void init() throws ServletException {  
        // 获取web.xml中配置的参数  微信
    	 log.info("进入init方法");
    	 log.info("进入init方法appid:{}appsecret:{1}", WechatUtil.FWAPPID,WechatUtil.FWAPPSECRET); 
        TokenThread.appid = WechatUtil.FWAPPID;//读取配置文件中的微信服务号基本信息
        TokenThread.appsecret = WechatUtil.FWAPPSECRET;
        log.info("weixin api appid:{}", TokenThread.appid);  
        log.info("weixin api appsecret:{}", TokenThread.appsecret); 
        
        // 未配置appid、appsecret时给出提示  
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {  
            log.error("appid and appsecret configuration error, please check carefully.");  
        } else {  
            // 启动定时获取access_token的线程  
        	new Thread(new TokenThread()).start();
        }
    }  
}
