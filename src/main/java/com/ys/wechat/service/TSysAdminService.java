package com.ys.wechat.service;

import java.util.List;

import com.ys.wechat.model.TSysAdmin;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台管理员-Service
 *
 * @author 吕志博
 * @date 2016-3-21 下午3:46:10
 * @version V1.0
 */
public interface TSysAdminService {
	/**
	 * 
	 * @Description:添加管理员
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:43:05
	 * @version V1.0
	 * @param admin
	 * @return
	 */
	TSysAdmin add(TSysAdmin admin);
	
	/**
	 * 
	 * @Description:管理员登录
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:43:41
	 * @version V1.0
	 * @param admin
	 * @return
	 */
	TSysAdmin userLogin(String userName,String password);
	
	/**
	 * 
	 * @Description:根据主键ID查询
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:43:56
	 * @version V1.0
	 * @param id
	 * @return
	 */
	TSysAdmin getById(Integer id);
	
	/**
	 * 
	 * @Description:根据主键ID禁用用户或启用管理员
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:44:28
	 * @version V1.0
	 * @param id
	 * @param status
	 * @return
	 */
	boolean closeOrOpenById(Integer id,String status);
	
	/**
	 * 
	 * @Description:根据条件查询管理员
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:44:59
	 * @version V1.0
	 * @param admin
	 * @return
	 */
	List<TSysAdmin> getByConditons(TSysAdmin admin);
	
	/**
	 * 
	 * @Description:修改管理员信息
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:45:43
	 * @version V1.0
	 * @param admin
	 * @return
	 */
	boolean modifyAdmin(TSysAdmin admin);
}
