package com.csi.web.weixin.handler;

import com.csi.service.game.IGameCreateService;
import com.csi.service.game.IGameService;
import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.receive.TextMessage;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.ReplyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fanlin on 2017/10/13.
 */
public class KillHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(KillHandler.class);

    @Autowired
    IGameService gameService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();

        Integer killItemPos = Integer.parseInt(textMessage.getContent().split(" ")[1]);
        Integer killcluePos = Integer.parseInt(textMessage.getContent().split(" ")[2]);

        logger.info("user {} begin to kill ", username);

        Integer gameNo = gameService.night1Killing(username, killItemPos, killcluePos);

        return ReplyUtil.buildTextReply(String.format("杀人成功：使用工具[%d], 相关线索[%d]", killItemPos, killcluePos), message);
    }
}
