package com.ys.wechat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.dao.TWechatDataAuditMapper;
import com.ys.wechat.model.TWechatDataAudit;
import com.ys.wechat.service.TWechatDataAuditService;

@Service
public class TWechatDataAuditServiceImpl implements TWechatDataAuditService{

	@Autowired
	private TWechatDataAuditMapper wechatDataAuditMapper;
	
	@Override
	public boolean deleteByPrimaryKey(Long id) {
		return wechatDataAuditMapper.deleteByPrimaryKey(id)>0?true:false;
	}

	@Override
	public TWechatDataAudit insert(TWechatDataAudit record) {
		record.setCreateDate(new Date());
		record.setState("audit");
		return wechatDataAuditMapper.insert(record)>0?record:null;
	}

	@Override
	public TWechatDataAudit selectByPrimaryKey(Long id) {
		return wechatDataAuditMapper.selectByPrimaryKey(id);
	}

	@Override
	public TWechatDataAudit updateByPrimaryKey(TWechatDataAudit record) {
		record.setUpdateDate(new Date());
		wechatDataAuditMapper.updateByPrimaryKey(record);
		return record;
	}

	@Override
	public List<TWechatDataAudit> selectAll(String state) {
		return wechatDataAuditMapper.selectAll(state);
	}

	@Override
	public boolean delById(Long id) {
		return wechatDataAuditMapper.delById(id)>0?true:false;
	}

}
