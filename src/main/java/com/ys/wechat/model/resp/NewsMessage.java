package com.ys.wechat.model.resp;


/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:微信开发者-向用户推送消息-图文消息
 *
 * @author 吕志博
 * @date 2016-3-8 上午9:38:56
 * @version V1.0
 */
public class NewsMessage extends BaseMessage{

    // 图文消息个数，限制为10条以内  
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图  
    private Article[] Articles;
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }

	public Article[] getArticles() {
		return Articles;
	}

	public void setArticles(Article[] articles) {
		Articles = articles;
	}  
  

}  
