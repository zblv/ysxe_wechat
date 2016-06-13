package com.ys.wechat.model.req;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-接收消息-音频消息
 *				<br>尚未开发
 * @author 吕志博
 * @date 2016-3-8 上午9:34:06
 * @version V1.0
 */  
public class VoiceMessage extends BaseMessage{

    // 媒体ID  
    private String MediaId;  
    // 语音格式  
    private String Format;  
  
    public String getMediaId() {  
        return MediaId;  
    }  
  
    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  
  
    public String getFormat() {  
        return Format;  
    }  
  
    public void setFormat(String format) {  
        Format = format;  
    }  
}  
