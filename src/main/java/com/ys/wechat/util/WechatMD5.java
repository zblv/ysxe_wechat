package com.ys.wechat.util;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:功能：MD5签名处理核心文件，不需要修改
 *
 * @author 吕志博
 * @date 2016-5-19 下午1:57:20
 * @version V1.0
 */

public class WechatMD5 {
	private static Logger log = LoggerFactory.getLogger(WechatMD5.class);
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text,String input_charset) {
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
    
    public static void main(String[] args) {
    	String key = "e825a0a60757d5b34f0c6fd3add6222";
    	String text = "p2p"+"zhanggy"+"103E702E0737327C";
    	String sign = "d1c5a3b5c5eb17ea502fa09461c9fa38";
    	
		System.out.println("签名前："+text+key+"，签名后："+sign(text+key, "utf-8")+"----"+sign(text+key, "utf-8").equals("d1c5a3b5c5eb17ea502fa09461c9fa38"));
		System.out.println("比较："+verify(text,sign,key,"utf-8"));
    }    
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	//LogUtil.APP.info("数据签名前【明文】："+text);
    	System.out.println("数据签名前【明文】："+text);
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	System.out.println("数据签名后【密文】："+mysign);
//    	LogUtil.APP.info("数据签名后【密文】："+mysign);
    	System.out.println("接收数据【密文】："+sign);
//    	LogUtil.APP.info("接收数据【密文】："+sign);
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (Exception e) {
        	log.info("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        	return null;
        }
    }

}