package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
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

        List<Integer> locationCounts = gameDao.selectItemNoLocationOfCrime();
        Integer locationIndex = GameUtils.generatePos(locationCounts.size()) - 1;
        gameDetail.setLocationOfCrime(locationCounts.get(locationIndex));

        /**蓝牌*/
        List<Integer> witnesClues = gameDao.selectItemNosWitnessClues();
        List<Integer> random4Clues = GameUtils.random4(witnesClues);
        gameDetail.setClue1(random4Clues.get(0));
        gameDetail.setClue2(random4Clues.get(1));
        gameDetail.setClue3(random4Clues.get(2));
        gameDetail.setClue4(random4Clues.get(3));

        gameDao.createGame(game);
        gameDao.createGameDetail(gameDetail);

        logger.info("create game: {}", game.toString());

        return game.getGameNo();
    }

    @Override
    public PlayerVo joinGame(String username, Integer gameNo) {

        /**判断房间号存在*/
        Integer result = gameDao.selectGameByNo(gameNo);

        logger.info("user {} join game: {}", username, gameNo);

        PlayerVo playerVo = GameUtils.createGamePlayerVo(username, gameNo);

        GameMysqlVo game = gameDao.getGameByNo(gameNo);
        Integer selectCount = gameDao.selectCount(gameNo);
        if (selectCount < game.getNums()) {
            Integer gamePos = selectCount + 1;
            playerVo.setGamePos(gamePos);

            if(gamePos == game.getPos_of_witness_user()){
                playerVo.setGameRole(1); // 1 witnes , 2 killer 3. killer assist
            } else if(gamePos == game.getPos_of_crime_user()){
                playerVo.setGameRole(2);
            } else if(gamePos == game.getPos_of_crime_ass_user()) {
                playerVo.setGameRole(3);
            } else {
                playerVo.setGameRole(0);
            }

            List<ItemClueUsedVo> itemClueVoUsedList = gameDao.selectItemClueUsed(gameNo);
            List<Integer> itemAllList = gameDao.selectAllItem();
            List<Integer> clueAllList = gameDao.selectAllClue();
            List<Integer> itemClueUsedList = GameUtils.parseVoList(itemClueVoUsedList);

            List<Integer> itemList = GameUtils.find4(itemAllList, itemClueUsedList);
            List<Integer> clueList = GameUtils.find4(clueAllList, itemClueUsedList);

            playerVo.setCrimeItem1(itemList.get(0));
            playerVo.setCrimeItem2(itemList.get(1));
            playerVo.setCrimeItem3(itemList.get(2));
            playerVo.setCrimeItem4(itemList.get(3));

            playerVo.setCrimeClue1(clueList.get(0));
            playerVo.setCrimeClue2(clueList.get(1));
            playerVo.setCrimeClue3(clueList.get(2));
            playerVo.setCrimeClue4(clueList.get(3));

            gameDao.joinGame(playerVo);
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
