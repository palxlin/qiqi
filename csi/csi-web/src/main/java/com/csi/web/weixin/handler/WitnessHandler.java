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

        String[] cluePos = textMessage.getContent().split(" ");

        Integer causeOfDeathPos = Integer.parseInt(cluePos[1]);
        Integer locOfCrimePos = Integer.parseInt(cluePos[2]);
        Integer witnetssClue1Pos = Integer.parseInt(cluePos[3]);
        Integer witnetssClue2Pos = Integer.parseInt(cluePos[4]);
        Integer witnetssClue3Pos = Integer.parseInt(cluePos[5]);
        Integer witnetssClue4Pos = Integer.parseInt(cluePos[6]);
        Integer weight = Integer.parseInt(cluePos[7]);

        List<Integer> posList = new ArrayList<>();
        posList.add(causeOfDeathPos);
        posList.add(locOfCrimePos);
        posList.add(witnetssClue1Pos);
        posList.add(witnetssClue2Pos);
        posList.add(witnetssClue3Pos);
        posList.add(witnetssClue4Pos);
        posList.add(weight);

        logger.info("user {} begin to witness ", username);

        gameService.night1Witness(username, posList);

        String textReply = GameMessageUtil.weinessSucess();

        return ReplyUtil.buildTextReply(textReply, message);
    }
}
