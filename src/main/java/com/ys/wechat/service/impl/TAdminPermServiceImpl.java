package com.ys.wechat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.dao.TAdminPermMapper;
import com.ys.wechat.model.TAdminPerm;
import com.ys.wechat.service.TAdminPermService;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台管理员权限-ServiceImpl
 *
 * @author 吕志博
 * @date 2016-3-21 下午3:24:46
 * @version V1.0
 */
@Service
public class TAdminPermServiceImpl implements TAdminPermService{
	@Autowired
	private TAdminPermMapper adminPermMapper;
	
	@Override
	public boolean savePermessions(Integer adminId, String menuIds) {
		if (StringUtils.isNotBlank(menuIds)) {
			adminPermMapper.deleteByAdminId(adminId);
			String[] strMenuIds = menuIds.split(",");
			List<TAdminPerm> list = new ArrayList<>();
			Date date = new Date();
			for (String menuId : strMenuIds) {
				TAdminPerm adminPerm = new TAdminPerm(); 
				adminPerm.setCreateDate(date);
				adminPerm.setMenuId(Integer.parseInt(menuId));
				adminPerm.setAdminId(adminId);
				list.add(adminPerm);
			}
			adminPermMapper.inserts(list);
			return true;
		}
		return false;
	}

}
