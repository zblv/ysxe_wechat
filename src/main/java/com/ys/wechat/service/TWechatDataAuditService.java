package com.ys.wechat.service;

import java.util.List;

import com.ys.wechat.model.TWechatDataAudit;

public interface TWechatDataAuditService {
	boolean deleteByPrimaryKey(Long id);
	
	/**
	 * 
	 * @Description:永久删除
	 *
	 * @author 吕志博
	 * @date 2016-5-30 下午2:28:49
	 * @version V1.0
	 * @param id
	 * @return
	 */
	boolean delById(Long id);

	TWechatDataAudit insert(TWechatDataAudit record);

    TWechatDataAudit selectByPrimaryKey(Long id);

    TWechatDataAudit updateByPrimaryKey(TWechatDataAudit record);
    
    List<TWechatDataAudit> selectAll(String state);
}
