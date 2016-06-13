package com.ys.wechat.model.pojo;


/**
 *  
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自定义菜单
 *
 * @author 吕志博
 * @date 2016-3-8 上午9:30:19
 * @version V1.0
 */
public class Menu{

    private ComplexButton[] button;//按钮集
  
    public ComplexButton[] getButton() {  
        return button;  
    }  
  
    public void setButton(ComplexButton[] button) {  
        this.button = button;  
    }  
}
