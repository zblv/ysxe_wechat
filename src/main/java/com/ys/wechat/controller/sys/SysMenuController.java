package com.ys.wechat.controller.sys;

import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.InvokeResult;
import com.ys.wechat.model.MenuVo;
import com.ys.wechat.service.TAdminPermService;
import com.ys.wechat.service.TSysMenuService;
import com.ys.wechat.util.WechatUtil;



/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:后台菜单
 *
 * @author 吕志博
 * @date 2016-4-5 下午2:45:43
 * @version V1.0
 */
@Controller
@RequestMapping(value="/system")
public class SysMenuController extends BaseController {
	private static Logger log = Logger.getLogger(SysMenuController.class.getName());
	@Autowired
	private TSysMenuService tSysMenuService;
	
	@Autowired
	private TAdminPermService adminPermService;
	
	@RequestMapping(value="/init")
	public String init(){
		if(getCurrUser() == null){
			return "redirect:/login";
		}
		List<MenuVo> menus = null;
		
		menus = tSysMenuService.getByAdminId(getCurrUser().getId());
		session.setAttribute("menus", menus);
		return "system/init";
	}
	
	@RequestMapping(value="/index")
	public String index(){
		List<MenuVo> menus = tSysMenuService.getByAdminId(getCurrUser().getId());
		session.setAttribute("menus", menus);
		return "system/index";
	}
	
	
	
	@RequestMapping(value = "/admin/getPermForDiv")
	@ResponseBody
	public InvokeResult getUserPerm(Integer adminId){
		List<MenuVo> permissions = tSysMenuService.getPermForDiv(getCurrUser().getId(), adminId);
		return InvokeResult.returnSuccess(permissions);
	}
	
	@RequestMapping(value = "/admin/savePermessions")
	@ResponseBody
	public InvokeResult savePermessions(Integer adminId, String menuIds){
		log.info(getCurrUser().getUserName()+"---->进行管理员权限更改："+adminId);
		if(adminPermService.savePermessions(adminId, menuIds)){
			return InvokeResult.returnSuccess("操作成功!");
		}
		return InvokeResult.returnError("操作失败!");
	}
	
	/**网页授权链接生成*/
	@RequestMapping(value = "/getloginUrl")
	@ResponseBody
	public InvokeResult savePermessions(String newsLink){
		return InvokeResult.returnSuccess(WechatUtil.WECHATAUTHORIZEURL+"&redirect_uri="+URLEncoder.encode(newsLink)+"&response_type=code&scope=snsapi_base&state=ysmdl#wechat_redirect");
	}
	
}
