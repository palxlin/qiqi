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

    List<Integer> selectItemNoLocationOfCrime();

    void kill(@Param("killerUserNo") String killerUserNo, @Param("crimeItemPos") Integer crimeItemPos, @Param("crimeCluePos") Integer crimeCluePos);

    void witness(@Param("witnessUserNo") String witnessUserNo,
                 @Param("causePos") Integer causePos, @Param("locationPos") Integer locationPos,
                 @Param("clue1Pos") Integer clue1Pos, @Param("clue2Pos") Integer clue2Pos,
                 @Param("clue3Pos") Integer clue3Pos, @Param("clue4Pos") Integer clue4pos,
                 @Param("weight") Integer weight);

    List<Integer> selectItemNosWitnessClues();

    KillerVo selectKiller(@Param("userno") String userno);

    void succUpdateGame(@Param("userno") String userno);
    void succUpdateGameDetail(@Param("userno") String userno);
    void succUpdateGamePlayer(@Param("userno") String userno);

    void judgeFailedUpdateGamePlayer(@Param("userno") String userno);

    Integer hasRightJudge(@Param("userno") String userno);

    Integer selectGameByNo(@Param("gameNo") Integer gameNo);

    void joinGame(@Param("player") PlayerVo player);

    PlayerNumberVo selectAvailablePos(@Param("gameNo") Integer gameNo);

    Integer numbers(@Param("gameNo") Integer gameNo);
    Integer selectCount(@Param("gameNo") Integer gameNo);

    GameMysqlVo getGameByNo(@Param("gameNo") Integer gameNo);

    List<ItemClueUsedVo> selectItemClueUsed(Integer gameNo);

    List<Integer> selectAllItem();

    List<Integer> selectAllClue();
}
