package com.ys.wechat.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:HTTP请求发送
 *
 * @author 吕志博
 * @date 2016-3-15 下午3:41:50
 * @version V1.0
 */
public class HttpRequest {  
 
    /** 
     * 发送HttpPost请求 
     *  
     * @param strURL 
     *            服务地址 
     * @param Map
     * @return 成功:返回json字符串<br/> 
     */  
	public static String httpPost(String url, Map<String, String> params) {

		URL u = null;

		HttpURLConnection con = null;

		// 构建请求参数

		StringBuffer sb = new StringBuffer();

		if (params != null) {

			for (Entry<String, String> e : params.entrySet()) {

				sb.append(e.getKey());

				sb.append("=");

				sb.append(e.getValue());

				sb.append("&");

			}

			sb.substring(0, sb.length() - 1);

		}

		// 尝试发送请求

		try {

			u = new URL(url);

			con = (HttpURLConnection) u.openConnection();

			con.setRequestMethod("POST");

			con.setDoOutput(true);

			con.setDoInput(true);

			con.setUseCaches(false);

			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			OutputStreamWriter osw = new OutputStreamWriter(
					con.getOutputStream(), "UTF-8");

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

		// 读取返回内容

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
}  