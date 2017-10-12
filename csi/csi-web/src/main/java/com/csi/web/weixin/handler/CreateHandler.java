package com.csi.web.weixin.handler;

import com.csi.service.game.IGameCreateService;
import com.csi.web.weixin.exception.WeixinException;
import com.csi.web.weixin.receive.Message;
import com.csi.web.weixin.receive.TextMessage;
import com.csi.web.weixin.reply.Reply;
import com.csi.web.weixin.util.ReplyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fanlin on 2017/10/12.
 */
public class CreateHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(CreateHandler.class);

    @Autowired
    IGameCreateService gameCreateService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();

        Integer playerno = Integer.parseInt(textMessage.getContent().split(" ")[1]);

        logger.info("user {} create a game with {} players", username, playerno);

        Integer gameNo = gameCreateService.createGame(username, "0", playerno);

        logger.info("user {} create a game with {} players success", username, playerno);

        return ReplyUtil.buildTextReply(String.format("创建成功：游戏房间号为[%d]", gameNo), message);

    }
}
