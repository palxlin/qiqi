package com.csi.web.weixin.handler;

import com.csi.model.game.GameVo;
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
 * Created by fanlin on 2017/10/15.
 */
public class LookWitnessHandler extends Handler {

    private static final Logger logger = LoggerFactory.getLogger(LookWitnessHandler.class);

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
        boolean hasRight = gamePermissionService.hasRightLookWitness(username);
        if (!hasRight) {
            throw new WeixinException(ResponseCode.Weixin.NO_RIGHT_LOOK_WITNESS);
        }

        /**参数判断
         boolean isCorrectParam = gameParamService.isCorrectParamLookCrime(content);
         if (!isCorrectParam) {

         throw new WeixinException(ResponseCode.Weixin.WRONG_PARAM_KK);
         }
         */

        GameVo gameVo = gameService.lookWitness(username);

        String text = GameMessageUtil.textLookWitness(gameVo);

        return ReplyUtil.buildTextReply(text, message);

    }
}
