package com.ys.wechat.model.resp;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-向用户推送消息-音频消息
 *				<br>尚未开发
 * @author 吕志博
 * @date 2016-3-8 上午9:38:56
 * @version V1.0
 */ 
public class MusicMessage extends BaseMessage{

    // 音乐model
    private Music Music;  
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        Music = music;  
    }  
} 
