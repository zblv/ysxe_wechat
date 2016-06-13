package com.ys.wechat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.dao.TSysMenuMapper;
import com.ys.wechat.model.MenuVo;
import com.ys.wechat.model.TSysMenu;
import com.ys.wechat.service.TSysMenuService;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台系统菜单-ServiceImpl
 *
 * @author 吕志博
 * @date 2016-3-21 下午3:49:07
 * @version V1.0
 */
@Service
public class TSysMenuServiceImpl implements TSysMenuService{
	@Autowired
	private TSysMenuMapper menuMapper;
	
	@Override
	public List<MenuVo> selectMenusByFid(Integer fid) {
		return processToMenuVo(menuMapper.selectMenusByFid(fid));
	}

	@Override
	public List<MenuVo> selectMenuAll() {
		return processToMenuVoWithLevel(menuMapper.selectMenuAll());
	}

	@Override
	public List<MenuVo> getByAdminId(Integer adminId) {
		return processToMenuVoWithLevel(menuMapper.getByAdminId(adminId));
	}
	private List<MenuVo> processToMenuVoWithLevel(List<TSysMenu> menus){
		return processToMenuVoWithLevel(menus, null);
	}
	private List<MenuVo> processToMenuVoWithLevel(List<TSysMenu> menus, List<Integer> checked){
		List<MenuVo> menuVos = new ArrayList<>();
		if(menus == null || menus.isEmpty()){
			return menuVos;
		}
		Map<Integer, MenuVo> menuData = new HashMap<Integer, MenuVo>();
		MenuVo currMenuVo = null;
		for(TSysMenu curr:menus){
			Integer fid = curr.getFid();
			Integer id = curr.getId();
			currMenuVo = processToMenuVo(curr);
			if(checked != null && checked.contains(id)){
				currMenuVo.setChecked(true);
			}
			if(menuData.get(id) != null){
				currMenuVo.getSubMenuVos().addAll(menuData.get(id).getSubMenuVos());
			}
			menuData.put(id, currMenuVo);
			if(fid == null){
				menuVos.add(currMenuVo);
			}else{
				MenuVo fmenu = menuData.get(fid);
				if(fmenu == null){
					fmenu = new MenuVo();
					fmenu.setId(fid);
				}
				fmenu.getSubMenuVos().add(currMenuVo);
			}
		}
		return menuVos;
	}
	
	private MenuVo processToMenuVo(TSysMenu menu){
		if (menu==null) 
			return null;
		MenuVo menuVo = new MenuVo();
		BeanUtils.copyProperties(menu, menuVo);
		return menuVo;
	}
	
	private List<MenuVo> processToMenuVo(List<TSysMenu> menus){
		List<MenuVo> menuVos = new ArrayList<>();
		if (menus !=null && menus.size()>0) {
			for (TSysMenu menu : menus) {
				menuVos.add(processToMenuVo(menu));
			}
		}
		return menuVos;
	}

	@Override
	public List<MenuVo> getPermForDiv(Integer id, Integer adminId) {
		List<TSysMenu> menus = null;
		menus = menuMapper.getByAdminId(id);
		List<TSysMenu> adminMenus = menuMapper.getByAdminId(adminId);
		List<Integer> ids = new ArrayList<>();
		for (TSysMenu menu : adminMenus) {
			ids.add(menu.getId());
		}
		return processToMenuVoWithLevel(menus, ids);
	}
}
