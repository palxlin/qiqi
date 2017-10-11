package com.csi.web.weixin.reply.builder;

/**
 * Created by fanlin on 2017/10/11.
 */
public enum ReplyBuilderFactory {

    TEXT("text"){
        @Override
        protected ReplyBuilder getReplyBuilder() { return new TextReplyBuilder();}
    }
}
