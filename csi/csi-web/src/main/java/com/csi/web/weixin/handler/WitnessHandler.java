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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlin on 2017/10/13.
 */
public class WitnessHandler extends Handler{

    private static final Logger logger = LoggerFactory.getLogger(WitnessHandler.class);

    @Autowired
    IGameService gameService;

    @Override
    public Reply handleEvent(Message message) throws WeixinException {

        TextMessage textMessage = (TextMessage) message;

        String username = textMessage.getFromUserName();

        String[] cluePos = textMessage.getContent().split(" ");
        if(cluePos.length < 7){
            throw new WeixinException(ResponseCode.Weixin.WITNESS_WRONG_PARAM);
        }

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

        return ReplyUtil.buildTextReply(String.format("目击者选择结束" ), message);
    }
}
