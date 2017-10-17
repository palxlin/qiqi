package com.csi.web.weixin.handler;

import com.csi.service.utils.GameMessageUtil;
import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.reply.wrapper.ReplyDetail;
import com.csi.web.weixin.util.ReplyUtil;
import com.csi.web.weixin.reply.Reply;

/**
 * Created by fanlin on 2017/10/12.
 */
public class HelpHandler extends Handler{

//    @Override
//    public Reply handleEvent(Message message) throws WeixinException {
//
//        return ReplyUtil.buildTextReply(GameMessageUtil.help(), message);
//    }

    public Reply handleEvent(Message message) throws WeixinException {

        ReplyDetail replyDetail1 = new ReplyDetail();
        replyDetail1.setTitle("fork me");
        replyDetail1.setMediaUrl("http://47.91.242.114/csi-image/sample/findings/finding_01.png");
        replyDetail1.setUrl("http://47.91.242.114/csi-image/sample/findings/finding_01.png");
//        replyDetail1.setUrl("https://www.baidu.com");
        replyDetail1.setDescription(GameMessageUtil.help());

        ReplyDetail replyDetail2 = new ReplyDetail();
        replyDetail2.setTitle("star me");
        replyDetail2.setMediaUrl("http://47.91.242.114/csi-image/sample/findings/finding_02.png");
        replyDetail2.setUrl("https://www.bing.com");
        replyDetail2.setDescription("瞅你咋滴");

        return ReplyUtil.buildNewsReply(message, replyDetail1);
    }
}
