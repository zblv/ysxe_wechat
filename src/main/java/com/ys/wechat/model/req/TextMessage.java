package com.ys.wechat.model.req;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-接收消息-文本消息
 *
 * @author 吕志博
 * @date 2016-3-8 上午9:36:02
 * @version V1.0
 */
public class TextMessage extends BaseMessage{

    // 消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}  
