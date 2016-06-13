package com.ys.wechat.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-模型-菜单
 *
 * @author 吕志博
 * @date 2016-3-10 下午5:02:56
 * @version V1.0
 */
public class TWechatMenu {
    private Integer id;//编号

    private String name;//菜单标题，不超过16个字节

    private String type;//菜单的响应动作类型

    private String url;//网页链接，用户点击菜单可打开链接，不超过128字节

    private String keyword;//菜单KEY值，用于消息接口推送，不超过64字节

    private Integer fid;//父级菜单ID

    private Integer sort;//排序

    private String isdel;//是否删除(y/n)

    private Date createDate;//创建时间

    private Date updateDate;//修改时间
    
    private List<TWechatMenu> menus;//子菜单
    
    
    public List<TWechatMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<TWechatMenu> menus) {
		this.menus = menus;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}