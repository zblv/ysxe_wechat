package com.ys.wechat.controller.wechat;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ys.wechat.controller.base.BaseController;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:接收模板消息推送接口
 *
 * @author 吕志博
 * 
 * @date 2016-3-15 上午9:36:51
 * 
 * 
 * @version V1.0
 */
@Controller
@Scope("prototype")//singleton
public class TemController extends BaseController {
	private static Logger log = Logger.getLogger(TemController.class.getName());
	
	@RequestMapping(
            value="/tem_pust",
            method = RequestMethod.POST
    )
	public static void temPusts(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}
}
