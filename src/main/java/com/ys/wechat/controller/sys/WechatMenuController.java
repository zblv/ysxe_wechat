package com.ys.wechat.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.InvokeResult;
import com.ys.wechat.model.TWechatMenu;
import com.ys.wechat.model.pojo.CommonButton;
import com.ys.wechat.model.pojo.ComplexButton;
import com.ys.wechat.model.pojo.Menu;
import com.ys.wechat.service.TWechatMenuService;
import com.ys.wechat.util.WeixinUtil;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:后台微信自定义菜单
 *
 * @author 吕志博
 * @date 2016-4-5 下午2:46:12
 * @version V1.0
 */
@Controller
@RequestMapping(value="/system/wechatmenu")
public class WechatMenuController extends BaseController {
	private static Logger log = Logger.getLogger(WechatMenuController.class.getName());
	
	@Autowired
	private TWechatMenuService wechatMenuService;
	
	/**去自定义菜单管理*/
	@RequestMapping(value = "/init")
	public String init(){
		List<TWechatMenu> menus = wechatMenuService.selectAll();
		for (int i = 0; i < menus.size(); i++) {
			request.setAttribute("menu"+i, menus.get(i));
		}
		request.setAttribute("menus",menus);
		return "menu/wechat_menu_edit";
	}	
	
	/** 添加或修改菜单*/
	@RequestMapping(value = "/addOrUpdateMenu")
	@ResponseBody
	public InvokeResult addOrUpdateAdmin(TWechatMenu menu){
		if (StringUtils.isBlank(menu.getName())) {
			return InvokeResult.returnError("菜单名称必填");
		} else if(menu.getName().length()>6){
			return InvokeResult.returnError("菜单名称过长");
		}
		int num = wechatMenuService.selectByFid(menu.getFid()).size();
		if ("click".equals(menu.getType())) {
			if (StringUtils.isBlank(menu.getKeyword())) {
				return InvokeResult.returnError("请填写自动回复关键词");
			}
		}else if ("view".equals(menu.getType())) {
			if (StringUtils.isBlank(menu.getUrl())) {
				return InvokeResult.returnError("请填写链接地址");
			}
		}
		if (menu.getId() != null) {
			log.info(getCurrUser().getUserName()+"---->修改自定义菜单：");
			wechatMenuService.updateById(menu);
		}else {
			if (menu.getFid() != null && menu.getFid()>0) {
				if (num>=5) {
					return InvokeResult.returnError("每个一级菜单下最多五个二级菜单");
				}
			}else {
				if (num>=3) {
					return InvokeResult.returnError("最多三个一级菜单");
				}
			}
			log.info(getCurrUser().getUserName()+"---->新增自定义菜单");
			
			wechatMenuService.insert(menu);
		}
		return InvokeResult.returnSuccess("操作成功");
	}
	
	/**微信服务号自定义菜单发布*/
	@RequestMapping(value = "/release")
	@ResponseBody
	public InvokeResult release(){
		List<TWechatMenu> menus = wechatMenuService.selectAll();
		Map menu = new HashMap();
		Object[] btns= new Object[menus.size()];
		for (int i = 0; i < menus.size(); i++) {
			if ("f".equals(menus.get(i).getType())) {
				ComplexButton mainBtn = new ComplexButton();
				mainBtn.setName(menus.get(i).getName());
				CommonButton[] btns1= new CommonButton[menus.get(i).getMenus().size()];
				int x= 0;
				for (TWechatMenu wechatMenu : menus.get(i).getMenus()) {
					CommonButton btn = new CommonButton();
					btn.setName(wechatMenu.getName());
					btn.setType(wechatMenu.getType());
					if ("click".equals(wechatMenu.getType())) {
						btn.setKey(wechatMenu.getKeyword());
					} else if ("view".equals(wechatMenu.getType())) {
						btn.setUrl(wechatMenu.getUrl());
					}
					btns1[x] = btn;
					x++;
				}
				mainBtn.setSub_button(btns1);
				btns[i] = mainBtn;
			}else {
				TWechatMenu wechatMenu = menus.get(i);
				CommonButton btn = new CommonButton();
				btn.setName(wechatMenu.getName());
				btn.setType(wechatMenu.getType());
				if ("click".equals(wechatMenu.getType())) {
					btn.setKey(wechatMenu.getKeyword());
				} else if ("view".equals(wechatMenu.getType())) {
					btn.setUrl(wechatMenu.getUrl());
				}
				btns[i] = btn;
			}
		}
		menu.put("button", btns);
		int result4 = WeixinUtil.pushWechat(menu ,WeixinUtil.PUSH_TYPE_CREATEMENU);
		if (0 == result4)  {
          log.info("成功！");
          return InvokeResult.returnSuccess("操作成功");
		}else  
          log.info("失败，错误码：" + result4);  
		return InvokeResult.returnError("自定义菜单发布失败-->"+result4);
	}
	
	
}
