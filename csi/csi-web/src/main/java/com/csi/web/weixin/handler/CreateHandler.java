package com.csi.web.weixin.handler;

import com.csi.model.game.PlayerVo;
import com.csi.service.game.IGameCreateService;
import com.csi.service.game.IGameParamService;
import com.csi.service.game.IGamePermissionService;
import com.csi.service.utils.GameMessageUtil;
import com.csi.service.utils.ParamUtils;
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
public class CreateHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(CreateHandler.class);

    @Autowired
    IGameCreateService gameCreateService;

    @Autowired
    IGamePermissionService gamePermissionService;

    @Autowired
    IGameParamService gameParamService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();
        String content = textMessage.getContent();

        /**权限判断*/
        boolean hasRight = gamePermissionService.hasRightCreateGame(username);
        if(!hasRight){
            throw new WeixinException(ResponseCode.Weixin.NO_RIGHT_CREATE_GAME);
        }

        /**参数判断*/
        boolean isCorrectParam = gameParamService.isCorrectParamCreateGame(content);
        if(!isCorrectParam) {

            throw new WeixinException(ResponseCode.Weixin.WRONG_PARAM_CREATE_GAME);
        }

        Integer playernnums = Integer.parseInt(ParamUtils.parseParam(content)[1]);

        logger.info("user {} create a game with {} players", username, playernnums);

        Integer gameNo = gameCreateService.createGame(username, "0", playernnums);

        logger.info("user {} create a game with {} players success", username, playernnums);

        if (gameNo == null || gameNo == 0) {

            return ReplyUtil.buildTextReply("创建失败", message);
        }

        /**创建游戏者自动进入游戏*/
        PlayerVo playerVo= gameCreateService.joinGame(username, gameNo);

        String text = playerVo != null ?
                GameMessageUtil.createSuccess(gameNo, playerVo) :
                GameMessageUtil.createSuccessWithJoinFail(gameNo);

        return ReplyUtil.buildTextReply(text, message);

    }
}
