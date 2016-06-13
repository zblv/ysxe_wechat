package com.ys.wechat.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.wechat.dao.TWechatScanMapper;
import com.ys.wechat.model.TWechatScan;
import com.ys.wechat.service.TWechatScanService;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信扫码
 *
 * @author 吕志博
 * @date 2016-3-31 上午10:59:09
 * @version V1.0
 */
@Service
public class TWechatScanServiceImpl implements TWechatScanService{
	@Autowired
	private TWechatScanMapper wechatScanMapper;
	
	@Override
	public boolean addTWechatScan(String uid) {
		TWechatScan wechatScan = new TWechatScan();
		wechatScan.setUid(uid);
		wechatScan.setStatus("0");
		wechatScan.setCreateDate(new Date());
		return wechatScanMapper.insert(wechatScan)>0?true:false;
	}

	@Override
	public boolean updateByUid(TWechatScan tWechatScan) {
		return wechatScanMapper.updateByUid(tWechatScan)>0?true:false;
	}
	

	@Override
	public TWechatScan getTWechatScan(String uid) {
		return wechatScanMapper.selectByUid(uid);
	}

}
