package com.csi.web.weixin.handler;

import com.csi.service.game.IGameService;
import com.csi.web.weixin.exception.ResponseCode;
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
public class JudgeHandler extends Handler{
    private static final Logger logger = LoggerFactory.getLogger(JudgeHandler.class);

    @Autowired
    IGameService gameService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();

        String[] cluePos = textMessage.getContent().split(" ");
        if(cluePos.length < 3){
            throw new WeixinException(ResponseCode.Weixin.JUDGE_WRONG_PARAM);
        }

        Integer killerPos = Integer.parseInt(textMessage.getContent().split(" ")[1]);
        Integer killItemPos = Integer.parseInt(textMessage.getContent().split(" ")[2]);
        Integer killcluePos = Integer.parseInt(textMessage.getContent().split(" ")[3]);

        logger.info("user {} begin to judge", username);

        Integer isSuccess = gameService.judge(username, killerPos, killItemPos, killcluePos);
        String text = "";
        if(isSuccess == 0)
            text = "断案成功";
        else if (isSuccess == 1)
            text = "断案失败";
        else if (isSuccess == -1)
            text = "未加入正常的游戏，不能断案";

        logger.info("user {} ", username, text);

        return  ReplyUtil.buildTextReply(String.format(text), message);

    }
}
