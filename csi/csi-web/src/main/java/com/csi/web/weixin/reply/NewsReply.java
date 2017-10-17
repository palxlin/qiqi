package com.csi.web.weixin.reply;

import com.csi.web.weixin.reply.detail.NewsDetail;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by fanlin on 2017/10/17.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsReply extends Reply{
    @XmlElement(name = "ArticleCount")
    private int articleCount;

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    private List<NewsDetail> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<NewsDetail> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsDetail> articles) {
        this.articles = articles;
    }
}
