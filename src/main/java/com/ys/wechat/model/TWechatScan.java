package com.ys.wechat.model;

import java.util.Date;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信扫码
 *
 * @author 吕志博
 * @date 2016-3-31 上午10:25:36
 * @version V1.0
 */
public class TWechatScan {
    private Long id;//主键编号

    private String uid;//扫码唯一标识

    private String status;//状态（0：初始创建，200:已扫码，400：已确认，500：已超时）

    private Integer wechatUserId;//扫码微信用户信息编号

    private Date createDate;//二维码创建时间

    private Date scanDate;//用户扫码时间

    private Date endDate;//造作结束时间（超时或已确认登陆）时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getWechatUserId() {
        return wechatUserId;
    }

    public void setWechatUserId(Integer wechatUserId) {
        this.wechatUserId = wechatUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getScanDate() {
        return scanDate;
    }

    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}