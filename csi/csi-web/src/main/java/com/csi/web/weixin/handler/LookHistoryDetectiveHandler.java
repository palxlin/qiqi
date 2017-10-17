package com.csi.web.weixin.handler;

import com.csi.model.game.GameVo;
import com.csi.model.game.PlayerVo;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fanlin on 2017/10/16.
 */
public class LookHistoryDetectiveHandler extends Handler{

    @Autowired
    IGameService gameService;

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
        boolean hasRight = gamePermissionService.hasRightLookAllHistory(username);
        if (!hasRight) {
            throw new WeixinException(ResponseCode.Weixin.NO_RIGHT_LOOK_ALL_HISTORY);
        }

        /**参数判断*/
        boolean isCorrectParam = gameParamService.isCorrectParamLookAllHistory(content);
        if (!isCorrectParam) {

            throw new WeixinException(ResponseCode.Weixin.WRONG_PARAM_LOOK_ALL_HISTORY);
        }

        List<PlayerVo> playerVos = gameService.lookAllPlayer(username);

        String text = GameMessageUtil.textAllHistory(playerVos);

        return ReplyUtil.buildTextReply(text, message);

    }
}
