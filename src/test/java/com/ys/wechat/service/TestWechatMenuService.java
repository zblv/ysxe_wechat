package com.ys.wechat.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.model.TWechatMenu;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自定义菜单-junit
 *
 * @author 吕志博
 * @date 2016-3-10 下午4:37:54
 * @version V1.0
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath*:application*.xml"})
public class TestWechatMenuService {
	@Autowired
	private TWechatMenuService wechatMenuService;
	
	@Test
	public void insert() {
		TWechatMenu wechatMenu = new TWechatMenu();
		wechatMenu.setName("测试按钮");
		wechatMenu.setType(Constants.MENU_TYPE_CLICK);
		wechatMenu.setKeyword("csan");
		wechatMenu.setFid(2);
		wechatMenu.setSort(3);
		System.out.println(wechatMenuService.insert(wechatMenu));
	}

	@Test
	public void deleteById() {
		
	}

	@Test
	public void updateById() {
		
	}

	@Test
	public void selectByFid() {
		System.out.println("------------------->"+wechatMenuService.selectByFid(1));
	}
	
	@Test
	public void selectByFidNull() {
		System.out.println("------------------->"+wechatMenuService.selectByFid(null).size());
	}
}
