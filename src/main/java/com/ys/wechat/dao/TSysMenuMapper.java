package com.ys.wechat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ys.wechat.model.TSysMenu;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台菜单-DAO
 *
 * @author 吕志博
 * @date 2016-3-21 下午2:36:56
 * @version V1.0
 */
public interface TSysMenuMapper {
	
	
	
	
	/**
	 * 
	 * @Description:根据父级ID查询菜单
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午2:57:42
	 * @version V1.0
	 * @param fid
	 * @return
	 */
	List<TSysMenu> selectMenusByFid(@Param("fid")Integer fid);
    
	/**
	 * 
	 * @Description:查询所有菜单
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午2:57:54
	 * @version V1.0
	 * @return
	 */
    List<TSysMenu> selectMenuAll();
    
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
    List<TSysMenu> getByAdminId(Integer adminId);
}