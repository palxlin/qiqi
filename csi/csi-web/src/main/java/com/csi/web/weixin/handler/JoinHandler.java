package com.csi.web.weixin.handler;

import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.ReplyUtil;

/**
 * Created by fanlin on 2017/10/12.
 */
public class JoinHandler extends Handler{

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        return ReplyUtil.buildTextReply("join", message);

    }
}
