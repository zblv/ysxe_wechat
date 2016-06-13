package com.ys.wechat.controller.intercepor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.model.TSysAdmin;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:登陆拦截
 *
 * @author 吕志博
 * @date 2016-5-11 下午4:11:05
 * @version V1.0
 */
public class LoginInterceptor implements HandlerInterceptor  {
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		MDC.put("req", request);
		HttpSession session = request.getSession();
		TSysAdmin user = (TSysAdmin)session.getAttribute(Constants.CURRENT_USER);
		//未登录
		if(user==null){
			 if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
	                response.setContentType("text/html;charset=utf-8");
	                PrintWriter out = response.getWriter();
	                JSONObject jsonObject = new JSONObject();
	                jsonObject.put("invalidSession", true);
	                jsonObject.put("loginUrl", request.getContextPath()+"/login");
	                out.print(jsonObject);
	                return false;
	            }else{
	            	String loginUrl = request.getContextPath()+"/login";
	            	response.sendRedirect(loginUrl);
	            	return false;
	            }
		}
		return true;
	}
}
