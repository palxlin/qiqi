package com.csi.web.weixin.reply.wrapper;

import com.csi.web.weixin.reply.wrapper.ReplyDetail;

import java.util.List;

/**
 * Created by fanlin on 2017/10/11.
 */
public class ReplyDetailWrapper {

    private String replyType;
    private int funcFlag = 0;
    private List<ReplyDetail> replyDetails;

    public ReplyDetailWrapper(String replyType, List<ReplyDetail> replyDetails) {
        this(replyType, 0, replyDetails);
    }

    public ReplyDetailWrapper(String replyType, int funcFlag, List<ReplyDetail> replyDetails) {
        this.replyType = replyType;
        this.funcFlag = funcFlag;
        this.replyDetails = replyDetails;
    }

    public String getReplyType() {
        return replyType;
    }

    public void setReplyType(String replyType) {
        this.replyType = replyType;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public List<ReplyDetail> getReplyDetails() {
        return replyDetails;
    }

    public void setReplyDetails(List<ReplyDetail> replyDetails) {
        this.replyDetails = replyDetails;
    }
}
