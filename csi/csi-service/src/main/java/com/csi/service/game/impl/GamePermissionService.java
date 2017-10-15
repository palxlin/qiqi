package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
import com.csi.model.constants.enums.GameRoleEnum;
import com.csi.model.constants.enums.GameStatusEnums;
import com.csi.service.game.IGamePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by fanlin on 2017/10/14.
 */
@Service
public class GamePermissionService implements IGamePermissionService {

    private static final Logger logger = LoggerFactory.getLogger(GamePermissionService.class);

    @Autowired
    IGameDao gameDao;

    @Override
    public boolean hasRightCreateGame(String userNo) {

        boolean notInAnyGame = notInAnyGame(userNo);

        return notInAnyGame;
    }

    @Override
    public boolean hasRightJoinGame(String userNo) {

        boolean notInAnyGame = notInAnyGame(userNo);

        return notInAnyGame;
    }

    @Override
    public boolean hasRightKill(String username) {

        Integer result = gameDao.hasRight(username, GameRoleEnum.MURDER.getKey(), GameStatusEnums.NIGHT_1_CRIME.getId());

        return result >= 1;
    }

    @Override
    public boolean hasRightKillAssist(String username) {

        Integer result = gameDao.hasRight(username, GameRoleEnum.MURDER_ASSIST.getKey(), GameStatusEnums.NIGHT_2_CRIME_ASSIST.getId());

        return result >= 1;
    }

    @Override
    public boolean hasRightWitness(String username) {

        Integer result = gameDao.hasRight(username, GameRoleEnum.WITNESS.getKey(), GameStatusEnums.NIGHT_1_WITNESS.getId());

        return result >= 1;
    }

    @Override
    public boolean hasRightDetectiveGame(String username) {

        Integer result = gameDao.hasRightByRoleStatusArray(
                username,
                new Integer[]{GameRoleEnum.DETECTIVE.getKey(), GameRoleEnum.MURDER.getKey(), GameRoleEnum.MURDER_ASSIST.getKey()},
                GameStatusEnums.dayPhase());

        return result >= 1;
    }

    @Override
    public boolean hasRightLookAllPlayer(String username) {
        return true;
    }

    @Override
    public boolean hasRightLookCrime(String username) {
        Integer result = gameDao.hasRightByRoleStatusArray(
                username,
                new Integer[]{GameRoleEnum.WITNESS.getKey(), GameRoleEnum.MURDER.getKey(), GameRoleEnum.MURDER_ASSIST.getKey()},
                GameStatusEnums.lookCrimePhase());
        return result >= 1;
    }

    @Override
    public boolean hasRightLookWitness(String username) {
        Integer result = gameDao.hasRightByRoleStatusArray(
                username,
                null,
                GameStatusEnums.lookWitnessPhase());
        return result >= 1;
    }

    private boolean notInAnyGame(String userNo) {

        Integer result = gameDao.selectCountInGame(userNo);

        return result < 1;
    }
}
