package com.csi.web.weixin.handler;

import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.ReplyUtil;

/**
 * Created by fanlin on 2017/10/12.
 */
public class HelpHandler extends Handler{

    private static final String HELP_MESSAGE = "" +
            "h - 帮助\n" +
            "c - 创建游戏\n" +
            "j - 加入游戏" ;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        return ReplyUtil.buildTextReply(HELP_MESSAGE, message);

    }
}
