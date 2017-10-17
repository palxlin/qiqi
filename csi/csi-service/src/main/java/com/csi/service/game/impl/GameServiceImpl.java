package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
import com.csi.model.constants.enums.DetectiveStatusEnum;
import com.csi.model.constants.enums.GameStatusEnums;
import com.csi.model.game.GameVo;
import com.csi.model.game.CrimeVo;
import com.csi.model.game.PlayerVo;
import com.csi.model.game.WitnessVo;
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
    public Integer night1Killing(String crimeUserNo, Integer itemPos, Integer cluePos) {

        try {

            gameDao.crime(crimeUserNo, itemPos, cluePos);

            gameDao.updateGameStatusByUserNo(crimeUserNo, GameStatusEnums.NIGHT_1_WITNESS.getId(), null);

            return 0;
        } catch (Exception e) {

            return -1;
        }
    }

    @Override
    public Integer night1Witness(String witnessUser, WitnessVo witnessVo) {

        gameDao.witness(witnessUser, witnessVo);
//                posList.get(0), posList.get(1), posList.get(2), posList.get(3), posList.get(4), posList.get(5), posList.get(6));

        gameDao.updateGameStatusByUserNo(witnessUser, GameStatusEnums.DAY_1_V4JUDGE.getId(), GameStatusEnums.NIGHT_1_WITNESS.getId());

        return 0;
    }

    @Override
    public Integer judge(String judgeUser, Integer killerPos, Integer itemPos, Integer cluePos) {

        CrimeVo crimeVo = gameDao.selectCrime(judgeUser);

        if (crimeVo.getCrimePos() == killerPos
                && crimeVo.getCrimeItemPos() == itemPos
                && crimeVo.getCrimeCluePos() == cluePos) {

            /**断案成功*/
            gameDao.succUpdateGame(judgeUser);
            gameDao.succUpdateGameDetail(judgeUser);
            gameDao.updateGamePlayer(judgeUser, GameStatusEnums.COMPLETED_DETECT_SUCC.getId(), new CrimeVo(killerPos, itemPos, cluePos));

            return 0;
        } else {
//            gameDao.judgeFailedUpdateGamePlayer(judgeUser);
            gameDao.detectiveFail(judgeUser, DetectiveStatusEnum.FAIL.getId(), DetectiveStatusEnum.NORMAL.getId());
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
        return gameDao.selectGameByUserNo(userNo);
    }

    @Override
    public GameVo lookGameStatus(String userNo) {
        return gameDao.selectGameByUserNo(userNo);
    }

    @Override
    public void playerExit(String username){

        gameDao.playerExit(username, DetectiveStatusEnum.EXIT.getId());
    }

}
