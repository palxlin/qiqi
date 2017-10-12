package com.csi.service.game;

/**
 * Created by fanlin on 2017/10/12.
 */
public interface IGameCreateService {

    Integer createGame(String createUser, String type, Integer numOfPlayers);
}
