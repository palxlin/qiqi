package com.csi.web.weixin.processor;

import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.reply.ReplyDetail;
import com.csi.web.weixin.reply.builder.ReplyBuilder;
import com.csi.web.weixin.reply.builder.TextReplyBuilder;

import java.util.List;

/**
 * Created by fanlin on 2017/10/11.
 */
public enum ReplyProcessorFactory {
    TEXT("text") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new TextReplyBuilder();
        }
    };

    private String replyType;

    private ReplyProcessorFactory(String replyType) {
        this.replyType = replyType;
    }

    protected abstract ReplyBuilder getReplyBuilder();

    public Reply buildReply(List<ReplyDetail> replyDetails) {

        if (replyDetails == null || replyDetails.isEmpty()) {
            return null;
        }

        return getReplyBuilder().buildReply(replyDetails);
    }

    public String getReplyType() {
        return replyType;
    }
}
