package com.ys.wechat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ys.wechat.model.TAdminPerm;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台管理员权限-DAO
 *
 * @author 吕志博
 * @date 2016-3-21 下午2:36:13
 * @version V1.0
 */

public interface TAdminPermMapper {
	/**
	 * 
	 * @Description:删除
	 *
	 * @author 吕志博
	 * @date 2016-3-21 下午2:49:38
	 * @version V1.0
	 * @param id
	 * @return
	 */
    int deleteByAdminId(Integer adminId);
    
    /**
     * 
     * @Description:批量添加
     *
     * @author 吕志博
     * @date 2016-3-21 下午2:46:36
     * @version V1.0
     * @param records
     * @return
     */
    int inserts(@Param("records")List<TAdminPerm> records);
}