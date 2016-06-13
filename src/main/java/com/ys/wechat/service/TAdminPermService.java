package com.ys.wechat.service;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台管理员权限-Service
 *
 * @author 吕志博
 * @date 2016-3-21 下午3:24:46
 * @version V1.0
 */
public interface TAdminPermService {
	/**
	 * 
	 * @Description:保存用户的菜单权限,做全量更新操作<br>
	 * 					需先删除该用户之前的菜单权限,然后插入当前菜单权限
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午3:22:26
	 * @version V1.0
	 * @param adminId 管理员编号
	 * @param menuIds 多个菜单权限使用逗号(,)分隔
	 * @return
	 */
	boolean savePermessions(Integer adminId, String menuIds);
}
