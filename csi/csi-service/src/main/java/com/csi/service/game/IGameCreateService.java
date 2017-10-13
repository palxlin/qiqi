package com.csi.service.game;

import com.csi.model.game.PlayerVo;

/**
 * Created by fanlin on 2017/10/12.
 */
public interface IGameCreateService {

    /**创建游戏*/
    Integer createGame(String createUser, String type, Integer numOfPlayers);

    /**加入游戏*/
    PlayerVo joinGame(String username, Integer roomNo);
}
