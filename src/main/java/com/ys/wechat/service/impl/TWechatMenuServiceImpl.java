package com.ys.wechat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.dao.TWechatMenuMapper;
import com.ys.wechat.model.TWechatMenu;
import com.ys.wechat.service.TWechatMenuService;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自定义菜单-ServiceImpl
 *
 * @author 吕志博
 * @date 2016-3-10 上午11:37:33
 * @version V1.0
 */
@Service
public class TWechatMenuServiceImpl implements TWechatMenuService{
	@Autowired
	private TWechatMenuMapper wechatMenuMapper;
	
	@Override
	public int insert(TWechatMenu record) {
		record.setCreateDate(new Date());
		return wechatMenuMapper.insert(record);
	}

	@Override
	public int deleteById(Integer id) {
		return id==null?0:wechatMenuMapper.deleteById(id);
	}

	@Override
	public TWechatMenu updateById(TWechatMenu wechatMenu) {
		wechatMenu.setUpdateDate(new Date());
		return wechatMenu.getId()==null?null:wechatMenuMapper.updateByPrimaryKey(wechatMenu)>0?wechatMenu:null;
	}

	@Override
	public List<TWechatMenu> selectByFid(Integer fid) {
		
		return wechatMenuMapper.selectByFid(fid==null?0:fid);
	}

	@Override
	public TWechatMenu selectById(Integer id) {
		return wechatMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TWechatMenu> selectAll() {
		List<TWechatMenu> list = selectByFid(null);
		for (int i = 0; i < list.size(); i++) {
			List<TWechatMenu> menus = selectByFid(list.get(i).getId());
			list.get(i).setMenus(menus);
		}
		return list;
	}

}
