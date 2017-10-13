package com.csi.service.game;

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
    Integer judge(String createUser, Integer killerPos, Integer ItemPos, Integer CluePos);


}
