package com.csi.service.game;

/**
 * Created by fanlin on 2017/10/14.
 */
public interface IGamePermissionService {

    boolean hasRightCreateGame(String userno);
    boolean hasRightJoinGame(String userno);

    boolean hasRightKill(String username);
    boolean hasRightKillAssist(String username);
    boolean hasRightWitness(String username);

    boolean hasRightLookAllPlayer(String username);  /**查看全部游戏人员的工具和线索*/
    boolean hasRightLookCrime(String username); /**查看凶手作案工具和线索*/
    boolean hasRightLookWitness(String username);

    boolean hasRightDetectiveGame(String username);

    boolean hasRightExitGame(String username);

    boolean hasRightLookAllHistory(String username);

    boolean hasRightLookGameStatus(String username); /**查看凶手作案工具和线索*/
}
