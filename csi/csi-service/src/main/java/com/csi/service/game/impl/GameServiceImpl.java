package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
import com.csi.model.game.GameVo;
import com.csi.model.game.ItemClueVo;
import com.csi.model.game.KillerVo;
import com.csi.model.game.PlayerVo;
import com.csi.service.game.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanlin on 2017/10/13.
 */
@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    IGameDao gameDao;

    @Override
    public Integer night1Killing(String killerUserNo, Integer itemPos, Integer cluePos) {

        try {

            gameDao.crime(killerUserNo, itemPos, cluePos);

            return 0;
        } catch (Exception e) {

            return -1;
        }
    }

    @Override
    public Integer night1Witness(String createUser, List<Integer> posList) {

        gameDao.witness(createUser,
                posList.get(0), posList.get(1), posList.get(2), posList.get(3), posList.get(4), posList.get(5), posList.get(6));

        return 0;
    }

    @Override
    public Integer judge(String judgeUser, Integer killerPos, Integer itemPos, Integer cluePos) {

        KillerVo killerVo = gameDao.selectKiller(judgeUser);

        if (killerVo.getKillerPos() == killerPos
                && killerVo.getKillerItemNo() == itemPos
                && killerVo.getKillerClueNo() == cluePos) {

            /**断案成功*/
            gameDao.succUpdateGame(judgeUser);
            gameDao.succUpdateGameDetail(judgeUser);
            gameDao.succUpdateGamePlayer(judgeUser);

            return 0;
        } else {
            gameDao.judgeFailedUpdateGamePlayer(judgeUser);
        }

        return 1;
    }

    @Override
    public GameVo lookCrimeItem(String userNo) {
        return gameDao.selectGameByUserNo(userNo);
    }

    @Override
    public List<PlayerVo> lookAllPlayer(String userNo) {
        /**看全场人员的工具和线索*/
        return gameDao.lookAllPlayer(userNo);
    }

    @Override
    public GameVo lookWitness(String userNo) {
        return null;
    }

}
