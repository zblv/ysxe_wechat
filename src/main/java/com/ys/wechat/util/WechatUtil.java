package com.ys.wechat.util;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-基本数据读取
 *
 * @author 吕志博
 * @date 2016-3-10 下午5:06:26
 * @version V1.0
 */
public class WechatUtil {

	
	/**项目地址地址*/
	public static String FILESRC;
	
	/**图片地址*/
	public static String IMGSRC;
	/**微信服务号APPID*/ 
	public static String FWAPPID;
	
	/**微信服务号appsecret*/ 
	public static String FWAPPSECRET;
	
	/**微信页面授权地址*/
	public static String WECHATAUTHORIZEURL;

	static {
		Properties prop = null;
		try {
			prop=PropertiesLoaderUtils.loadAllProperties("wechat.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		FWAPPID = prop.getProperty("FwAppId");
		FWAPPSECRET = prop.getProperty("FwAppSecret");
		WECHATAUTHORIZEURL = prop.getProperty("WechatAuthorizeUrl")+"?appid="+FWAPPID;
		IMGSRC = "images/sc/";
		FILESRC = System.getProperty("user.dir").replace("bin",
				"webapps/ysxe_wechat/");
	}

}
