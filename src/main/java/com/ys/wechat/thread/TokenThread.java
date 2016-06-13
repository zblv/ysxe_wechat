package com.ys.wechat.thread;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.wechat.model.pojo.AccessToken;
import com.ys.wechat.util.WeixinUtil;


  
/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-定时获取微信access_token的线程 
 *
 * @author 吕志博
 * @date 2016-3-8 上午10:40:03
 * @version V1.0
 */
public class TokenThread implements Runnable {  
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);  
    // 第三方用户唯一凭证  
    public static String appid = "";  
    // 第三方用户唯一凭证密钥  
    public static String appsecret = "";
    public static AccessToken accessToken = null;  
    /**JS调用凭证*/
    public static String jsapiTicket = null;  
    public void run() {  
        while (true) {  
            try {  
                accessToken = WeixinUtil.getAccessToken(appid, appsecret);
                jsapiTicket = WeixinUtil.getJsapiTicket();
                if (null != accessToken) {  
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());  
                    log.info("获取jsapi_ticket成功， token:{}", jsapiTicket);
                    // 休眠7000秒  
                    Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);  
                } else {  
                    // 如果access_token为null，60秒后再获取  
                    Thread.sleep(60 * 1000);  
                }  
            } catch (InterruptedException e) {  
                try {  
                    Thread.sleep(60 * 1000);  
                } catch (InterruptedException e1) {  
                    log.error("{}", e1);  
                }  
                log.error("{}", e);  
            }  
        }  
    }  
}  
