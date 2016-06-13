package com.ys.wechat.service;

import java.util.List;

import com.ys.wechat.model.MenuVo;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台系统菜单-Service
 *
 * @author 吕志博
 * @date 2016-3-21 下午3:49:07
 * @version V1.0
 */
public interface TSysMenuService {
	/**
	 * 
	 * @Description:根据父级菜单查询子菜单 如传null 为查询所有一级菜单
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午2:57:42
	 * @version V1.0
	 * @param fid
	 * @return
	 */
	List<MenuVo> selectMenusByFid(Integer fid);
    
	/**
	 * 
	 * @Description:查询所有菜单
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午2:57:54
	 * @version V1.0
	 * @return
	 */
    List<MenuVo> selectMenuAll();
    
    /**
     * 
     * @Description:查询用户菜单权限
     *
     * @author 吕志博
     * @date 2016-3-21 下午2:58:05
     * @version V1.0
     * @param userId
     * @return
     */
    List<MenuVo> getByAdminId(Integer adminId);
    
    /**
     * 
     * @Description:根据当前用户的菜单权限给某个用户分配权限
	 * 				此用户最多权限为分配权限的此用户的所有权限
     *
     * @author 吕志博
     * @date 2016-3-22 下午2:03:32
     * @version V1.0
     * @param id 当前管理员id
     * @param adminId 被设定权限的管理员ID
     * @return
     */
	List<MenuVo> getPermForDiv(Integer id, Integer adminId);
}
