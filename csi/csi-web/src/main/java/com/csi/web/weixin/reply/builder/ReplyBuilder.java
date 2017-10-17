package com.csi.web.weixin.reply.builder;

import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.reply.wrapper.ReplyDetail;

import java.util.List;

/**
 * Created by fanlin on 2017/10/11.
 */
public interface ReplyBuilder {

    Reply buildReply(List<ReplyDetail> replyDetails);
}
