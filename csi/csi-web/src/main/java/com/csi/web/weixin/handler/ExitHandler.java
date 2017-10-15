package com.csi.web.weixin.handler;

import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.ReplyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fanlin on 2017/10/12.
 */
public class ExitHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(DetectiveHandler.class);

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        return ReplyUtil.buildTextReply("join", message);

    }
}
