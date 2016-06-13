package com.ys.wechat.model.pojo;


/**
 *  
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自定义菜单-二级菜单按钮
 *
 * @author 吕志博
 * @date 2016-3-8 上午9:19:34
 * @version V1.0
 */
public class CommonButton extends Button{

    private String type;//菜单的响应动作类型（click：点击推事件，view：跳转URL）
    private String key;//菜单KEY值，用于消息接口推送，不超过128字节
    private String url;//网页链接，用户点击菜单可打开链接，不超过1024字节
    private Button[] sub_button;
    
    public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getKey() {  
        return key;  
    }  
  
    public void setKey(String key) {  
        this.key = key;  
    }  
}  
