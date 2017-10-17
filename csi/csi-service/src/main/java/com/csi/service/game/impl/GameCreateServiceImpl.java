package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
import com.csi.model.constants.enums.GameRoleEnum;
import com.csi.model.constants.enums.CardItemTypeEnum;
import com.csi.model.constants.enums.GameStatusEnums;
import com.csi.model.game.*;
import com.csi.service.game.IGameCreateService;
import com.csi.service.utils.GameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanlin on 2017/10/12.
 */
@Service
public class GameCreateServiceImpl implements IGameCreateService {

    private static final Logger logger = LoggerFactory.getLogger(GameCreateServiceImpl.class);

    @Autowired
    IGameDao gameDao;

    @Override
    public Integer createGame(String createUser, String type, Integer numOfPlayers) {

        Game game = GameUtils.createGameBean(createUser, type, numOfPlayers);
        GameDetail gameDetail = GameUtils.createGameDetailBean(game);

        List<CrimeScene> allCrimeScene = gameDao.selectAllCardCrimeScene();

        /**死亡原因*/
        List<CrimeScene> crimeSceneCauseOfDeath = GameUtils.filterCrimeScene(allCrimeScene, CardItemTypeEnum.CAUSE_OF_DEATH.getKey());
        CrimeScene causeOfDeath = GameUtils.random(crimeSceneCauseOfDeath, 1).get(0);
        gameDetail.setCauseOfDeath(causeOfDeath.getItemNo());
        gameDetail.setCauseOfDeathContent(causeOfDeath.getContent());

        /**随机案发地点牌*/
        List<CrimeScene> crimeSceneLocOfCrime = GameUtils.filterCrimeScene(allCrimeScene, CardItemTypeEnum.LOCATION_OF_CRIME.getKey());
        CrimeScene locationScene = GameUtils.random(crimeSceneLocOfCrime, 1).get(0);
        gameDetail.setLocationOfCrime(locationScene.getItemNo());
        gameDetail.setLocationOfCrimeContent(locationScene.getContent());

        /**随机4张蓝牌*/
        List<CrimeScene> crimeSceneWitnessClue = GameUtils.filterCrimeScene(allCrimeScene, CardItemTypeEnum.CLUE.getKey());
        List<CrimeScene> witnessClues = GameUtils.random(crimeSceneWitnessClue, 4);
        gameDetail.setWitnessClue(witnessClues);

        gameDao.createGame(game);
        gameDao.createGameDetail(gameDetail);

        logger.info("create game: {}", game.toString());

        return game.getGameNo();
    }

    @Override
    public PlayerVo joinGame(String username, Integer gameNo) {

        /**判断房间号存在*/
        Integer result = gameDao.selectCountGameByNo(gameNo);

        logger.info("user {} join game: {}", username, gameNo); PlayerVo playerVo = GameUtils.createGamePlayerVo(username, gameNo);
        GameMysqlVo game = gameDao.getGameByNo(gameNo);
        Integer selectCount = gameDao.selectCount(gameNo);
        if (selectCount < game.getNums()) {

            Integer gamePos = selectCount + 1;
            playerVo.setGamePos(gamePos);
            playerVo.setGameNums(game.getNums());

            if(gamePos == game.getPos_of_witness_user()){

                playerVo.setGameRole(GameRoleEnum.WITNESS.getKey()); // 1 witnes , 2 killer 3. killer assist
            } else if(gamePos == game.getPos_of_crime_user()){

                playerVo.setGameRole(GameRoleEnum.MURDER.getKey());
            } else if(gamePos == game.getPos_of_crime_ass_user()) {

                playerVo.setGameRole(GameRoleEnum.MURDER_ASSIST.getKey());
            } else {

                playerVo.setGameRole(GameRoleEnum.DETECTIVE.getKey());
            }

            playerVo.setGameWitness(game.getPos_of_witness_user());
            playerVo.setGameCrime(game.getPos_of_crime_user());
            playerVo.setGameCrimeAss(game.getPos_of_crime_ass_user());

            List<ItemClueUsedVo> itemClueVoUsedList = gameDao.selectItemClueUsed(gameNo);
            List<ItemClueVo> itemAllList = gameDao.selectAllItem(CardItemTypeEnum.CRIME_ITEM.getKey());
            List<ItemClueVo> clueAllList = gameDao.selectAllItem(CardItemTypeEnum.CRIME_CLUE.getKey());
            List<Integer> itemClueUsedList = GameUtils.parseVoList(itemClueVoUsedList);

            List<ItemClueVo> itemList = GameUtils.find4(itemAllList, itemClueUsedList);
            List<ItemClueVo> clueList = GameUtils.find4(clueAllList, itemClueUsedList);

            PlayerVo playerVo1 = GameUtils.setPlayerItem(playerVo, itemList, clueList) ;

            gameDao.joinGame(playerVo1);

            if(selectCount == game.getNums() - 1){
                /**人数已齐，更新游戏状态*/
                gameDao.updateGameStatus(gameNo, GameStatusEnums.NIGHT_1_CRIME.getId(), GameStatusEnums.STARTING.getId());
            }

            logger.info("user {} join game: {} succes", username, gameNo);

            return playerVo;
        } else {
            /**超人数，不能再加入了*/
            logger.info("user {} join game: {} failed", username, gameNo);

            /**加入失败*/
            return null;
        }

    }

}
