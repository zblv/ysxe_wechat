package com.ys.wechat.controller.qrcode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.InvokeResult;
import com.ys.wechat.model.TWechatDataAudit;
import com.ys.wechat.service.TWechatDataAuditService;
import com.ys.wechat.service.TWechatScanService;
import com.ys.wechat.thread.TokenThread;
import com.ys.wechat.util.JsonBuilder;
import com.ys.wechat.util.SignUtil;
import com.ys.wechat.util.WechatUtil;
import com.ys.wechat.util.WeixinUtil;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:图片上传
 *
 * @author 吕志博
 * @date 2016-5-19 下午1:52:46
 * @version V1.0
 */
@Controller
@Scope("prototype")
public class QRCodeController extends BaseController{
	private static Logger log = Logger.getLogger(QRCodeController.class.getName());
	
	
	@Autowired
	private TWechatScanService wechatScanService;

	@Autowired
	private TWechatDataAuditService wechatDataAuditService;
	
	
	/**去图片上传界面*/
	@RequestMapping(value = "/wximgsc")
	public String wximgsc(){
		return "qrcode/wximgsc";
	}
	
	/**提示使用微信打开*/
	@RequestMapping(value = "/wximgerr")
	public String wximgerr(){
		return "qrcode/wximgscerr";
	}
	
	@ResponseBody
	@RequestMapping(value = "/imgsctp")
	public InvokeResult imgsctp(String serverIds ,TWechatDataAudit wechatDataAudit) throws Exception{
		//String[] strServerId = serverIds.split(",");
		if (StringUtils.isBlank(wechatDataAudit.getRelName())) {
			return new InvokeResult().returnError("请输入客户姓名");
		}
		if (StringUtils.isBlank(wechatDataAudit.getMobilePhone())) {
			return new InvokeResult().returnError("请输入联系方式");
		}
		if (StringUtils.isBlank(wechatDataAudit.getAddress())) {
			return new InvokeResult().returnError("请输入联系地址");
		}
		if (StringUtils.isBlank(wechatDataAudit.getLoanMoney())) {
			return new InvokeResult().returnError("请输入贷款金额");
		}
		if (StringUtils.isBlank(wechatDataAudit.getLoanTerm())) {
			return new InvokeResult().returnError("请输入贷款期限");
		}
		if (StringUtils.isBlank(wechatDataAudit.getLoanPurpose())) {
			return new InvokeResult().returnError("请输入借款用途");
		}
		if (StringUtils.isBlank(wechatDataAudit.getRepaySource())) {
			return new InvokeResult().returnError("请输入还款来源");
		}
//		int x=0;
//		StringBuffer buffer = new StringBuffer();
//		 for (int i=0 ; i < strServerId.length; i++) {
//			 x=i+1;
//	    	String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token="+TokenThread.accessToken.getToken()
//	    			+"&media_id="+strServerId[i];
//	    	log.info("用户上传图片Url="+url);
//	    	download(url,strServerId[i]+".jpg",WechatUtil.FILESRC+WechatUtil.IMGSRC);
//	    	if (i>0) {
//	    		buffer.append(",");
//			}
//	    	buffer.append(WechatUtil.IMGSRC+strServerId[i]+".jpg");
//		}
		 
		 //wechatDataAudit.setImgNames(buffer.toString());
		 wechatDataAuditService.insert(wechatDataAudit);
		 return new InvokeResult().returnSuccess("成功");
		 //Map map = new HashMap<>();
		 //map.put("sum", x);
		 //map.put("srcs", buffer.toString());
		//return new InvokeResult().returnSuccess(map);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/jsGetwejs")
	public Map<String,String> jsGetwejs(String url){
		Long timestamp = new Date().getTime()/1000;
		log.info("url--------------->"+url);
		log.info("timestamp--------------->"+timestamp);
		String signature = SignUtil.getSignature(timestamp.toString(),url);
		Map map = new HashMap(); 
		map.put("timestamp", timestamp);
		map.put("url", url);
		map.put("nonceStr", SignUtil.token);
		map.put("signature", signature);
		map.put("wxid", WechatUtil.FWAPPID);
		return map;
	}
	
	@RequestMapping(value = "/getwejs")
	public void getwejs(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String url = request.getParameter("url");
		Long timestamp = new Date().getTime()/1000;
		log.info("url--------------->"+url);
		log.info("timestamp--------------->"+timestamp);
		String signature = SignUtil.getSignature(timestamp.toString(),url);
		Map map = new HashMap(); 
		map.put("timestamp", timestamp);
		map.put("url", url);
		map.put("nonceStr", SignUtil.token);
		map.put("signature", signature);
		map.put("wxid", WechatUtil.FWAPPID);
		PrintWriter out = response.getWriter(); 
		JsonBuilder jsonBuilder = new JsonBuilder();
		
		out.print(jsonBuilder.toJson(map));
		out.close();  
        out = null;
	}
	
	
	
	public void download(String urlString, String filename,String savePath) throws Exception {  
        // 构造URL  
        URL url = new URL(urlString);  
        // 打开连接  
        URLConnection con = url.openConnection();  
        //设置请求超时为5s  
        con.setConnectTimeout(5*1000);  
        // 输入流  
        InputStream is = con.getInputStream();  
      
        // 1K的数据缓冲  
        byte[] bs = new byte[1024];  
        // 读取到的数据长度  
        int len;  
        // 输出的文件流  
       File sf=new File(savePath);  
       if(!sf.exists()){  
           sf.mkdirs();  
       }  
       OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);  
        // 开始读取  
        while ((len = is.read(bs)) != -1) {  
          os.write(bs, 0, len);  
        }  
        // 完毕，关闭所有链接  
        os.close();  
        is.close();  
    }   
}
