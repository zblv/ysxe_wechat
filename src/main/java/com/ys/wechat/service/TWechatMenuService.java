package com.ys.wechat.service;

import java.util.List;

import com.ys.wechat.model.TWechatMenu;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-自定义菜单-Service
 * @author 吕志博
 * @date 2016-3-10 上午11:23:43
 * @version V1.0
 */
public interface TWechatMenuService {
	/**
     * 
     * @Description:添加菜单
     *
     * @author 吕志博
     * @date 2016-3-10 上午11:32:23
     * @version V1.0
     * @param record
     * @return 1:成功,0:失败
     */
    int insert(TWechatMenu record);
    
    /**
     * 
     * @Description:删除菜单
     *
     * @author 吕志博
     * @date 2016-3-10 上午11:15:39
     * @version V1.0
     * @param id 删除该ID的菜单及所属的所有子菜单
     * @return >0：成功,<1该菜单不存在
     */
    int deleteById(Integer id);
    
    /**
     * 
     * @Description:修改菜单
     *
     * @author 吕志博
     * @date 2016-3-10 上午11:25:32
     * @version V1.0
     * @param wechatMenu 根据ID修改其所有信息
     * @return 返回null则修改失败
     */
    TWechatMenu updateById(TWechatMenu wechatMenu);
    
    /**
     * 
     * @Description:查询菜单集合
     *
     * @author 吕志博
     * @date 2016-3-10 上午11:05:29
     * @version V1.0
     * @param fid 父级ID <br>
     * 				null:查询所有一级菜单
     *                >0:查询该菜单下的所有子菜单
     * @return List<TWechatMenu>
     */
    List<TWechatMenu> selectByFid(Integer fid);
    
    List<TWechatMenu> selectAll();
    
    TWechatMenu selectById(Integer id);
}
