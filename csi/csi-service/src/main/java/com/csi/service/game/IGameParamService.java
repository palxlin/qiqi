package com.csi.service.game;

/**
 * Created by fanlin on 2017/10/14.
 */
public interface IGameParamService {

    boolean isCorrectParamCreateGame(String params);
    boolean isCorrectParamJoinGame(String params);
    boolean isCorrectParamKill(String params);
    boolean isCorrectParamWitness(String params);

    boolean isCorrectParamLookAllPlayer(String content);
    boolean isCorrectParamLookCrime(String content);
    boolean isCorrectParamLookWitness(String content);

    boolean isCorrectParamDetectiveGame(String content);

}
