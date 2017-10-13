package com.csi.web.weixin.handler;

import com.csi.model.game.PlayerVo;
import com.csi.service.game.IGameCreateService;
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
 * Created by fanlin on 2017/10/12.
 */
public class JoinHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(JoinHandler.class);

    @Autowired
    IGameCreateService gameCreateService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();

        String[] params = textMessage.getContent().split(" ");
        if(params.length < 1){
            throw new WeixinException(ResponseCode.Weixin.JOIN_WRONG_PARAM);
        }
        Integer roomNo = Integer.parseInt(params[1]);

        PlayerVo playerVo= gameCreateService.joinGame(username, roomNo);

        String text = playerVo != null ?
                String.format("加入成功, 角色是[%d], 位置[%d], " +
                        "作案工具[%d, %d, %d, %d]" +
                        "作案线索[%d, %d, %d, %d]",
                        playerVo.getGameRole(), playerVo.getGamePos(),
                        playerVo.getCrimeItem1(), playerVo.getCrimeItem2(),
                        playerVo.getCrimeItem3(), playerVo.getCrimeItem4(),
                        playerVo.getCrimeClue1(), playerVo.getCrimeClue2(),
                        playerVo.getCrimeClue3(), playerVo.getCrimeClue4()) : "加入失败";

        return ReplyUtil.buildTextReply(text, message);

    }
}
