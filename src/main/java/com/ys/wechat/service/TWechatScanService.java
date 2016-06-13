package com.ys.wechat.service;

import com.ys.wechat.model.TWechatScan;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信扫码
 *
 * @author 吕志博
 * @date 2016-3-31 上午10:50:56
 * @version V1.0
 */
public interface TWechatScanService {
	/**
	 * 
	 * @Description:新增
	 *
	 * @author 吕志博
	 * @date 2016-3-31 上午10:53:30
	 * @version V1.0
	 * @param tWechatScan
	 * @return
	 */
	boolean addTWechatScan(String uid);
	
	/**
	 * 
	 * @Description:修改
	 *
	 * @author 吕志博
	 * @date 2016-3-31 上午10:55:09
	 * @version V1.0
	 * @param tWechatScan
	 * @return
	 */
	boolean updateByUid(TWechatScan tWechatScan);
	
	/**
	 * 
	 * @Description:根据uid查询
	 *
	 * @author 吕志博
	 * @date 2016-3-31 上午10:55:44
	 * @version V1.0
	 * @param uid
	 * @return
	 */
	TWechatScan getTWechatScan(String uid);
}
