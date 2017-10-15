package com.csi.service.game;

import com.csi.model.game.GameVo;
import com.csi.model.game.ItemClueVo;
import com.csi.model.game.PlayerVo;

import java.util.List;

/**
 * Created by fanlin on 2017/10/13.
 */
public interface IGameService {

    /**凶手行凶*/
    Integer night1Killing(String createUser, Integer itemPos, Integer cluePos);
    /**目击者寻找相关线索*/
    Integer night1Witness(String createUser, List<Integer> witnessClues);

    /**警察断案*/
    Integer judge(String userNo, Integer crimePos, Integer crimeItemPos, Integer crimeCluePos);


    GameVo lookCrimeItem(String userNo);
    List<PlayerVo> lookAllPlayer(String userNo);
    GameVo lookWitness(String userNo);
}
