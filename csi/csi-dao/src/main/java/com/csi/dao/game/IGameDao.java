package com.csi.dao.game;

import com.csi.model.game.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanlin on 2017/10/12.
 */
public interface IGameDao {

    void createGame(@Param("game") Game game);
    void createGameDetail(@Param("gameDetail") GameDetail gameDetail);

    List<CrimeScene> selectItemNoLocationOfCrime();

    void crime(@Param("killerUserNo") String killerUserNo, @Param("crimeItemPos") Integer crimeItemPos, @Param("crimeCluePos") Integer crimeCluePos);

    void witness(@Param("witnessUserNo") String witnessUserNo,
                 @Param("causePos") Integer causePos, @Param("locationPos") Integer locationPos,
                 @Param("clue1Pos") Integer clue1Pos, @Param("clue2Pos") Integer clue2Pos,
                 @Param("clue3Pos") Integer clue3Pos, @Param("clue4Pos") Integer clue4pos,
                 @Param("weight") Integer weight);

    List<CrimeScene> selectCardCrimeScene(@Param("itemType") Integer itemType);
    List<CrimeScene> selectAllCardCrimeScene();

    KillerVo selectKiller(@Param("userno") String userno);

    void succUpdateGame(@Param("userno") String userno);
    void succUpdateGameDetail(@Param("userno") String userno);
    void succUpdateGamePlayer(@Param("userno") String userno);

    void judgeFailedUpdateGamePlayer(@Param("userno") String userno);

    Integer selectCountInGame(@Param("userNo") String userno);

    Integer selectCountGameByNo(@Param("gameNo") Integer gameNo);

    void joinGame(@Param("player") PlayerVo player);

//    PlayerNumberVo selectAvailablePos(@Param("gameNo") Integer gameNo);

//    Integer numbers(@Param("gameNo") Integer gameNo);
    Integer selectCount(@Param("gameNo") Integer gameNo);

    GameMysqlVo getGameByNo(@Param("gameNo") Integer gameNo);

    List<ItemClueUsedVo> selectItemClueUsed(Integer gameNo);

    List<ItemClueVo> selectAllItem(@Param("itemType") Integer itemType);

    Integer hasRightByStatusArray(@Param("userNo") String userno, @Param("gameRole") Integer gameRole, @Param("gameStatus") Integer[] status);
    Integer hasRightByRoleStatusArray(@Param("userNo") String userno, @Param("gameRole") Integer[] gameRole, @Param("gameStatus") Integer[] status);
    Integer hasRight(@Param("userNo") String userno, @Param("gameRole") Integer gameRole, @Param("gameStatus") Integer gameStatus);

    /**查询游戏信息*/
    GameVo selectGameByNo(@Param("gameNo") Integer gameNo);
    GameVo selectGameByUserNo(@Param("userNo") String userNo);

    /**查看所有玩家的工具和线索*/
    List<PlayerVo> lookAllPlayer(@Param("userNo") String userNo);

}
