package com.csi.web.weixin.handler;

import com.csi.service.utils.GameMessageUtil;
import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.util.ReplyUtil;
import com.csi.web.weixin.reply.Reply;

/**
 * Created by fanlin on 2017/10/12.
 */
public class HelpHandler extends Handler{

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        return ReplyUtil.buildTextReply(GameMessageUtil.help(), message);

    }
}
