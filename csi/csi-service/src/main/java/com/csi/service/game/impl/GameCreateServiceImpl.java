package com.csi.service.game.impl;

import com.csi.dao.game.IGameDao;
import com.csi.model.game.GameVo;
import com.csi.service.game.IGameCreateService;
import com.csi.util.NumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        GameVo gameVo = new GameVo(createUser, type, numOfPlayers);

        Integer gameNo = generateGameNo();
        gameVo.setGameNo(gameNo);

        gameDao.createGame(gameVo);

        logger.info("create game: {}", gameVo.toString());

        return gameNo;
    }

    private Integer generateGameNo() {

        return NumUtil.generate4Nums();
    }
}
