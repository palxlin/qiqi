package com.csi.web.weixin.reply.builder;

import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.reply.ReplyDetail;
import com.csi.web.weixin.reply.TextReply;

import java.util.List;

/**
 * Created by fanlin on 2017/10/11.
 */
public class TextReplyBuilder implements ReplyBuilder{
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {

        ReplyDetail detail = replyDetails.get(0);

        TextReply textReply = new TextReply();

        textReply.setMsgType(ReplyProcessorFactory.TEXT.getReplyType());

        textReply.setContent(detail.getDescription());

        return textReply;
    }
}
