package com.ys.wechat.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.dao.TSysAdminMapper;
import com.ys.wechat.model.TSysAdmin;
import com.ys.wechat.service.TSysAdminService;
import com.ys.wechat.util.MD5;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台管理员-ServiceImpl
 *
 * @author 吕志博
 * @date 2016-3-21 下午3:46:10
 * @version V1.0
 */
@Service
public class TSysAdminServiceImpl implements TSysAdminService{
	@Autowired
	private TSysAdminMapper adminMapper;
	
	@Override
	public TSysAdmin add(TSysAdmin admin) {
		TSysAdmin user2 = new TSysAdmin();
		user2.setUserName(admin.getUserName());
		//判断用户名是否被使用
		if (adminMapper.selectBy(user2).size()>0)
			return null;
		admin.setCreateDate(new Date());
		admin.setPassword(MD5.encrypt(admin.getPassword()));
		adminMapper.insert(admin);
		return admin;
	}

	@Override
	public TSysAdmin userLogin(String userName,String password) {
		TSysAdmin admin = new TSysAdmin();
		admin.setUserName(userName);
		admin.setMobilePhone(userName);
		admin.setPassword(password);
		return adminMapper.adminLogin(admin);
	}

	@Override
	public TSysAdmin getById(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean closeOrOpenById(Integer id, String status) {
		TSysAdmin admin = adminMapper.selectByPrimaryKey(id);
		if (admin != null){
			admin.setStatus(status);
			admin.setUpdateDate(new Date());
			adminMapper.updateByPrimaryKey(admin);
			return true;
		}
		return false;
	}

	@Override
	public List<TSysAdmin> getByConditons(TSysAdmin admin) {
		return adminMapper.selectBy(admin);
	}

	@Override
	public boolean modifyAdmin(TSysAdmin admin) {
		admin.setUpdateDate(new Date());
		if(StringUtils.isNotBlank(admin.getPassword()))
			admin.setPassword(MD5.encrypt(admin.getPassword()));
		adminMapper.updateByPrimaryKey(admin);
		return true;
	}

}
