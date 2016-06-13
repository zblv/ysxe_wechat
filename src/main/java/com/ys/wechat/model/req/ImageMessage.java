package com.ys.wechat.model.req;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-接收消息-图片消息
 *				<br>尚未开发
 * @author 吕志博
 * @date 2016-3-8 上午9:34:06
 * @version V1.0
 */
public class ImageMessage extends BaseMessage{

    // 图片链接  
    private String PicUrl;
  
    public String getPicUrl() {  
        return PicUrl;  
    }  
  
    public void setPicUrl(String picUrl) {  
        PicUrl = picUrl;  
    }  
}  
