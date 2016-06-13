package com.ys.wechat.model.pojo;


/**
 *  
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自定义菜单-一级菜单按钮
 *
 * @author 吕志博
 * @date 2016-3-8 上午9:29:12
 * @version V1.0
 */
public class ComplexButton extends Button{

    private CommonButton[] sub_button;//二级菜单集
  
    public CommonButton[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(CommonButton[] sub_button) {  
        this.sub_button = sub_button;  
    }  
}
