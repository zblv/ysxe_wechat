package com.ys.wechat.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ys.wechat.model.pojo.CommonButton;
import com.ys.wechat.model.pojo.ComplexButton;
import com.ys.wechat.model.pojo.Menu;
import com.ys.wechat.util.JsonBuilder;
  
/**、
 *   
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-基本设置-测试专用
 *
 * @author 吕志博
 * @date 2016-3-8 上午10:40:39
 * @version V1.0
 */
public class MenuManager {   
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
    public static void main(String[] args) { 
    	JsonBuilder jsonBuilder = new JsonBuilder();
    	/**
    	 * 创建菜单  Begin
    	 */
//        int result1 = WeixinUtil.pushWechat(getset(), WeixinUtil.PUSH_TYPE_INDUSTRY);
//        if (0 == result1)  
//            log.info("成功！");  
//        else  
//            log.info("失败，错误码：" + result1); 
//        System.out.println(jsonBuilder.toJson(getMenu()));
//        int result2 = WeixinUtil.pushWechat(getMenu(), WeixinUtil.PUSH_TYPE_CREATEMENU);
//        if (0 == result2)  
//            log.info("成功！");  
//        else  
//            log.info("失败，错误码：" + result2);
        /**
    	 * 创建菜单  end
    	 */
    	
    	/**
    	 * 获取现有菜单列表 begin
    	 */
//        int result = WeixinUtil.pushWechat(null, "getMenu");
//        if (0 == result)  
//            log.info("成功！");  
//        else  
//            log.info("失败，错误码：" + result);
    	/**
    	 * 获取现有菜单列表 end
    	 */

    	/**
    	 * String字符切割 Begin
    	 */
//		String str =  "\n啊啊啊啊啊啊啊啊啊啊啊银盛金服(<a href=\"http://www.ysfas.com\">www.ysfas.com</a>)";
//		System.out.println(str);
//		int x=0;
//		StringBuffer buffer = new StringBuffer();
//		while (true) {
//			int i =str.indexOf("\\",x);
//			if (i>0) {
//				if ("t".equals(str.substring(i+1, i+2))) {
//					buffer.append(str.substring(x,i)).append("\t");
//					x = i+2;
//				}else if ("n".equals(str.substring(i+1, i+2))) {
//					buffer.append(str.substring(x,i)).append("\n");
//					x = i+2;
//				}else {
//					buffer.append(str.substring(x,i+1));
//					x = i+1;
//				}
//	 		}else {
//				buffer.append(str.substring(x));
//				break;
//			}
//		}
//		System.out.println(buffer.toString());
    	System.out.println(URLEncoder.encode("http://10.211.62.11:8080/sp2p_qhys/appweb/bindingWXInit.do?aa=aa"));
		/**
    	 * String字符切割 end
    	 */
		
		/**
		 * 客服回复接口Begin
		 */
//		Map<String, Object> map = new HashMap<String, Object>();
//		Map<String, String> map1 = new HashMap<String, String>();
//		map1.put("content", "你之前说的我现在回复");
//		map.put("touser", "oTjXAt_VHx_k7lBWPQMgHPEQJt0s");
//		map.put("msgtype", "text");
//		map.put("text", map1);
//		int result4 = WeixinUtil.pushWechat(map ,WeixinUtil.PUSH_TYPE_SENDCUSTOM);
//		if (0 == result4)  
//          log.info("成功！");
//		else  
//          log.info("失败，错误码：" + result4);  
        /**
  		 * 客服回复接口end
  		 */
    	
    	/**
    	 * HTTP POST请求 Begin
    	 */
//    	Map<String, String> map = new HashMap<String, String>();
//    	map.put("openid", "oTjXAt_VHx_k7lBWPQMgHPEQJt0s");
//    	map.put("temType", "1");
//    	map.put("json", "json");
//    	map.put("code", "111");
//    	
//    	String json = http("http://14f6121z29.51mypc.cn/yswechat/get_openid",map);
//    	String json = http("http://10.211.62.11:8080/sp2p_weixin/userAccount.do",map);
//    	Map map2 = (Map)jsonBuilder.fromJson(json, Map.class);
//    	List<Map> list = jsonBuilder.fromJsonArray(jsonBuilder.toJson(map2.get(("incomeList"))));
//    	System.out.println("------------------------"+json);
//    	System.out.println(MD5.encrypt("123456"));
    	/**
    	 * HTTP POST请求 End
    	 */
    	
    	/**
    	 * 生成带参数的二维码begin
    	 */
//    	Map map = new HashMap<>();
//    	map.put("expire_seconds", 600);
//    	map.put("action_name", "QR_SCENE");
//    	Map action_info = new HashMap<>();
//    	Map scene = new HashMap<>();
//    	scene.put("scene_id", "yswechat");
//    	action_info.put("scene", scene);
//    	map.put("action_info", action_info);
//    	System.out.println(WeixinUtil.getCreate(map));
//		System.out.println(2<<1);
		/**
    	 * 生成带参数的end
    	 */
    }  
   //{"username":"qw1","error":-100,"dueinSum":"18363.33","incomeList":[{"num":1,"totalSum":1001,"minRepayDate":"2016-03-18"},{"num":1,"totalSum":1002,"minRepayDate":"2016-03-21"},{"num":1,"totalSum":1002.72,"minRepayDate":"2016-03-22"}],"msg":"未知异常"}
    // {"username":"qw1","dueinSum":"18363.33","redMoney":"0.00","usableSum":"483112.92","freezeSum":"8101.00","handleSum":"509577.25"}
    public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
    
