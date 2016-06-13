package com.ys.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.ys.wechat.model.pojo.AccessToken;
import com.ys.wechat.model.pojo.Menu;
import com.ys.wechat.thread.TokenThread;

  
/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-公众平台通用接口工具类 
 *
 * @author 吕志博
 * @date 2016-3-8 上午10:52:13
 * @version V1.0
 */
public class WeixinUtil {  
    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);
    
    private static JsonBuilder jsonBuilder = new JsonBuilder();
    /**
     * 
     * 
     * 获取access_token的接口地址（GET）
     */
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";  
    
    /**
     * 获取jsapi_ticket的接口地址（GET）
     */
    public final static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    
    /**
     *  菜单创建（POST） 限100（次/天）  
     */
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
    
    /**
     * 自定义菜单查询
     */
    public static String menu_get_url ="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    
    /**
     * 文本消息推送
     */
    public static String custom_send_url ="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    
    /**
     * 所属行业
     */
    public static String api_set_industry_url ="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    
    /**
     * 模板消息
     */
    public static String template_send_url ="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    
    /**
     * 生成二维码
     */
    public static final String qrcode_create_url ="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    
    /**
     * 菜单创建
     */
    public static final String PUSH_TYPE_CREATEMENU = "createMenu";
    
    /**
     * 自定义菜单查询
     */
    public static final String PUSH_TYPE_GETMENU = "getMenu";
    
    /**
     * 文本消息推送
     */
    public static final String PUSH_TYPE_SENDCUSTOM = "sendCustom";
    
    /**
     * 所属行业设置
     */
    public static final String PUSH_TYPE_INDUSTRY = "industry";
    
    /**
     * 模板消息推送
     */
    public static final String PUSH_TYPE_SENDTEMPLATE = "sendTemplate";
    
    /**
     * 生成二维码
     */
    public static final String QRCODE_CREATE = "qrcodeCreate";
    /** 
     * 获取access_token 
     *  
     * @param appid 凭证 
     * @param appsecret 密钥 
     * @return 
     */  
    public static AccessToken getAccessToken(String appid, String appsecret) {  
        AccessToken accessToken = null;  
      
        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);  
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
        // 如果请求成功  
        if (null != jsonObject) {  
            try {  
                accessToken = new AccessToken();  
                accessToken.setToken(jsonObject.getString("access_token"));  
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));  
            } catch (JSONException e) {
                accessToken = null;  
                // 获取token失败  
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }
        return accessToken;
    }
    
    /** 
     * 获取jsapi_ticket 
     *  
     * @param 
     * @param 
     * @return 
     */  
    public static String getJsapiTicket() {  
    	String jsapiTicket = null;  
      
        String requestUrl = jsapi_ticket_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());  
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
        // 如果请求成功  
        if (null != jsonObject) {  
            try {  
            	jsapiTicket= jsonObject.getString("ticket");
            } catch (JSONException e) {
            	jsapiTicket = null;  
                // 获取token失败  
                log.error("获取jsapiTicket失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }
        return jsapiTicket;  
    }
    /** 
     * 发起https请求并获取结果 
     *  
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
     */  
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {  
            log.error("Weixin server connection timed out.");  
        } catch (Exception e) {  
            log.error("https request error:{}", e);  
        }  
        return jsonObject;  
    }
    
    
    public static int pushWechat(Object object,String type) {  
        int result = 0;
        String json = null;
        if (object !=null) {
        	json = JSONObject.fromObject(object).toString();
		}
        
        //拼装消息推送的url
        String url = "";
        String requestMethod="POST";//默认post数据传递方式
        switch (type) {
        case PUSH_TYPE_CREATEMENU:
        	url = menu_create_url.replace("ACCESS_TOKEN",TokenThread.accessToken.getToken());
			break;
        case PUSH_TYPE_GETMENU:
        	url = menu_get_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
        	requestMethod = "GET";
			break;
		case PUSH_TYPE_SENDCUSTOM:
			url = custom_send_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
			break;
		case PUSH_TYPE_INDUSTRY:
			url = api_set_industry_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
			break;
		case PUSH_TYPE_SENDTEMPLATE:
			url = template_send_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
			break;	
		default:
			break;
		}
        log.info("微信推送json-》"+json);
        // 调用接口创建菜单  
        JSONObject jsonObject = httpRequest(url, requestMethod, json);
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  
                result = jsonObject.getInt("errcode");  
                log.error("失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }
        }  
        return result;  
    } 
    
    public static String getCreate(Object object) {  
        String json = null;
        if (object !=null) {
        	json = JSONObject.fromObject(object).toString();
		}
        //拼装消息推送的url
        String url = "";
        String requestMethod="POST";//默认post数据传递方式
//        url = qrcode_create_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
        url = qrcode_create_url.replace("ACCESS_TOKEN", "NFMQFwEcW5DbX6dDDtvxWWosIxjP8vLlLF0qaMqir8IK8lgCpj7ElXkd46P-_k0h3Gb1fIRNaZp28rROgmU_ocO1pESX0cZUQnT3Lqm5lfuQIE6EPs89g5Z5d9_EVStgTHTiCDAYMY");
		JSONObject jsonObject = httpRequest(url, requestMethod, json);
		Map map = (Map)jsonBuilder.fromJson(jsonObject.toString(),  Map.class);
		return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+URLEncoder.encode(map.get("ticket").toString());
     } 
    
    public static Menu getMenu() {  
       String url = menu_get_url.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
        // 调用接口查询菜单  
        JSONObject jsonObject = httpRequest(url, "GET", null);
        
    	Menu menu = (Menu)jsonBuilder.fromJson(jsonObject.getString("menu"), Menu.class);
        return menu;  
    } 
}  

