package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
import com.csi.model.game.KillerVo;
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

        gameDao.kill(killerUserNo, itemPos, cluePos);

        return 0;
    }

    @Override
    public Integer night1Witness(String createUser, List<Integer> posList) {

        gameDao.witness(createUser,
                posList.get(0), posList.get(1), posList.get(2), posList.get(3), posList.get(4), posList.get(5), posList.get(6));
        return null;
    }

    @Override
    public Integer judge(String judgeUser, Integer killerPos, Integer itemPos, Integer cluePos) {

        /**检查当前用户是否可以断案*/
        boolean hasRightJudge = gameDao.hasRightJudge(judgeUser) >= 1 ? true : false;
        if(!hasRightJudge){
            return -1;
        }

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
}
