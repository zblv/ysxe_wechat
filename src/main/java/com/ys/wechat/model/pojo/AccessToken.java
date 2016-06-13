package com.ys.wechat.model.pojo;


/**
 *  
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-token存储
 *
 * @author 吕志博
 * @date 2016-3-8 上午10:34:11
 * @version V1.0
 */
public class AccessToken {

    // 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：7200秒  
    private int expiresIn;  
  
    public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }  
}  
