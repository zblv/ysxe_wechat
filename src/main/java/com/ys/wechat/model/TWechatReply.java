package com.ys.wechat.model;

import java.util.Date;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-模型-消息回复
 *
 * @author 吕志博
 * @date 2016-3-10 下午5:03:22
 * @version V1.0
 */
public class TWechatReply {
    private Integer id;//主键编号

    private String keyword;//关键字/词

    private String keyType;//关键字/词索引方式（accurate:精确，vague:模糊）

    private String replyType;//回复类型（text:文本，news:图文）

    private String replyText;//回复内容

    private String newsImgLink;//图片地址（当reply_type=news时可用）

    private String newsTitle;//图文消息标题（当reply_type=news时可用）

    private String newsLink;//图文消息跳转地址（当reply_type=news时可用）

    private String status;//状态（open:启用，close:关闭）

    private String remark;//备注

    private Date createDate;//创建时间

    private Date updateDate;//修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType == null ? null : keyType.trim();
    }

    public String getReplyType() {
        return replyType;
    }

    public void setReplyType(String replyType) {
        this.replyType = replyType == null ? null : replyType.trim();
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText == null ? null : replyText.trim();
    }

    public String getNewsImgLink() {
        return newsImgLink;
    }

    public void setNewsImgLink(String newsImgLink) {
        this.newsImgLink = newsImgLink == null ? null : newsImgLink.trim();
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink == null ? null : newsLink.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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