package com.csi.web.weixin.util;

import com.csi.web.weixin.processor.ReplyProcessorFactory;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.reply.ReplyDetail;
import com.csi.web.weixin.reply.ReplyDetailWrapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by fanlin on 2017/10/11.
 */
public class ReplyUtil {

    public static Reply buildReply(Reply reply, Message message) {
        try {
            if (reply != null) {
                // keep is new instance
                Reply newReply = (Reply) BeanUtils.cloneBean(reply);

                newReply.setCreateTime(getUnixTimeStamp());
                newReply.setToUserName(message.getFromUserName());
                newReply.setFromUserName(message.getToUserName());

                return newReply;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static Reply buildTextReply(String msg, Message message){

        ReplyDetail replyDetail = new ReplyDetail();

        replyDetail.setDescription(msg);

        Reply reply = ReplyUtil.parseReplyDetailWarpper(new ReplyDetailWrapper("text", Arrays.asList(replyDetail)));

        return ReplyUtil.buildReply(reply, message);
    }

    public static Reply parseReplyDetailWarpper(ReplyDetailWrapper replyDetailWarpper) {
        if (replyDetailWarpper == null) {
            return null;
        }

        String replyType = replyDetailWarpper.getReplyType();
        ReplyProcessorFactory replyEnumFactory = EnumUtils.getEnum(ReplyProcessorFactory.class, StringUtils.upperCase(replyType));
        if (replyEnumFactory == null) {
            return null;
        }

        Reply buildReply = replyEnumFactory.buildReply(replyDetailWarpper.getReplyDetails());
        if (buildReply != null) {
//            buildReply.setFuncFlag(replyDetailWarpper.getFuncFlag());

            return buildReply;
        }

        return null;
    }

    public static long getUnixTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }
}
