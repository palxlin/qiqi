package com.csi.web.weixin.handler;

import com.csi.model.game.WitnessVo;
import com.csi.service.game.IGameParamService;
import com.csi.service.game.IGamePermissionService;
import com.csi.service.game.IGameService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlin on 2017/10/13.
 */
public class WitnessHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(WitnessHandler.class);

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
        boolean hasRight = gamePermissionService.hasRightWitness(username);
        if(!hasRight){
            throw new WeixinException(ResponseCode.Weixin.NO_RIGHT_WITNESS);
        }

        /**参数判断*/
        boolean isCorrectParam = gameParamService.isCorrectParamWitness(content);
        if(!isCorrectParam) {

            throw new WeixinException(ResponseCode.Weixin.WRONG_PARAM_WITNESS);
        }

        String[] cluePos = ParamUtils.parseParam(content);

        Integer causeOfDeathPos = Integer.parseInt(cluePos[1]);
        Integer locOfCrimePos = Integer.parseInt(cluePos[2]);
        Integer witnessClue1Pos = Integer.parseInt(cluePos[3]);
        Integer witnessClue2Pos = Integer.parseInt(cluePos[4]);
        Integer witnessClue3Pos = Integer.parseInt(cluePos[5]);
        Integer witnessClue4Pos = Integer.parseInt(cluePos[6]);
        Integer weight = Integer.parseInt(cluePos[7]);


        WitnessVo witnessVo = new WitnessVo();
        witnessVo.setCausePos(causeOfDeathPos);
        witnessVo.setLocationPos(locOfCrimePos);
        witnessVo.setClue1Pos(witnessClue1Pos);
        witnessVo.setClue2Pos(witnessClue2Pos);
        witnessVo.setClue3Pos(witnessClue3Pos);
        witnessVo.setClue4Pos(witnessClue4Pos);
        witnessVo.setWeight(weight);

        logger.info("user {} begin to witness ", username);

        gameService.night1Witness(username, witnessVo);

        String textReply = GameMessageUtil.weinessSucess();

        return ReplyUtil.buildTextReply(textReply, message);
    }
}
