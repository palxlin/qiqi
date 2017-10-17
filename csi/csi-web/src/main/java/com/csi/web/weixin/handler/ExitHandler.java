package com.csi.web.weixin.handler;

import com.csi.service.game.IGameParamService;
import com.csi.service.game.IGamePermissionService;
import com.csi.service.game.IGameService;
import com.csi.service.utils.GameMessageUtil;
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
public class ExitHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(DetectiveHandler.class);

    @Autowired
    IGameService gameService;

    @Autowired
    IGameParamService gameParamService;

    @Autowired
    IGamePermissionService gamePermissionService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();

        /**权限判断*/
        boolean hasRight = gamePermissionService.hasRightExitGame(username);
        if(!hasRight){
            throw new WeixinException(ResponseCode.Weixin.NO_RIGHT_EXIT_GAME);
        }

        /**参数判断
        boolean isCorrectParam = gameParamService.isCorrectParamExitGame(content);
        if(!isCorrectParam) {
            throw new WeixinException(ResponseCode.Weixin.WRONG_PARAM_EXIT_GAME);
        }
        */
        gameService.playerExit(username);

        String textExit = GameMessageUtil.textExit();

        return ReplyUtil.buildTextReply(textExit, message);

    }
}
