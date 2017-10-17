package com.csi.web.weixin.reply.builder;

import com.csi.web.weixin.processor.ReplyProcessorFactory;
import com.csi.web.weixin.reply.NewsReply;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.reply.detail.NewsDetail;
import com.csi.web.weixin.reply.wrapper.ReplyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlin on 2017/10/17.
 */
public class NewsReplyBuilder implements ReplyBuilder{
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        int size = replyDetails.size();
        List<NewsDetail> articles = new ArrayList<>(size);

        NewsReply newsReply = new NewsReply();
        newsReply.setMsgType(ReplyProcessorFactory.NEWS.getReplyType());
        newsReply.setArticleCount(size);
        newsReply.setArticles(articles);

        for(ReplyDetail replyDetailVo : replyDetails){
            articles.add(new NewsDetail(replyDetailVo.getTitle(),
                            replyDetailVo.getDescription(),
                            replyDetailVo.getMediaUrl(),
                            replyDetailVo.getUrl()));
        }
        return newsReply;
    }
}
