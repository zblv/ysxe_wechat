package com.ys.wechat.controller.sys;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.controller.common.InvokeResult;
import com.ys.wechat.model.TSysAdmin;
import com.ys.wechat.service.TSysAdminService;
import com.ys.wechat.util.MD5;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:后台管理员
 *
 * @author 吕志博
 * @date 2016-3-15 上午9:36:51
 * @version V1.0
 */
@Controller
@Scope("prototype")
public class SysAdminController extends BaseController{
	private static Logger log = Logger.getLogger(SysAdminController.class.getName());
	
	@Autowired
	private TSysAdminService adminService;

	/**去登录界面*/
	@RequestMapping(value = "/login")
	public String toLogin(){
		return "member/login";
	}
	
	/**登录操作*/
	@RequestMapping(value = "/userLogin")
	@ResponseBody
	public InvokeResult userLogin(String userName,String password){
		if (StringUtils.isBlank(userName)) {
			return InvokeResult.returnError("请填写用户名");
		}
		if (StringUtils.isBlank(password)) {
			return InvokeResult.returnError("请填写密码");
		}
		TSysAdmin admin = adminService.userLogin(userName,MD5.encrypt(password));
		if (admin == null) {
			return InvokeResult.returnError("用户名或密码错误");
		}
		session.setAttribute(Constants.CURRENT_USER, admin);
		log.info(admin.getUserName()+"---->登陆成功");
		return InvokeResult.returnSuccess("登录成功");
	}
	
	/**退出登录操作*/
	@RequestMapping(value="logout")
	public String logout(){
		log.info(getCurrUser().getUserName()+"---->退出登陆");
		session.removeAttribute(Constants.CURRENT_USER);
		session.invalidate();
		return "redirect:/login";
	}
	
	/**去用户管理*/
	@RequestMapping(value = "/system/admin/init")
	public String init(){
		List<TSysAdmin> admins = adminService.getByConditons(new TSysAdmin());
		request.setAttribute("admins", admins);
		return "member/user_edit";
	}
	
	/** 禁用用户或启用*/
	@RequestMapping(value = "/system/admin/delOrOpenAdmin")
	@ResponseBody
	public InvokeResult delorOpenAdmin(Integer id,String status){
		log.info(getCurrUser().getUserName()+"---->修改管理员："+id+"状态");
		if (adminService.closeOrOpenById(id,status)) {
			return InvokeResult.returnSuccess("操作成功");
		}else {
			return InvokeResult.returnError("操作失败");
		}
	}
	
	/** 添加或修改用户*/
	@RequestMapping(value = "/system/admin/addOrUpdateAdmin")
	@ResponseBody
	public InvokeResult addOrUpdateAdmin(TSysAdmin admin){
		if (StringUtils.isBlank(admin.getUserName())) {
			return InvokeResult.returnError("用户名必填");
		}
		if (admin.getId() != null) {
			log.info(getCurrUser().getUserName()+"---->修改管理员："+admin.getUserName());
			adminService.modifyAdmin(admin);
		}else {
			log.info(getCurrUser().getUserName()+"---->新增管理员："+admin.getUserName());
			if (StringUtils.isBlank(admin.getPassword())) {
				return InvokeResult.returnError("请填写登录密码");
			}
			adminService.add(admin);
		}
		return InvokeResult.returnSuccess("操作成功");
	}
}