	public static String tt(){
		String url = "http://10.211.62.11:8080/sp2p_weixin/userAccount.do";
		String json=loadJSON(url);
		return json;
	}
	
	public static String http(String url, Map<String, String> params) {

		URL u = null;

		HttpURLConnection con = null;

		//构建请求参数

		StringBuffer sb = new StringBuffer();

		if(params!=null){

		for (Entry<String, String> e : params.entrySet()) {

		sb.append(e.getKey());

		sb.append("=");

		sb.append(e.getValue());

		sb.append("&");

		}

		sb.substring(0, sb.length() - 1);

		}

		
		System.out.println("send_url:"+url);

		System.out.println("send_data:"+sb.toString());

		//尝试发送请求

		try {

		u = new URL(url);

		con = (HttpURLConnection) u.openConnection();

		con.setRequestMethod("POST");

		con.setDoOutput(true);

		con.setDoInput(true);

		con.setUseCaches(false);

		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");

		osw.write(sb.toString());

		osw.flush();

		osw.close();

		} catch (Exception e) {

		e.printStackTrace();

		} finally {

		if (con != null) {

		con.disconnect();

		}

		}

		 

		//读取返回内容

		StringBuffer buffer = new StringBuffer();

		try {

		BufferedReader br = new BufferedReader(new InputStreamReader(con

		.getInputStream(), "UTF-8"));

		String temp;

		while ((temp = br.readLine()) != null) {

		buffer.append(temp);

		buffer.append("\n");

		}

		} catch (Exception e) {

		e.printStackTrace();

		}

		 

		return buffer.toString();

		}
	
	
	
	
	
    /**
     * 设置模板消息所属行业
     */
    private static Map<String,String> getset() {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("industry_id1", "1");
    	map.put("industry_id2", "8");
    	return map;
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
    	 CommonButton btn11 = new CommonButton();
         btn11.setName("免登陆");  
         btn11.setType("click");  
         btn11.setKey("mdl"); 
         
        CommonButton btn12 = new CommonButton();
        btn12.setName("我要投资");  
        btn12.setType("click");  
        btn12.setKey("wytz");  
  
        CommonButton btn13 = new CommonButton();  
        btn13.setName("我要借款");  
        btn13.setType("click");  
        btn13.setKey("wyjk");  
  
        CommonButton btn14 = new CommonButton();
        btn14.setName("资产收益");  
        btn14.setType("click");  
        btn14.setKey("zcsy");  
        
        CommonButton btn15 = new CommonButton();
        btn15.setName("我要提现");  
        btn15.setType("click");  
        btn15.setKey("wytx");  
  
        CommonButton btn21 = new CommonButton();  
        btn21.setName("一起赚");  
        btn21.setType("view");  
        btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe7290e31cf495964&redirect_uri=http%3A%2F%2F14f6121z29.51mypc.cn%2Fyswechat%2Ftest&response_type=code&scope=snsapi_userinfo&state=yqz#wechat_redirect");  
  
        CommonButton btn22 = new CommonButton();  
        btn22.setName("平台公告");  
        btn22.setType("view");  
        btn22.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe7290e31cf495964&redirect_uri=http%3A%2F%2F14f6121z29.51mypc.cn%2Fyswechat%2Ftest&response_type=code&scope=snsapi_userinfo&state=ptgg#wechat_redirect");  
  
        CommonButton btn31 = new CommonButton();  
        btn31.setName("关于我们");  
        btn31.setType("click");  
        btn31.setKey("gywm");  
  
        CommonButton btn32 = new CommonButton();  
        btn32.setName("常见问题");  
        btn32.setType("click");  
        btn32.setKey("cjwt");  
  
        CommonButton btn33 = new CommonButton();  
        btn33.setName("在线客服");
        btn33.setType("click");
        btn33.setKey("zxkf");
        
        CommonButton btn34 = new CommonButton();  
        btn34.setName("模板消息测试");
        btn34.setType("click");
        btn34.setKey("mbxxcs");
        
        ComplexButton mainBtn1 = new ComplexButton();  
        mainBtn1.setName("投资/理财");  
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14, btn15 });  
  
        ComplexButton mainBtn2 = new ComplexButton();  
        mainBtn2.setName("最新资讯");  
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22});  
  
        ComplexButton mainBtn3 = new ComplexButton();  
        mainBtn3.setName("其他");  
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33,btn34});  
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new ComplexButton[] { mainBtn1, mainBtn2, mainBtn3 });  
  
        return menu;  
    }
     
  
    /** 
     * 发送HttpPost请求 
     *  
     * @param strURL 
     *            服务地址 
     * @param params 
     *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/> 
     * @return 成功:返回json字符串<br/> 
     */  
    public static String post(String strURL, String params) {  
        System.out.println(strURL);  
        System.out.println(params);  
        try {  
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  
            connection.connect();  
            OutputStreamWriter out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(params);  
            out.flush();  
            out.close();  
            // 读取响应  
            int length = (int) connection.getContentLength();// 获取长度  
            InputStream is = connection.getInputStream();  
            if (length != -1) {  
                byte[] data = new byte[length];  
                byte[] temp = new byte[512];  
                int readLen = 0;  
                int destPos = 0;  
                while ((readLen = is.read(temp)) > 0) {  
                    System.arraycopy(temp, 0, data, destPos, readLen);  
                    destPos += readLen;  
                }  
                String result = new String(data, "UTF-8"); // utf-8编码  
                System.out.println(result);  
                return result;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return "error"; // 自定义错误信息  
    }  
}  