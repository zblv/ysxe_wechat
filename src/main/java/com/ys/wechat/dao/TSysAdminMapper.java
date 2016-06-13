package com.ys.wechat.dao;

import java.util.List;

import com.ys.wechat.model.TSysAdmin;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-后台管理员-DAO
 *
 * @author 吕志博
 * @date 2016-3-21 下午2:36:47
 * @version V1.0
 */
public interface TSysAdminMapper {

    int insert(TSysAdmin record);

    TSysAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TSysAdmin record);
    
    /**
     * 
     * @Description:查询用户
     *
     * @author 吕志博
     * @date 2016-3-21 下午3:12:50
     * @version V1.0
     * @param record
     * @return
     */
    List<TSysAdmin> selectBy(TSysAdmin record);
    
    /**
     * 
     * @Description:登陆
     *
     * @author 吕志博
     * @date 2016-3-21 下午3:09:06
     * @version V1.0
     * @param record
     * @return
     */
    TSysAdmin adminLogin(TSysAdmin record);
}