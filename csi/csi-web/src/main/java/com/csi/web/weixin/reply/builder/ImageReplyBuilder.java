package com.csi.web.weixin.reply.builder;

import com.csi.web.weixin.processor.ReplyProcessorFactory;
import com.csi.web.weixin.reply.ImageReply;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.reply.wrapper.ReplyDetail;
import com.csi.web.weixin.reply.detail.MediaDetail;

import java.util.List;

/**
 * Created by fanlin on 2017/10/17.
 */
public class ImageReplyBuilder implements ReplyBuilder{
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        MediaDetail imageDetail = new MediaDetail();
        imageDetail.setMediaId(detail.getMediaUrl());

        ImageReply imageReply = new ImageReply();
        imageReply.setMsgType(ReplyProcessorFactory.IMAGE.getReplyType());
        imageReply.setImageDetail(imageDetail);

        return imageReply;
    }
}
