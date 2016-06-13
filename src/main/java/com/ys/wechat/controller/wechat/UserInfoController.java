package com.ys.wechat.controller.wechat;

import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.util.WechatUtil;
import com.ys.wechat.util.WeixinUtil;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信用户信息获取-绑定、免登陆
 *
 * @author 吕志博
 * @date 2016-4-5 下午2:47:00
 * @version V1.0
 */
@Controller
@Scope("prototype")
public class UserInfoController extends BaseController {
	private static Logger log = Logger.getLogger(UserInfoController.class.getName());
	/**
     * 
     * @Description:授权获取微信openid
     *
     * @author 吕志博
     * @date 2016-3-11 下午5:16:45
     * @version V1.0
     * @param code 获取openid凭证-链接中获取
     * @return JSONObject<br>
     * 				access_token:网页授权接口调用凭证<br>
     * 				expires_in:access_token接口调用凭证超时时间，单位（秒）<br>
     * 				refresh_token:用户刷新access_token<br>
     * 				openid:用户唯一标识<br>
     * 				scope:用户授权的作用域<br>
     */
	@RequestMapping(
            value="/get_openid",
            method = RequestMethod.POST
    )
    public void getOpenId(HttpServletRequest request, HttpServletResponse response)  throws Exception {
    	String code = request.getParameter("code");
    	String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WechatUtil.FWAPPID
    					+"&secret="+WechatUtil.FWAPPSECRET
    					+"&code="+code+"&grant_type=authorization_code";
    	PrintWriter out = response.getWriter(); 
    	//微信发送请求并将结果直接响应给请求方
    	out.print(WeixinUtil.httpRequest(url, "GET", null));
    	out.close();  
        out = null;
    }
    
    /**
     * 
     * @Description:授权获取微信用户基本信息
     *
     * @author 吕志博
     * @date 2016-3-11 下午5:27:57
     * @version V1.0
     * @param openid 用户唯一标识-getOpenId接口获取
     * @param access_token 网页授权接口调用凭证-getOpenId接口获取
     * @return	JSONObject<br>
     * 				openid:用户的唯一标识
     * 				nickname:用户昵称
     * 				sex:用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     * 				province:用户个人资料填写的省份
     * 				city:用户个人资料填写的城市
     * 				country:国家
     * 				headimgurl:用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
     * 							用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
     * 				privilege:用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
	@RequestMapping(
            value="/get_userinfo",
            method = RequestMethod.POST
    )
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response)  throws Exception {
    	String openid = request.getParameter("openid");
    	String accessToken = request.getParameter("accessToken");
    	String url = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openid+"&lang=zh_CN";
    	// 响应消息  
        PrintWriter out = response.getWriter();
        out.print(WeixinUtil.httpRequest(url, "GET", null));
        out.close();
        out = null;
    } 
}
